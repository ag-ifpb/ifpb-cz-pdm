angular.module('starter.controllers', [])

.controller('DashCtrl', function($scope) {
  $scope.openCamera = function(){
    //
    console.log("cordova--> " + navigator);
    console.log("camera--> " + navigator.camera);
    //
    if (navigator.camera){
      //success
      var onCameraSuccess = function(data){
        var image = document.getElementById('camera');
        image.src = "data:image/jpeg;base64," + data;
      }
      //fail
      function onCameraFail(message) {
          alert('Falhou devido a ' + message);
      }
      //
      navigator.camera.getPicture(
        onCameraSuccess, onCameraFail, { quality: 50,
          destinationType: Camera.DestinationType.DATA_URL
      })

    }

    // //
    // function onSuccess(position) {
    //     var element = document.getElementById('geolocation');
    //     element.innerHTML = 'Latitude: '  + position.coords.latitude      + '<br />' +
    //                         'Longitude: ' + position.coords.longitude     + '<br />' +
    //                         '<hr />'      + element.innerHTML;
    // }

    // // onError Callback receives a PositionError object
    // //
    // function onError(error) {
    //     alert('code: '    + error.code    + '\n' +
    //           'message: ' + error.message + '\n');
    // }

    // Options: throw an error if no update is received every 30 seconds.
    //var watchID = navigator.geolocation.watchPosition(onSuccess, onError, { timeout: 30000 });
  }
})

.controller('ChatsCtrl', function($scope, Chats) {
  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  $scope.chats = Chats.all();
  $scope.remove = function(chat) {
    Chats.remove(chat);
  };
})

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
