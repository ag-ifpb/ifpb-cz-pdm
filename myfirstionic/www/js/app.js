
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

app.service("service", ["$http", function($http){
  //
  this.getCEP = function(number){
    var promise  = $http.get("http://viacep.com.br/ws/" + number + "/json/")
    return promise
  }

}])

app.directive("cep", ["service", function(service){
  return {
    restrict: "E",
    templateUrl: "cep.tpl",
    link: function(scope, element, attr){
      //
      scope.log = "meu logradouro"
      scope.cid = "minha cidade"
      scope.uf  = "meu estado"
      scope.cep = "63180000"
      //
      angular.element(element).css({
        background: "red",
        display: "block",
        padding: "10px"
      })
      //
      // scope.search = function(){
      //   console.info("ajdhasjkdhkjashd")
      //   service.getCEP(scope.cep).then(function(response){
      //     //
      //     var data = response.data
      //     //
      //     scope.log = data.logradouro
      //     scope.cid = data.localidade
      //     scope.uf  = data.uf
      //   })
      // }
      scope.$watch('cep', function(){
          console.info("ajdhasjkdhkjashd")
          service.getCEP(scope.cep).then(function(response){
            //
            var data = response.data
            //
            scope.log = data.logradouro
            scope.cid = data.localidade
            scope.uf  = data.uf
          })
      })

    }
  }
}])

app.controller("control", ["$scope", "service",  function($scope, service){

}])
