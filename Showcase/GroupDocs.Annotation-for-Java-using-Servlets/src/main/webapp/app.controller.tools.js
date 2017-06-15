(function () {
    'use strict';

    function main($rootScope, $scope) {

        $scope.selectRectangleTool = function ($event) {
            $rootScope.selectedDrawingTool = 'rectangle';
        };

        $scope.selectPencilTool = function ($event) {
            $rootScope.selectedDrawingTool = 'pencil';
        };
        $scope.selectSelectTool = function ($event) {
            $rootScope.selectedDrawingTool = 'select';
        };
        $scope.selectPointTool = function ($event) {
            $rootScope.selectedDrawingTool = 'point';
        };

        $scope.selectSelectTool();
    }

    angular.module('GroupDocsAnnotationApp').controller('ToolsController', main);

})();

