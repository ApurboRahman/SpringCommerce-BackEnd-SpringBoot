'use strict';

angular.module('myApp').factory('passwordsChangeService', ['$http', '$q', function ($http, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/signup';

    this.save = function (data) {
        return $http.post(REST_SERVICE_URI, data);

    }

    console.log('fs');
    this.getEmployeeBasicInfoById = function (employeeId) {
        return $http.get(REST_SERVICE_URI + '/employeeId', {
            employeeId: employeeId
        });
    };

    var factory = {
        getAllEmployees: getAllEmployees,
        createEmployee: createEmployee,
        updateEmployee: updateEmployee,
        deleteEmployee: deleteEmployee
        /*getEmployeeBasicInfoById:getEmployeeBasicInfoById*/
    };

    return factory;

    function getEmployeeBasicInfoById(employeeId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/getAllEmployeeBasicInfo", {
            employeeId: employeeId
        })
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function getAllEmployees() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/getAllEmployeeBasicInfo")
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createEmployee(basicInfo) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, basicInfo)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while creating User');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updateEmployee(basicInfo, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + id, basicInfo)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating User');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteEmployee(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting User');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
