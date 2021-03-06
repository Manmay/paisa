var loan = angular.module('loan', ['ngRoute','ngCookies']);

loan.config(['$routeProvider', function ($routeProvider) {

        $routeProvider
                .when('/home', {
                    'templateUrl': '/html/home.html',
                    'controller': 'homeCtrl'
                }).otherwise({
                    redirectTo: '/home'
                });
    }]);

loan.controller('userCtrl', function ($scope, $rootScope, $http, $cookies, $window) {

    $scope.init = function () {
        if ($cookies.token == undefined) {
            $window.location.href = "/login?state=" + encodeURIComponent($window.location.href);
        } else {
            $scope.validate($cookies.token);
        }
    };

    $scope.getLoanTpes = function () {
        $http({
            url: '/api/loanTypes',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('retrived successfully');
                $rootScope.loans = data;
            } else {
                console.log('status:' + status);
                $rootScope.error = "error status code : " + status;
                ;
            }
        }).error(function (error) {
            $rootScope.message = "Oops, we received your request, but there was an error processing it";
        });
    };

    $scope.closeNotification = function () {
        $rootScope.message = undefined;
    };

    $scope.validate = function (token) {
        $http({
            method: 'POST',
            url: '/validate',
            headers: {
                "Content-Type": "text/html"
            },
            data: token
        }).success(function (data, status) {
            $rootScope.session = data;

            if ($rootScope.session.role != "ROLE_USER") {
                $window.location.href = "/logout";
            }
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $cookies.token;
        }).error(function (error, status) {
            $window.location.href = "/logout";
        });
    };

});

loan.controller('homeCtrl', function ($scope, $rootScope, $http, $cookies, $window) {
    
    $scope.user;

    $scope.init = function () {

    };

    $scope.save = function (form) {

        if (form.$invalid) {
            console.log("Form Validation Failure");
        } else {

            $http({
                url: '/api/comment',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: $scope.user
            }).success(function (data, status) {

                if (status === 200) {
                    console.log('The Comment are Saved in the User table');
                    $rootScope.message = "Your comments are highly appreciated and has been saved.";
                } else {
                    console.log('status:' + status);
                }
            }).error(function (error) {
                $rootScope.message = "Oops, we received your request, but there was an error processing it";
            });
        }
    };

});

