var app = angular.module('Spring', []);
app.controller('myCtrl', function($scope, $http) {
	 $scope.peoples = [];
	 
	 $http.get('http://localhost:8090/api/people').then(function(response) {
	        $scope.peoples = response.data;
	    });
	});