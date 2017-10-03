(function () {
    'use strict';

    function main($rootScope, $scope) {

        $scope.selectRectangleTool = function ($event) {
            $rootScope.selectedDrawingTool = 'rectangle';
        };
        $scope.selectDistanceTool = function ($event) {
            $rootScope.selectedDrawingTool = 'distance';
        };
        $scope.selectArrowTool = function ($event) {
            $rootScope.selectedDrawingTool = 'arrow';
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
        $scope.selectUnderlineTool = function ($event) {
            $rootScope.selectedDrawingTool = 'underline';
        };
        $scope.selectStrikeoutTool = function ($event) {
            $rootScope.selectedDrawingTool = 'strikeout';
        };
        
        $scope.selectSelectTool();
    }

    angular.module('GroupDocsAnnotationApp').controller('ToolsController', main);

})();

