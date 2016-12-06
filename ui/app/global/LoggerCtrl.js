angular.module('global').controller('LoggerCtrl', function($rootScope, $scope, $cookies, loginService, $location){

	if($cookies.get('isConnected') != undefined)
	{
		$scope.showMenu = $cookies.get('isConnected');
	}
	else
	{
		$location.url('/login');
	}
	
	$scope.disconnect = function()
	{
		loginService.disconnect();
		$scope.showMenu = false;
	}
});	