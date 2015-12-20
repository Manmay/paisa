var home = angular.module('home', ['ngRoute']);

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
                }).when('/reset-password', {
                    'templateUrl': '/html/reset-password.html',
                    'controller': 'resetPasswordCtrl'
                }).otherwise({
                    redirectTo: '/public'
                });
    }]);

home.controller('publicCtrl', function ($scope) {

});

home.controller('signInCtrl', function ($scope, $rootScope, $http) {

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

home.controller('signUpCtrl', function ($scope, $http) {

});

home.controller('resetPasswordCtrl', function ($scope, $http) {

});



