var app = angular.module("controllers", [])
//
app.controller("homeController", ["$scope", "$state", function(s, $state){
  //
  var storage = window.localStorage
  storage.setItem("key0", "value0")
  //
  s.nextPage = function(){
    $state.go("news")
  }
}])
