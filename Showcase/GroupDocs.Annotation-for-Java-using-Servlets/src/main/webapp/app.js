(function () {
    'use strict';

    var ANNOTATION_TYPE_AREA = 1;

    angular
        .module('GroupDocsAnnotationApp', ['ngMaterial', 'ngResource', 'angular-loading-bar'])
        .factory('FilesFactory', FilesFactory)
        .factory('DocumentInfoFactory', DocumentInfoFactory)
        .factory('AnnotationListFactory', AnnotationListFactory)
        .factory('AnnotationAddFactory', AnnotationAddFactory)
        .controller('AvailableFilesController', AvailableFilesController)
        .controller('ToolbarController', ToolbarController)
    ;

    function FilesFactory() {
        var fileList = [
            'candy.pdf'
        ];
        return {
            list: function () {
                return fileList;
            },
            selectedFile: fileList[0]

        };
    }

    function DocumentInfoFactory($resource, FilesFactory) {
        return $resource('/document/info?file=:filename', {}, {
            get: {
                method: 'GET',
                params: {
                    filename: FilesFactory.selectedFile
                }
            }
        });
    }

    function AnnotationListFactory($resource, FilesFactory) {
        return $resource('/annotation/list?file=:filename', {}, {
            query: {
                method: 'GET',
                params: {
                    filename: FilesFactory.selectedFile
                },
                isArray: true
            }
        });
    }

    function AnnotationAddFactory($resource, FilesFactory) {
        return $resource('/annotation/add?file=:filename', {}, {
            save: {
                method: 'POST',
                params: {
                    filename: FilesFactory.selectedFile
                }
            }
        });
    }

    function AvailableFilesController($scope, FilesFactory) {
        $scope.list = FilesFactory.list();
        $scope.selectedFile = FilesFactory.selectedFile;
    }

    function ToolbarController($scope, $mdToast, FilesFactory) {
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
    }

})();

