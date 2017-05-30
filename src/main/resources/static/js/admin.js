var admin = angular.module('admin', ['ngRoute','ui.bootstrap']);

admin.config(['$routeProvider', function ($routeProvider) {

        $routeProvider
                .when('/admin', {
                    'templateUrl': '/html/adminView.html',
                    'controller': 'publicCtrl'
                }).otherwise({
                    redirectTo: '/admin'
                });
    }]);


admin.controller('publicCtrl', function ($scope, $http, $rootScope) {
    
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





