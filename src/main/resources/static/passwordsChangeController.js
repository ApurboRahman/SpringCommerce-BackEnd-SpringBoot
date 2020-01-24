'use strict';

angular.module('myApp').controller('passwordsChangeController', ['$scope', 'passwordsChangeService', '$http', '$location', function ($scope, passwordsChangeService, $http, $location) {

    $scope.successMessage = false;
    $scope.errorMessage = false;
    $scope.postResultMessage = '';
    $scope.signupDto = {
        employeeId: '',
        companyId: '',
        passwords: '',
        confirmPasswords: '',
        initialize: function (data) {
            this.employeeId = data ? data.employeeId || '' : '';
            this.companyId = data ? data.companyId || '' : '';
            this.passwords = data ? data.passwords || '' : '';
            this.confirmPasswords = data ? data.confirmPasswords || '' : '';
        }
    };

    $scope.submit = function () {
        if ($scope.signupDto.passwords !== $scope.signupDto.confirmPasswords) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "passwords and confirm passwords dont match!";
            return;
        }
        if (!$scope.checkPassword($scope.signupDto.passwords)) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "passwords length must be 6-8 including at least 1 capital letter, 1 number and 1 special character.";
            return;

        }
        console.log($scope.signupDto);
        var url = "http://localhost:8080/changePasswords";

        $http.post(url, $scope.signupDto).then(function (response) {
            $scope.successMessage = true;
            $scope.postResultMessage = "'Passwords changed successfully!";
            $scope.signupDto.initialize('');

        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Passwords change failed, check your credential or signup first!";
            //$scope.errorMessage = ''

        });


    }
    $scope.reset = reset;

    $scope.checkPassword = function (passwords) {
        var re = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{6,8}$/;
        return re.test(passwords);
    }

    function reset() {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.signupDto.initialize('');
        $scope.myForm.$setPristine(); //reset Form
    }

    $scope.blurOnChange = function () {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.postResultMessage = '';
    }
}])
;