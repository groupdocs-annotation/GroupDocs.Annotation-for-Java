(function () {
    'use strict';

    function main($rootScope, cfpLoadingBar, AnnotationFactory, AnnotationAddFactory) {
        return {
            restrict: 'E',
            link: {
                pre: function (scope, element, attrs) {
                },
                post: function (scope, element, attrs) {
                    setupCanvas($rootScope, scope, element, attrs);
                    setupPageImage($rootScope, scope, element, attrs);
                    setupDrawingTools($rootScope, AnnotationFactory, AnnotationAddFactory, scope, element, attrs);
                    // setupAnnotations has been moved to pageImage.onLoad
                    setupAnnotationDeletion($rootScope, AnnotationFactory, scope, element, attrs);
                }
            }
        }
    }

    function setupCanvas($rootScope, scope, element, attrs) {
        element.css('width', attrs.width + 'px');
        element.css('height', attrs.height + 'px');

        var canvas = document.createElement("canvas");
        canvas.setAttribute('width', attrs.width);
        canvas.setAttribute('height', attrs.height);
        canvas.setAttribute("id", "page-canvas-" + attrs.number);
        element.append(canvas);

        var paperScope = new paper.PaperScope();
        paperScope.setup(canvas);
        scope.paperScopeId = paperScope._id;
    }

    function setupPageImage($rootScope, scope, element, attrs) {
        var ps = paper.PaperScope.get(scope.paperScopeId);

        var pageImageUrl = "/page/image"
            + "?file=" + attrs.file
            + "&page=" + attrs.number
            + "&width=" + attrs.width
            + "&height=" + attrs.height;

        var loadingIndicator = new ps.Raster({
            source: '/loading_indicator.gif',
            position: ps.view.center
        });

        var pageImage = new ps.Raster({
            source: pageImageUrl,
            position: ps.view.center
        });

        pageImage.onLoad = function () {
            pageImage.scale(attrs.width / pageImage.width);
            setupAnnotations($rootScope, scope, element, attrs);
            loadingIndicator.remove();
        };
    }

    function setupDrawingTools($rootScope, AnnotationFactory, AnnotationAddFactory, scope, element, attrs) {
        var ps = paper.PaperScope.get(scope.paperScopeId);

        var currentObject = null;
        ps.tool = new ps.Tool();
        ps.tool.minDistance = 3;

        ps.tool.onMouseDown = function (event) {
            var hitResult = ps.project.activeLayer.hitTest(event.point, {
                segments: true,
                stroke: true,
                fill: true,
                tolerance: 0
            });

            ps.project.deselectAll();

            switch ($rootScope.selectedDrawingTool) {
                case 'select':
                    if (hitResult && hitResult.item.name) {
                        currentObject = hitResult.item;
                        currentObject.selected = true;
                        $rootScope.selectedAnnotationGuid = currentObject.name;
                        if (!$rootScope.$$phase) {
                            $rootScope.$apply();
                        }
                    }
                    else if (hitResult && hitResult.item._parent._name) {
                        currentObject = hitResult.item._parent;
                        currentObject.selected = true;
                        $rootScope.selectedAnnotationGuid = currentObject._name;
                        if (!$rootScope.$$phase) {
                            $rootScope.$apply();
                        }
                    }
                    break;
                case 'rectangle':
                    var shape = new ps.Rectangle(event.point.x, event.point.y, 1, 1);
                    currentObject = new ps.Path.Rectangle(shape);
                    currentObject.strokeColor = 'black';
                    currentObject.strokeWidth = 2;
                    break;
                case 'pencil':
                    currentObject = new ps.Path();
                    currentObject.add(event.point);
                    currentObject.strokeColor = 'black';
                    currentObject.strokeWidth = 2;
                    break;
                case 'point':
                    var pt = new ps.Shape.Circle(event.point, 3);
                    currentObject = pt.toPath(true);
                    currentObject.strokeColor = 'black';
                    currentObject.fillColor = 'black';
                    currentObject.strokeWidth = 2;
                    break;
            }
        };

        ps.tool.onMouseDrag = function (event) {
            switch ($rootScope.selectedDrawingTool) {
                case 'select':
                    angular.forEach(scope.annotationsList, function (item) {
                        if (currentObject && item.annotation.guid === currentObject.name && item.annotation.type === 4 && item.annotation.type === 8) {
                            currentObject = null;
                        }
                    });
                    if (currentObject) {
                        currentObject.position.x += event.delta.x;
                        currentObject.position.y += event.delta.y;
                    }
                    break;
                case 'rectangle':
                    currentObject.bounds.width += event.delta.x;
                    currentObject.bounds.height += event.delta.y;
                    break;
                case 'pencil':
                    currentObject.add(event.point);
                    break;
                case 'point':
                    currentObject.position.x += event.delta.x;
                    currentObject.position.y += event.delta.y;
                    break;
                case 'arrow':
                    if (currentObject) {
                        currentObject.remove();
                    }
                    var start = new ps.Point(event.downPoint);
                    var end = new ps.Point(event.point);

                    var tailLine = new ps.Path.Line(start, end);
                    var tailVector = end.subtract(start);
                    var headLine = tailVector.normalize(10);

                    currentObject = new ps.Group([
                        new ps.Path([start, end]),
                        new ps.Path([
                            end.add(headLine.rotate(150)),
                            end,
                            end.add(headLine.rotate(-150))
                        ])
                    ]);
                    currentObject.strokeColor = 'black';
                    currentObject.strokeWidth = 2;
                    break;
            }
        };

        ps.tool.onMouseUp = function (event) {
            var ant = {};

            switch ($rootScope.selectedDrawingTool) {
                case 'select':
                    if (currentObject && (event.delta.x !== 0 || event.delta.y !== 0)) {
                        AnnotationFactory.updatePosition(
                            {
                                guid: currentObject.name
                            },
                            {
                                x: currentObject.bounds.x,
                                y: currentObject.bounds.y
                            }
                        );
                    }
                    break;
                case 'rectangle':
                    ant = {
                        box: {
                            x: currentObject.bounds.x,
                            y: currentObject.bounds.y,
                            width: currentObject.bounds.width,
                            height: currentObject.bounds.height
                        },
                        type: 1
                    };
                    break;
                case 'pencil':
                    ant.type = 4;
                    ant.svgPath = currentObject.exportSVG().getAttribute('d');
                    break;
                case 'point':
                    ant = angular.merge({}, ant, {
                        type: 2,
                        box: {
                            x: event.point.x,
                            y: event.point.y,
                            width: 0,
                            height: 0
                        }
                    });
                    break;
                case 'arrow':
                    ant.type = 8;
                    ant.svgPath = currentObject.exportSVG().firstChild.getAttribute('d');
                    ant.svgPath += " " + currentObject.exportSVG().lastChild.getAttribute('d');
                    break;
            }

            if (ant.type) {
                ant.pageNumber = attrs.number;
                AnnotationAddFactory.save(ant, function (response) {
                    currentObject.name = response.guid;
                    currentObject.selected = true;
                    currentObject = null;
                    $rootScope.selectedAnnotationGuid = response.guid;
                    if (!$rootScope.$$phase) {
                        $rootScope.$apply();
                    }
                });
            } else {
                currentObject = null;
            }
        };

        ps.tool.onKeyDown = function (event) {
            if (event.key === 'delete') {
                angular.forEach(ps.project.selectedItems, function (item) {
                    if (item.name) {
                        $rootScope.$broadcast('request-annotation-deletion', item.name);
                    }
                    else if (item._parent._name) {
                        $rootScope.$broadcast('request-annotation-deletion', item._parent._name);
                    }

                });
            }
        }
    }

    function setupAnnotations($rootScope, scope, element, attrs) {
        var ps = paper.PaperScope.get(scope.paperScopeId);

        scope.$watch('annotationsList', function () {

        });

        angular.forEach(scope.annotationsList, function (item) {

            if (attrs.number != item.annotation.pageNumber) {
                return;
            }

            switch (item.annotation.type) {
                case 1:

                    var shape = new ps.Rectangle(
                        item.annotation.box.x,
                        item.annotation.box.y,
                        item.annotation.box.width,
                        item.annotation.box.height
                    );
                    var path = new ps.Path.Rectangle(shape);
                    path.strokeColor = 'black';
                    path.strokeWidth = 2;
                    path.name = item.annotation.guid;

                    break;

                case 5:
                    var line = new ps.Path();
                    line.pathData = item.annotation.svgPath;
                    line.strokeColor = 'black';
                    line.strokeWidth = 2;
                    line.name = item.annotation.guid;

                    break;
                case 4:
                    var line = new ps.Path();
                    line.pathData = item.annotation.svgPath;
                    line.strokeColor = 'black';
                    line.strokeWidth = 2;
                    line.name = item.annotation.guid;

                    break;
                case 2:
                    var pt = new ps.Shape.Circle(new ps.Point(item.annotation.box.x + 3, item.annotation.box.y + 3), 3);
                    var ptp = pt.toPath(true);
                    ptp.strokeColor = 'black';
                    ptp.fillColor = 'black';
                    ptp.strokeWidth = 2;
                    ptp.name = item.annotation.guid;
                    break;
                case 8:
                    var arrow = new ps.Group([
                        new ps.Path(item.annotation.svgPath.split(" ")[0]),
                        new ps.Path(item.annotation.svgPath.split(" ")[1])
                    ]);
                    arrow.strokeColor = 'black';
                    arrow.strokeWidth = 2;
                    arrow.name = item.annotation.guid;
                    break;
            }
        })
    }

    function setupAnnotationDeletion($rootScope, AnnotationFactory, scope, element, attrs) {
        var ps = paper.PaperScope.get(scope.paperScopeId);

        $rootScope.$on('request-annotation-deletion', function (event, guid) {
            if (typeof(guid) !== 'string') {
                return;
            }

            var item = ps.project.activeLayer.children[guid];
            if (item) {
                AnnotationFactory
                    .remove({guid: guid})
                    .$promise
                    .then(function (response) {
                        item.remove();
                        ps.project.deselectAll();
                        $rootScope.selectedAnnotationGuid = null;
                        if (!$rootScope.$$phase) {
                            $rootScope.$apply();
                        }
                    });
            }

        });
    }

    angular.module('GroupDocsAnnotationApp').directive('gdxAnnoPage', main, ['cfpLoadingBar']);

})();

