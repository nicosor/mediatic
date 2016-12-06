angular.module('app', ['ngRoute', 'global', 'myLog', 'adherent', 'mediaSearch', 'adherentSearch', 'inputDropdownDemo'])
	.config(function($routeProvider){
		$routeProvider.otherwise({
			redirectTo:'/login'
		});
});
