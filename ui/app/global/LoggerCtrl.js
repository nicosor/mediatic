angular.module('global').controller('LoggerCtrl', function($scope, loginService, $location){

	if(loginService.isConnected())
	{
		console.log('lgct '+loginService.isConnected());
		$scope.showMenu=loginService.isConnected();
	}
	else
	{
		console.log('lgcf '+loginService.isConnected());
		$location.url('/login');
	}
	
	this.disconnect = function()
	{
		console.log('deconnexion');
		loginService.disconnect();
	}
});	