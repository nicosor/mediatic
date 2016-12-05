angular.module('app', ['ngRoute', 'global', 'myLog', 'mediaSearch', 'adherentSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
