(function () {
    'use strict';

    function main($resource) {

        return $resource(
            '/annotation?guid=:guid&section=:section',
            {},
            {
                get: {
                    method: 'GET',
                    responseType: 'application/json'
                },
                remove: {
                    method: 'DELETE',
                    responseType: 'application/json'
                },
                updateFieldText: {
                    method: 'POST',
                    params: {
                        section: 'fieldtext'
                    }
                },
                updatePosition: {
                    method: 'POST',
                    params: {
                        section: 'position'
                    }
                }
            }
        );
    }

    angular.module('GroupDocsAnnotationApp').factory('AnnotationFactory', main);

})();

