angular.module('app', ['ngRoute', 'global', 'myLog', 'myMedia', 'mediaSearch', 'adherentSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
