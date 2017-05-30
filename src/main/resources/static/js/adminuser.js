var admin = angular.module('admin', ['ngRoute','ngCookies']);

admin.config(['$routeProvider', function ($routeProvider) {

        $routeProvider
                .when('/adminView', {
                    'templateUrl': '/html/adminView.html',
                    'controller': 'homeCtrl'
                }).otherwise({
                    redirectTo: '/adminView'
                });
    }]);

admin.controller('userCtrl', function ($scope, $rootScope, $http, $cookies, $window) {

    $scope.init = function () {
        if ($cookies.token == undefined) {
            $window.location.href = "/login?state=" + encodeURIComponent($window.location.href);
        } else {
            $scope.validate($cookies.token);
        }
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

            if ($rootScope.session.role != "ROLE_ADMIN") {
                $window.location.href = "/logout";
            }
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $cookies.token;
        }).error(function (error, status) {
            $window.location.href = "/logout";
        });
    };

});

admin.controller('homeCtrl', function ($scope, $rootScope, $http, $cookies, $window) {
    
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

