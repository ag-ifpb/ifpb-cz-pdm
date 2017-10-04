//define o módulo principal ou aplicação
var app = angular.module('my-app', ['ionic', 'starter.controllers', 'starter.services'])

//cria um execução de callback quando a aplicação é executada
app.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if (window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})

//criar a configuração de visão e roteamento
app.config(function($stateProvider, $urlRouterProvider) {

  //estado abstrato da visão (permite a inclusão de novas views concretas)
  $stateProvider.state('tab', {
    url: '/tab',
    abstract: true,
    templateUrl: 'templates/tabs.html'
  })

  //view concreta
  $stateProvider.state('tab.dash', {
    url: '/dash',//--> #/tab/dash
    views: {
      'tab-dash': {
        templateUrl: 'templates/tab-dash.html',
        controller: 'DashCtrl'
      }
    }
  })

  //view concreta
  $stateProvider.state('tab.chats', {
      url: '/chats',//--> #/tab/chats
      views: {
        'tab-chats': {
          templateUrl: 'templates/tab-chats.html',
          controller: 'ChatsCtrl'
        }
      }
    })

  //view concreta
  $stateProvider.state('tab.chat-detail', {
      url: '/chats/:chatId',
      views: {
        'tab-chats': {
          templateUrl: 'templates/chat-detail.html',
          controller: 'ChatDetailCtrl'
        }
      }
    })

  //view concreta
  $stateProvider.state('tab.account', {
    url: '/account',
    views: {
      'tab-account': {
        templateUrl: 'templates/tab-account.html',
        controller: 'AccountCtrl'
      }
    }
  });

  $urlRouterProvider.otherwise('/tab/account');

});
