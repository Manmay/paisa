var home = angular.module('home', ['ngRoute','ui.bootstrap']);

home.config(['$routeProvider', function ($routeProvider) {

        $routeProvider
                .when('/public', {
                    'templateUrl': '/html/public.html',
                    'controller': 'publicCtrl'
                }).when('/sign-up', {
                    'templateUrl': '/html/sign-up.html',
                    'controller': 'signUpCtrl'
                }).when('/sign-in', {
                    'templateUrl': '/html/sign-in.html',
                    'controller': 'signInCtrl'
                }).otherwise({
                    redirectTo: '/public'
                });
    }]);

home.controller('signInCtrl', function ($scope, $rootScope, $http) {

    $scope.register;

    $scope.init = function () {

    };

    $scope.save = function (form) {

        if (form.$invalid) {
            console.log("Form Validation Failure");
        } else {

            $http({
                url: '/api/create-user',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: $scope.register
            }).success(function (data, status) {

                if (status === 200) {
                    $rootScope.message = "An Email has been sent for verification";
                } else {
                    console.log('status:' + status);
                }
            }).error(function (error) {
                $rootScope.message = "Oops, we received your request, but there was an error processing it";
            });
        }
    };
});

home.controller('signUpCtrl', function ($scope, $http, $rootScope) {
    
    $scope.register;
    
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
                    $rootScope.message = "An Email has been sent for verification";
                } else {
                    console.log('status:' + status);
                }
            }).error(function (error) {
                $rootScope.message = "Oops, we received your request, but there was an error processing it";
            });
        }
    };

});





