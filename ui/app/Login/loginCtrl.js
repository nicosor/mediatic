var log = angular.module('myLog', ['global']);

log.config(function($routeProvider)
{
	$routeProvider.when('/login',
			{
				templateUrl : './Login/login.html',
				controller : 'LoginController',
				controllerAs : 'LogCtrl'
			});
});

log.controller('LoginController', function(loginService, $rootScope)
{
	$rootScope.header = 'Page de connexion';
	var log = this;
	
	log.connect = function()
	{
		loginService.connect();
	}
});