//
var app = angular.module('starter.controllers', [])

//
app.controller('DashCtrl', function($scope) {
  //nada
})

//injeta um serviço chamado Chats e o utiliza
app.controller('ChatsCtrl', function($scope, Chats) {
  //chamando .all no serviço
  $scope.chats = Chats.all();
  //vincula o click de botão para remover o item no serviço
  $scope.remove = function(chat) {
    Chats.remove(chat);
  };
})

//
app.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
