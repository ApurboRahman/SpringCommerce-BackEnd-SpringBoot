var app = angular.module('app', []);

angular.module('myApp').controller('attendanceController', ['$scope',  '$http', '$location', function ($scope, $http, $location) {
    $scope.successMessage = false;
    $scope.errorMessage = false;
    $scope.showClock = true;
    $scope.showList = false;
    $scope.attendaceList = [];
    $scope.currentDate = new Date();

    $scope.page = {
        formSubmitted: false,
        editable: false,
        editMode: false,
        editableButton: false,
        isSubmitted: false,
        handleSaveButton: false,
        initialize: function () {
            this.formSubmitted = false;
            this.editable = false;
            this.editMode = false;
            this.editableButton = false;
            this.isSubmitted = false;
            this.handleSaveButton = false;

        }
    };

    $scope.attendanceDto = {
        employeeId: '',
        initialize: function (data) {
            this.employeeId = data ? data.employeeId || '' : '';
        }
    };

    $scope.submitForm = function () {
        $scope.page.isSubmitted = true;
        var url = "http://localhost:8080/dailyAttendance/inTime/" + $scope.attendanceDto.employeeId;

        var data = {
            employeeId: $scope.employeeId
        };
        $http.post(url, data).then(function (response) {
            $scope.showClock = false;
            $scope.successMessage = true;
            $scope.postResultMessage = "In Time saved!";


        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "In Time save failed!";
            //$scope.errorMessage = ''

        });

        $scope.employeeId = "";
    }

    $scope.getGoOutTime = function () {
        if ($scope.attendanceDto.employeeId !== '') {
            var url = "http://localhost:8080/dailyAttendance/goOutTime/" + $scope.attendanceDto.employeeId;

            var data = {
                employeeId: $scope.employeeId
            };
            $http.post(url, data).then(function (response) {
                $scope.showClock = false;
                $scope.successMessage = true;
                $scope.postResultMessage = "Go Out Time saved!";

            }, function (response) {
                $scope.errorMessage = true;
                $scope.postResultMessage = "Go Out Time save failed!";
            });

            // return;
        } else {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Please insert Employee Id!";
            return;
        }
        $scope.page.isSubmitted = true;

        $scope.employeeId = "";
    };

    $scope.getReturnTime = function () {
        if ($scope.attendanceDto.employeeId !== '') {
            var url = "http://localhost:8080/dailyAttendance/returnTime/" + $scope.attendanceDto.employeeId;

            var data = {
                employeeId: $scope.employeeId
            };
            $http.post(url, data).then(function (response) {
                $scope.showClock = false;
                $scope.successMessage = true;
                $scope.postResultMessage = "Return Time saved!";

            }, function (response) {
                $scope.errorMessage = true;
                $scope.postResultMessage = "Return Time save failed!";
            });
        } else {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Please insert Employee Id!";
            return;
        }
        $scope.page.isSubmitted = true;
        $scope.employeeId = "";
    };

    $scope.getOutTime = function () {
        if ($scope.attendanceDto.employeeId !== '') {
            var url = "http://localhost:8080/dailyAttendance/outTime/" + $scope.attendanceDto.employeeId;

            var data = {
                employeeId: $scope.employeeId
            };
            $http.post(url, data).then(function (response) {
                $scope.showClock = false;
                $scope.successMessage = true;
                $scope.postResultMessage = "Out Time saved!";
                $scope.page.isSubmitted = true;

            }, function (response) {
                $scope.errorMessage = true;
                $scope.postResultMessage = "Out Time save failed!";
            });
        } else {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Please insert Employee Id!";
            return;
        }

        $scope.employeeId = "";
    };
    $scope.changeOnEmployeeId = function () {
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.showClock = true;
    };

    $scope.getAttendanceDetailsById = function () {
        $scope.showList = true;
        var url = "http://localhost:8080/dailyAttendance/getAttendanceDetailById/" + $scope.attendanceDto.employeeId;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            },
            params: {'employeeId': $scope.attendanceDto.employeeId}
        }

        $http.get(url, config).then(function (response) {
            $scope.attendaceList = response.data;
            console.log($scope.employeeList);
        }, function (response) {
            $scope.getResultMessage = "Fail!";

        });
    };

$scope.clickOnLogOut = function(){
    window.location.href = "http://localhost:8080/login";
};
    $scope.reset = function () {
        $scope.page.isSubmitted = false;
        $scope.attendaceList = [];
        $scope.showList = false;
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.showClock = true;
        $scope.attendanceDto.employeeId = '';
        $scope.myForm.$setPristine(); //reset Form
    }


}]);
