angular.module('global').controller('LoggerCtrl', function($scope, loginService){

	if(loginService.isConnected()){
		$scope.showMenu=loginService.isConnected();
	} else {
		$location.url('/login');
	}
});	