(function () {
    'use strict';

    function main($resource) {

        return $resource(
            '/replies?guid=:guid',
            {},
            {
                query: {
                    method: 'GET',
                    isArray: true
                },
                put: {
                    method: 'PUT'
                }
            }
        );
    }

    angular.module('GroupDocsAnnotationApp').factory('RepliesFactory', main);

})();

