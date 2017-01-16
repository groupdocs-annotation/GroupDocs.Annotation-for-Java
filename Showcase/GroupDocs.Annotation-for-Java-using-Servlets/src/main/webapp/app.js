'use strict';

var ANNOTATION_TYPE_AREA = 1;

var ngApp = angular.module('ngApp', ['ngMaterial', 'ngResource']);

ngApp.factory('FilesFactory', function () {
    var fileList = [
        'candy.pdf'
    ];
    return {
        list: function () {
            return fileList;
        },
        selectedFile: fileList[0]
    };
});

ngApp.factory('DocumentInfoFactory', function ($resource, FilesFactory) {
    return $resource('/document/info?file=:filename', {}, {
        get: {
            method: 'GET',
            params: {
                filename: FilesFactory.selectedFile
            }
        }
    });
});

ngApp.factory('PageCountFactory', function ($resource, FilesFactory) {
    return $resource('/page/count?file=:filename', {}, {
        get: {
            method: 'GET',
            params: {
                filename: FilesFactory.selectedFile
            }
        }
    });
});

ngApp.factory('AnnotationListFactory', function ($resource, FilesFactory) {
    return $resource('/annotation/list?file=:filename', {}, {
        query: {
            method: 'GET',
            params: {
                filename: FilesFactory.selectedFile
            },
            isArray: true
        }
    });
});

ngApp.factory('AnnotationAddFactory', function ($resource, FilesFactory) {
    return $resource('/annotation/add?file=:filename', {}, {
        save: {
            method: 'POST',
            params: {
                filename: FilesFactory.selectedFile
            }
        }
    });
});

ngApp.factory('AnnotationDeleteFactory', function ($resource, FilesFactory) {
    return $resource('/annotation/delete?file=:filename&id=:annotationId', {}, {
        save: {
            method: 'POST',
            params: {
                filename: FilesFactory.selectedFile
            }
        }
    });
});

ngApp.directive('onimageload', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            scope.element = element;
            element.bind('load', function () {
                scope.$apply(attrs.onimageload);
            });
        }
    };
});

ngApp.controller('AvailableFilesController', function AvailableFilesController($scope, FilesFactory) {
    $scope.list = FilesFactory.list();
    $scope.selectedFile = FilesFactory.selectedFile;
});

ngApp.controller('ToolbarController', function ToolbarController($scope, $mdToast, FilesFactory) {
    $scope.selectedFile = FilesFactory.selectedFile;

    $scope.$on('annotation-added', function (event, args) {
        $mdToast.show(
            $mdToast.simple().textContent('Annotation added')
        );
    });

    $scope.$on('annotation-deleted', function (event, args) {
        $mdToast.show(
            $mdToast.simple().textContent('Annotation deleted')
        );
    });
});

