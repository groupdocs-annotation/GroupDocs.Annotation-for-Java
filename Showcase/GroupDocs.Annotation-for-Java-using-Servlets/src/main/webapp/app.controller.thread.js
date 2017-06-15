(function () {
    'use strict';

    function main($rootScope, $scope, $resource, AnnotationFactory, RepliesFactory, ReplyFactory) {

        $rootScope.$watch('selectedAnnotationGuid', function () {
            $scope.fetchAnnotation();
        }, true);

        $scope.deleteAnnotation = function (item) {
            $rootScope.$broadcast('request-annotation-deletion', item.guid);
        };

        $scope.saveAnnotationFieldText = function (item) {
            AnnotationFactory
                .updateFieldText(
                    {
                        guid: item.guid
                    },
                    {
                        fieldText: item.fieldText
                    }
                )
                .$promise
                .then(function (response) {
                    item.unsaved = false;
                });
        };

        $scope.addReply = function (item) {
            RepliesFactory
                .put(
                    {guid: item.guid}
                )
                .$promise
                .then(function (response) {
                    $scope.fetchAnnotation();
                });
        };

        $scope.deleteReply = function (guid) {
            ReplyFactory
                .remove({guid: guid})
                .$promise
                .then(function (response) {
                    $scope.fetchAnnotation();
                });
        };

        $scope.saveReplyMessage = function (reply) {
            ReplyFactory
                .updateMessage(
                    {
                        guid: reply.guid
                    },
                    {
                        message: reply.message
                    }
                )
                .$promise
                .then(function (response) {
                    reply.unsaved = false;
                });
        };

        $scope.fetchAnnotation = function () {
            if (typeof($rootScope.selectedAnnotationGuid) === 'string') {
                $scope.selectedAnnotation = AnnotationFactory.get({
                    guid: $rootScope.selectedAnnotationGuid
                });
            } else {
                $scope.selectedAnnotation = null;
            }
        };

    }

    angular.module('GroupDocsAnnotationApp').controller('ThreadController', main);

})();

