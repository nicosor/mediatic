angular.module('app', ['ngRoute', 'global', 'myLog', 'myMedia', 'adherent', 'mediaSearch', 'adherentSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
