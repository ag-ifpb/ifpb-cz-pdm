//
var app = angular.module('ifpbApp', [
  'ionic',
  'controllers'
])
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
});

app.config(function($stateProvider, $urlRouterProvider) {
  //
  $stateProvider.state('home', {
    url: '/home',
    abstract: false,
    templateUrl: 'tpl/home.tpl',
    controller: 'homeController'
  });
  //
  $stateProvider.state('news', {
    url: '/news',
    abstract: false,
    templateUrl: 'tpl/news.tpl'
  });
  //
  $stateProvider.state('list', {
    url: '/list',
    abstract: false,
    templateUrl: 'tpl/list.tpl'
  });
  //
  $urlRouterProvider.otherwise('/home');
})
