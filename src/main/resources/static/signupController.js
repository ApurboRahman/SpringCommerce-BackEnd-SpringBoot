'use strict';

angular.module('myApp').controller('signupController', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $scope.successMessage = false;
    $scope.errorMessage = false;
    $scope.postResultMessage = '';
    $scope.signupDto = {
        employeeId: '',
        companyId: '',
        passwords: '',
        confirmPasswords: '',
        userExist: '',
        initialize: function (data) {
            this.employeeId = data ? data.employeeId || '' : '';
            this.companyId = data ? data.companyId || '' : '';
            this.passwords = data ? data.passwords || '' : '';
            this.confirmPasswords = data ? data.confirmPasswords || '' : '';
            this.userExist = data ? data.userExist || '' : '';
        }
    };

    $scope.submit = function () {
        console.log($scope.signupDto.passwords);
        console.log($scope.signupDto.confirmPasswords);
        console.log($scope.signupDto.passwords !== $scope.signupDto.confirmPasswords);
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
        var url = "http://localhost:8080/signup";

        var data = {
            employeeId: $scope.signupDto.employeeId,
            companyId: $scope.signupDto.companyId,
            passwords: $scope.signupDto.passwords,
            confirmPasswords: $scope.signupDto.confirmPasswords,
            userExist: $scope.signupDto.userExist
        };

        $http.post(url, data).then(function (response) {
            if(response.data.userExist===0){
                $scope.errorMessage = true;
                $scope.postResultMessage = "Please register first as an employee";
            }else  if(response.data.userExist===1){
                $scope.errorMessage = true;
                $scope.postResultMessage = "Already user has been created with this info. Please check.";
            }else  if(response.data.userExist===2){
                $scope.errorMessage = true;
                $scope.postResultMessage = "passwords length must be 6-8 including at least 1 capital letter, 1 number and 1 special character.!";
            } else {
                $scope.successMessage = true;
                $scope.postResultMessage = "User created successfully!";
            }

        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "User creation failed!";

        });
    };
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