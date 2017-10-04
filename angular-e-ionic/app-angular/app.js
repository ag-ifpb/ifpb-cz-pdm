var app = angular.module("my-app", [])


//================================================================
// Filters
//================================================================
app.directive('myDirective', function () {
    return {
      restrict: 'A',
      templateUrl: "mydirective.html",
      scope: {
          myAttr: "@myAttr"//recebe um valor do atributo como string
      },
      link: function(scope, el){
          //escuta alteração no atributo 'myAttr'
          scope.$watch("myAttr", function(newValue, oldValue) {
            if (newValue.length > 10){
                angular.element(el).css({"color": "red"})
            } else {
                angular.element(el).css({"color": "orange"})
            }
          })
      }
    }; 
});


//================================================================
// Filters
//================================================================
app.filter("myFilter", function(){
    return function(value){
        if (value > 8 ){
            return value + " ---> maior"
        } else if (value <= 8){
            return value + " ---> menor"
        }
        return ""
    }
})

//================================================================
// Controllers
//================================================================
app.controller("aloMundoController", ["$scope", function($scope){
    console.info("Criando um controle: aloMundoController")
    $scope.personName = "Ari Garcia"
}])

app.controller("calculadoraController", ["$scope", "calculadoraService", 
        function($scope, calculadoraService){
    console.info("Criando um controle: calculadoraController")
    //
    $scope.add = function(){
        $scope.result = calculadoraService.add($scope.operator1, $scope.operator2)
    }
    $scope.sub = function(){
        $scope.result = calculadoraService.sub($scope.operator1, $scope.operator2)
    }
    
}])

app.controller("personController", ["$scope", "personService", function($scope, personService){
    //
    $scope.load = function(){
        personService.load(function(data){
            $scope.person = data
        })
    }
}])


//================================================================
// Services
//================================================================

app.service("calculadoraService", [function(){
    this.add = function(p1, p2){
        return p1 + p2
    }
    this.sub = function(p1, p2){
        return p1 - p2
    }
}])

app.service("personService", ["$http", function($http){
    this.load = function(callback){
        $http.get("person.json").then(function(result){
            callback(result.data)
        })
    }
}])