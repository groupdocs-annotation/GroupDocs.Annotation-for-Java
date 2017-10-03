(function () {
    'use strict';

    function main(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.includeSpinner = false;
        cfpLoadingBarProvider.includeBar = true;
    }

    angular.module('GroupDocsAnnotationApp').config(['cfpLoadingBarProvider', main]);

})();

