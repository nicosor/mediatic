angular.module('app', ['ngRoute', 'global', 'myLog', 'myMedia', 'mediaSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
