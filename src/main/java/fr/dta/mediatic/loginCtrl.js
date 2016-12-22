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

log.controller('LoginController', function(loginService)
{
	var log = this;
	
	log.connect = function(login, password)
	{
		loginService.connect(login, password);
	}
});