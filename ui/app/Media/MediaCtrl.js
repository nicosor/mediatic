var med = angular.module('myMedia', ['global']);

med.config(function($routeProvider)
{
	$routeProvider.when('/media',
			{
				templateUrl : './Media/Media.html',
				controller : 'MediaController',
				controllerAs : 'MedCtrl'
			});
});

med.controller('MediaController', function()
{
	
});