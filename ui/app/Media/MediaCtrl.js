var med = angular.module('myMedia', ['ngRoute', 'global', 'services']);

med.config(function($routeProvider)
{
	$routeProvider.when('/media/:idMed',
			{
				templateUrl : './Media/Media.html',
				controller : 'MediaController',
				controllerAs : 'MedCtrl'
			});
});

med.controller('MediaController', function($scope, $http, $routeParams, getMedia)
{

	var med = this;
	$scope.showmebis = true;
	med.modify = function(str)
	{
		if(str == 'mod')
		{
			$scope.showmebis = false;
			$scope.showme = true;
		}
		else
		{
			$scope.showmebis = true;
			$scope.showme = false;
		}
		
	}
	this.currentId = $routeParams.idMed;
	med.adherentList = [];
	var url = 'http://192.168.1.93:8090/resource/media.recherche';
	getMedia.getMediaList(url).then(function (liste)
	{
		med.mediaList = liste;
		console.log(med.mediaList);
	});
});