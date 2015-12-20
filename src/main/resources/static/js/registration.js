var registration = angular.module('registration', ['ngRoute']);

registration.config(['$routeProvider', function ($routeProvider) {

        $routeProvider
                .when('/registration', {
                    'templateUrl': '/html/registration.html',
                    'controller': 'registrationCtrl'
                }).otherwise({
                redirectTo: '/home'
        });
    }]);



registration.controller('registrationCtrl', function ($scope, $rootScope, $http, $routeParams) {

    $scope.register;

    $scope.init = function () {

    };

    $scope.save = function (form) {

        if (form.$invalid) {
            console.log("Form Validation Failure");
        } else {

            $http({
                url: '/api/register',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: $scope.register
            }).success(function (data, status) {

                if (status === 200) {
                    console.log('All the data are saved in quotationOptions and quotation table');
                    $rootScope.message = "You have successfully Registered";
                } else {
                    console.log('status:' + status);
                }
            }).error(function (error) {
                $rootScope.message = "Oops, we received your request, but there was an error processing it";
            });
        }
    };
});



