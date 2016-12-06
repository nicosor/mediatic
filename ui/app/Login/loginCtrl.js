var log = angular.module('myLog', ['global', 'ngCookies']);

log.config(function($routeProvider)
{
	$routeProvider.when('/login',
			{
				templateUrl : './Login/login.html',
				controller : 'LoginController',
				controllerAs : 'LogCtrl'
			});
});

log.controller('LoginController', function(loginService, $rootScope, $cookies)
{
	var log = this;
	
	log.connect = function()
	{
		loginService.connect();
		console.log('cookieConnect '+ $cookies.get('isConnected'))
		$rootScope.showMenu=$cookies.get('isConnected');
	}
});