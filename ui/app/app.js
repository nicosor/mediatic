angular.module('app', ['ngRoute', 'global', 'mediaSearch', 'adherentSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
