var app = angular.module('app', []);
app.controller('basicInfoController', function ($scope, $http, $location) {

    $scope.successMessage = false;
    $scope.errorMessage = false;
    $scope.updateEmployeeInfo = false;
    $scope.employeeList = [];
    $scope.submitForm = function () {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        var url = "http://localhost:8080/basicInfo/updateEmployeeInfo/" + $scope.employeeId;

        var data = {
            employeeId: $scope.employeeId,
            firstName: $scope.firstName,
            lastName: $scope.lastName,
            companyId: $scope.companyId,
            phoneNo: $scope.phoneNo,
            sex: $scope.sexId,
            sexName: $scope.sexName,
            birthDate: $scope.birthDate,
            joiningDate: $scope.joiningDate,
            department: $scope.department,
            employeeExist: $scope.employeeExist
        };
        $http.put(url, data).then(function (response) {
            $scope.successMessage = true;
            $scope.postResultMessage = "Employee information update successfully!";
            $scope.getAllEmployeesList();

        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Update failed!";
            //$scope.errorMessage = ''

        });
        $scope.employeeId = "";
        $scope.firstName = "";
        $scope.lastName = "";
        $scope.companyId = "";
        $scope.phoneNo = "";
        $scope.sexId = "";
        $scope.sexName = "";
        $scope.birthDate = "";
        $scope.joiningDate = "";
        $scope.department = "";
        console.log($scope.errorMessage);
        console.log($scope.successMessage);
    };


    $scope.getAllEmployeesList = function () {
        var url = "http://localhost:8080/" + "basicInfo/getAllEmployeeBasicInfo";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };
        $http.get(url, config).then(function (response) {
            $scope.employeeList = response.data;

        }, function (response) {
            $scope.getResultMessage = "Fail!";

        });
    };

    $scope.clickOnUpdate=function(employeeId){
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.updateEmployeeInfo = true;
        var url = " http://localhost:8080/basicInfo/getEmployeeBasicInfoById/" + employeeId;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            },
            params: {'employeeId': $scope.employeeId}
        };

        $http.get(url, config).then(function (response) {
            $scope.employeeId = response.data.employeeId;
            $scope.firstName = response.data.firstName;
            $scope.lastName = response.data.lastName;
            $scope.companyId = response.data.companyId;
            $scope.companyName = response.data.companyName;
            $scope.phoneNo = response.data.phoneNo;
            $scope.sexId = response.data.sexId;
            $scope.sexName = response.data.sexName;
            $scope.birthDate = response.data.birthDate;
            $scope.joiningDate = response.data.joiningDate;
            $scope.department = response.data.department;
            $scope.departmentName = response.data.departmentName;
            $scope.employeeExist = response.data.employeeExist;
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    };

    $scope.remove = function (employeeId) {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        var url = "http://localhost:8080/basicInfo/delete/" + employeeId;
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            },
            params: {'employeeId': employeeId}
        };
        $http.delete(url, employeeId).then(function (response) {
            $scope.successMessage = true;
            $scope.postResultMessage = "Employee remove successfully!";
            $scope.getAllEmployeesList();

        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Employee remove failed!";
            //$scope.errorMessage = ''
        });

    };

    $scope.getEmployeeById = function () {
        var url = $location.absUrl() + "basicInfo/getEmployeeBasicInfoById/" + $scope.employeeId;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            },
            params: {'employeeId': $scope.employeeId}
        };

        $http.get(url, config).then(function (response) {

            $scope.employeeId = response.data.employeeId;
            $scope.firstName = response.data.firstName;
            $scope.lastName = response.data.lastName;
            $scope.companyId = response.data.companyId;
            $scope.companyName = response.data.companyName;
            $scope.phoneNo = response.data.phoneNo;
            $scope.sexId = response.data.sexId;
            $scope.sexName = response.data.sexName;
            $scope.birthDate = response.data.birthDate;
            $scope.joiningDate = response.data.joiningDate;
            $scope.department = response.data.department;
            $scope.departmentName = response.data.departmentName;
            $scope.employeeExist = response.data.employeeExist;
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    };

    $scope.reset = function () {
        $scope.getAllEmployeesList();
        $scope.updateEmployeeInfo = false;
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.employeeId = '';
        $scope.firstName = '';
        $scope.lastName = '';
        $scope.phoneNo = '';
        $scope.sex = '';
        $scope.birthDate = '';
        $scope.companyId = '';
        $scope.department = '';
        $scope.joiningDate = '';
        $scope.myForm.$setPristine(); //reset Form
    };


    $scope.clickOnLogOut = function(){
        window.location.href = "http://localhost:8080/login";
    };

    $scope.getAllEmployeesList();
});