angular.module('global').controller('LoggerCtrl', function($rootScope, $scope, loginService, $location){

	if(!loginService.isConnected())
	{
		$location.url('/login');
	}
	
	$scope.disconnect = function()
	{
		loginService.disconnect();
	}
});	