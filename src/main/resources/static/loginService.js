'use strict';

angular.module('myApp').factory('loginService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/login';

    this.save = function (data) {
        return $http.post(REST_SERVICE_URI, data);

    }

    this.getEmployeeBasicInfoById = function (employeeId) {
        return $http.get(REST_SERVICE_URI + '/employeeId', {
            employeeId: employeeId
        });
    };

}]);
