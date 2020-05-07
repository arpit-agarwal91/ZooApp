var app = angular.module('myApp', []);
app.run(['$http',function($http){
	
}]);
app.controller('myCtrl',['$scope','$http', function($scope,$http) {

  $scope.addCage = function(){
	  console.log("Came Here");
  var cage =$http.post('http://localhost:8080/pens',$scope.pen,function(response){
  console.log(response);
	});
}

$scope.addAnimal = function(){
	  //console.log($scope.animal.locomotionModes.split(/\s*,\s*/));
	  var modes = $scope.animal.locomotionModes.split(/\s*,\s*/);
	  $scope.animal.locomotionModes = modes;
  var animal =$http.post('http://localhost:8080/animals',$scope.animal,function(response){
  console.log(response);
	});
}

$scope.listAnimals = function(){
	$http.get('http://localhost:8080/animals').then(function(response){
		$scope.animals = response.data;
			console.log(response);
	})
	console.log($scope.animals);
}

$scope.listPens = function(){
	$http.get('http://localhost:8080/pens').then(function(response){
		$scope.pens = response.data;
			console.log(response);
	})
	console.log($scope.pens);
}
	
}])