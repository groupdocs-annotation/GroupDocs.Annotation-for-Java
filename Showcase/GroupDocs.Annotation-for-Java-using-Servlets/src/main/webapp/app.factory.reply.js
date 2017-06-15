(function () {
    'use strict';

    function main($resource) {

        return $resource(
            '/reply?guid=:guid&section=:section',
            {},
            {
                remove: {
                    method: 'DELETE'
                },
                updateMessage: {
                    method: 'POST',
                    params: {
                        section: 'message'
                    }
                }
            }
        );
    }

    angular.module('GroupDocsAnnotationApp').factory('ReplyFactory', main);

})();