ngApp.controller('PageImageController',
    function PageImageController($rootScope, $scope, $cacheFactory, $mdDialog, AnnotationListFactory, AnnotationAddFactory, FilesFactory, DocumentInfoFactory) {
        $scope.docInfo = DocumentInfoFactory.get();
        $scope.selectedFile = FilesFactory.selectedFile;
        $scope.annotationsList = AnnotationListFactory.query();

        $scope.mouse = {
            x: 0,
            y: 0,
            startX: 0,
            startY: 0,
            endX: 0,
            endY: 0
        };

        function updateMousePosition($event) {
            switch ($event.type) {
                case 'mousedown':
                    $scope.mouse.startX = $scope.mouse.x + $event.target.offsetLeft;
                    $scope.mouse.startY = $scope.mouse.y + $event.target.offsetTop;
                    break;
                case 'mouseup':
                    $scope.mouse.endX = $scope.mouse.x + $event.target.offsetLeft;
                    $scope.mouse.endY = $scope.mouse.y + $event.target.offsetTop;
                    break;
            }
            $scope.mouse.x = $event.offsetX ? ($event.offsetX) : $event.pageX - $event.target.offsetLeft;
            $scope.mouse.y = $event.offsetY ? ($event.offsetY) : $event.pageY - $event.target.offsetTop;
        }

        $scope.drawingElement = null;

        $scope.onImageLoad = function ($event, page) {
            var l = $scope.annotationsList;
            var element = this.element[0];

            for (var i = 0; i < l.length; i++) {
                var item = l[i];
                if (page.number - 1 != item.annotation.pageNumber) {
                    continue;
                }

                if (item.annotation.type == ANNOTATION_TYPE_AREA) {
                    var e = document.createElement("div");
                    e.style.position = "absolute";
                    e.style.left = item.annotation.box.x + "px";
                    e.style.top = item.annotation.box.y + "px";
                    e.style.width = item.annotation.box.width + "px";
                    e.style.height = item.annotation.box.height + "px";
                    e.setAttribute("class", "rendered-annotation rectangle");
                    e.setAttribute("data-annotation-id", item.id);
                    element.parentNode.appendChild(e);
                }
            }
        };

        $scope.$on('annotation-deleted', function (event, args) {
            angular.element('div.rendered-annotation[data-annotation-id=' + args.id + ']').remove();
        });

        $scope.onImageMouseDown = function ($event, page) {
            updateMousePosition($event);
            $scope.drawingElement = document.createElement("div");
            $scope.drawingElement.style.position = "absolute";
            $scope.drawingElement.style.left = $scope.mouse.x + "px";
            $scope.drawingElement.style.top = $scope.mouse.y + "px";
            $scope.drawingElement.setAttribute("class", "rendered-annotation rectangle");

            $event.target.parentNode.appendChild($scope.drawingElement);
        };

        $scope.onImageMouseMove = function ($event, page) {
            updateMousePosition($event);

            if (!$scope.drawingElement) {
                return;
            }

            if ($scope.mouse.x > 0 && $scope.mouse.y > 0) {
                if (($scope.mouse.x + $event.target.offsetLeft) > $scope.mouse.startX) {
                    $scope.drawingElement.style.width = (($scope.mouse.x + $event.target.offsetLeft) - $scope.mouse.startX) - 10 + "px";
                }
                if (($scope.mouse.y + $event.target.offsetTop) > $scope.mouse.startY) {
                    $scope.drawingElement.style.height = (($scope.mouse.y + $event.target.offsetTop) - $scope.mouse.startY) - 10 + "px";
                }
            }

        };

        $scope.onImageMouseUp = function ($event, page) {
            updateMousePosition($event);
            var ant = {
                annotationPosition: {
                    x: $scope.mouse.startX,
                    y: $scope.mouse.startY
                },
                replies: [
                    {
                        message: "Reply of area annotation"
                    }
                ],
                box: {
                    x: $scope.mouse.startX,
                    y: $scope.mouse.startY,
                    width: $scope.mouse.x - $scope.mouse.startX - 10,
                    height: $scope.mouse.y - $scope.mouse.startY - 10
                },
                fieldText: null,
                type: 1,
                pageNumber: page.number - 1
            };

            var confirm = $mdDialog.prompt()
                .title('Add annotation')
                .textContent('Enter text details for annotation. You can also leave it empty.')
                .placeholder('Text')
                .ariaLabel('Text')
                .initialValue('')
                .targetEvent($event)
                .ok('Save')
                .cancel('Cancel');
            $mdDialog.show(confirm)
                .then(
                    function (result) {
                        ant.fieldText = result;
                        AnnotationAddFactory.save(ant, function (response) {
                            $scope.drawingElement.setAttribute("data-annotation-id", response.id);
                            $scope.drawingElement = null;
                            $rootScope.$broadcast('annotation-added');
                        });
                    },
                    function () {
                        $scope.drawingElement.parentNode.removeChild($scope.drawingElement);
                        $scope.drawingElement = null;
                    });
        };
    }
);

ngApp.controller('CommentsController',
    function CommentsController($rootScope, $scope, $http, FilesFactory, AnnotationListFactory) {
        $scope.list = AnnotationListFactory.query();

        $scope.$on('annotation-added', function (event, args) {
            $scope.list = AnnotationListFactory.query();
        });

        $scope.$on('annotation-deleted', function (event, args) {
            $scope.list = AnnotationListFactory.query();
        });

        $scope.deleteAnnotation = function (item) {
            $http.get(
                '/annotation/delete',
                {
                    params: {
                        file: FilesFactory.selectedFile,
                        annotationId: item.id
                    }
                }
            ).success(function (response) {
                $rootScope.$broadcast('annotation-deleted', response);
            });
        };
    }
);
