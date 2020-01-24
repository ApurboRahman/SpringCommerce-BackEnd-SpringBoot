var app = angular.module('app', []);

angular.module('myApp').controller('attendanceReportController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
    $scope.successMessage = false;
    $scope.errorMessage = false;
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

    $scope.attendanceReportDto = {
        employeeType: '',
        dateType: '',
        employeeId: '',
        fromDate: '',
        toDate: '',
        initialize: function (data) {
            this.employeeType = data ? data.employeeType || '' : '';
            this.dateType = data ? data.dateType || '' : '';
            this.employeeId = data ? data.employeeId || '' : '';
            this.fromDate = data ? data.fromDate || '' : '';
            this.toDate = data ? data.toDate || '' : '';
        }
    };

    $scope.submitForm = function () {
        $scope.page.isSubmitted = true;
        var url = "http://localhost:8080/dailyAttendance/getAttendanceReport";

        var data = {
            employeeType: $scope.attendanceReportDto.employeeType,
            dateType: $scope.attendanceReportDto.dateType,
            employeeId: $scope.attendanceReportDto.employeeId,
            fromDate: $scope.attendanceReportDto.fromDate,
            toDate: $scope.attendanceReportDto.toDate
        };
        $http.post(url, data).then(function (response) {
            $scope.attendaceList = response.data;
            $scope.showList = true;
        }, function (response) {
            $scope.errorMessage = true;
            $scope.postResultMessage = "Error";
            //$scope.errorMessage = ''

        });

        $scope.employeeId = "";
    };

    $scope.changeOnEmployeeId = function () {
        $scope.successMessage = false;
        $scope.errorMessage = false;

    };

    $scope.getAttendanceReport = function () {
        $scope.showList = true;
        var url = "http://localhost:8080/dailyAttendance/getAttendanceReport";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        };

        $http.get(url, config).then(function (response) {
            $scope.attendaceList = response.data;
            console.log($scope.employeeList);
        }, function (response) {
            $scope.getResultMessage = "Fail!";

        });
    };

    $scope.clickOnLogOut = function () {
        window.location.href = "http://localhost:8080/login";
    };

    $scope.employeeTypeOnChange = function(){
        $scope.attendanceReportDto.employeeId='';
        $scope.attendaceList = [];
        $scope.showList = false;
    };
    $scope.reset = function () {
        $scope.page.isSubmitted = false;
        $scope.attendaceList = [];
        $scope.showList = false;
        $scope.successMessage = false;
        $scope.errorMessage = false;
        $scope.attendanceDto.employeeId = '';
        $scope.myForm.$setPristine(); //reset Form
    }


}]);
