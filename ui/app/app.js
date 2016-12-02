angular.module('app', ['ngRoute', 'global', 'myLog', 'mediaSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
