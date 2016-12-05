angular.module('app', ['ngRoute', 'global', 'myLog', 'adherent', 'mediaSearch', 'adherentSearch'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
