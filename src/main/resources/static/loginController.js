'use strict';

angular.module('myApp').controller('loginController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
    //loginController.$inject = ['$window', 'loginSrv', 'notify'];
    $scope.successMessage = false;
    $scope.errorMessage = false;
    $scope.postResultMessage = '';
    $scope.loginDto = {
        employeeId: '',
        companyId: '',
        passwords: '',
        userExist: '',
        initialize: function (data) {
            this.employeeId = data ? data.employeeId || '' : '';
            this.companyId = data ? data.companyId || '' : '';
            this.passwords = data ? data.passwords || '' : '';
            this.userExist = data ? data.userExist || '' : '';
        }
    };

    $scope.getExistingUserInfo = function () {
        var url = $location.absUrl() + "login/checkUser";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        $http.get(url, config).then(function (response) {

            console.log(response.data);
            if (response.data.userExist !== 1) {
                console.log("no user")
            }
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }

    $scope.submit = function (form) {
        var data = {
            employeeId: $scope.loginDto.employeeId,
            companyId: $scope.loginDto.companyId,
            passwords: $scope.loginDto.passwords
        };

        console.log($scope.loginDto);
        var url = "http://localhost:8080/login";

        $http.post(url, data).then(function (response) {
            console.log(response.loginDto);
            if (response.data.userExist === 1) {
                $scope.successMessage = true;
                $scope.postResultMessage = "login success";
              window.location.href = "http://localhost:8080/attendance";
            } else {
                $scope.errorMessage = true;
                $scope.postResultMessage = "login failed!";
                console.log("no user");
            }

        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "login failed!";
            //$scope.errorMessage = ''

        });
        $scope.loginDto.initialize('');
    }
    $scope.reset = reset;


    function reset() {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.loginDto.initialize('');
        $scope.myForm.$setPristine(); //reset Form
    }

    $scope.blurOnChange = function () {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.postResultMessage = '';
    }
}])
;