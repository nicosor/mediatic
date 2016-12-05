angular.module('app', ['ngRoute', 'global', 'mediaSearch', 'adherent'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
