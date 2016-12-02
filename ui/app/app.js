angular.module('app', ['ngRoute', 'global', 'mediaSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
