// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
var app = angular.module('starter', ['ionic'])

//
app.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})

app.directive("ag", [function(){
  return {
    restrict: "EAC",
    link: function(scope, element){
      angular.element(element).html("Hello World")//jqlite
    }
  }
}])

app.filter("agg", [function(){
  return function(value){
    return value + ' ----> Oia eu'
  }
}])

app.controller("control", ["$scope", "service",  function($scope, service){
  //
  $scope.hello = "Hello World by controller."
  //
  service.getCEP().then(function(response){
    $scope.cep = response
  })

  $scope.mydate = (new Date()).getTime()

}])

app.service("service", ["$http", function($http){
  //
  this.getCEP = function(){
    var promise  = $http.get("http://viacep.com.br/ws/01001000/json/")
    return promise
  }

}])
