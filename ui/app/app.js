angular.module('app', ['ngRoute', 'global', 'myLog', 'myMedia', 'adherent', 'mediaSearch', 'adherentSearch', 'inputDropdownDemo'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
