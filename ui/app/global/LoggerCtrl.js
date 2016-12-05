angular.module('global').controller('LoggerCtrl', function($scope, loginService, $location){

	if(loginService.isConnected())
	{
		$scope.showMenu=loginService.isConnected();
	}
	else
	{
		$location.url('/login');
	}
	
	this.disconnect = function()
	{
		console.log('deconnexion');
		loginService.disconnect();
	}
});	