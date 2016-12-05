angular.module('global').controller('LoggerCtrl', function($scope, $cookies, loginService, $location){

	if($cookies.get('isConnected') != undefined)
	{
		console.log('cookieMenu '+ $cookies.get('isConnected'));
		$scope.showMenu = $cookies.get('isConnected');
	}
	else
	{
		$location.url('/login');
	}
	
	$scope.disconnect = function()
	{
		console.log('deconnexion');
		loginService.disconnect();
		$scope.showMenu=$cookies.get('isConnected');
	}
});	