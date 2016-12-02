angular
		.module('adherentSearch', ['ngRoute', 'services'])
		.config(function($routeProvider) {
			$routeProvider.when('/adherentSearch', {
				templateUrl : './AdherentSearch/adherentSearch.html',
				controller : 'adherentSearchController',
				controllerAs : 'adherentSrchCtrl'
			});
		})
		.controller('adherentSearchController', 
		function($http, getUrl) {
			var adh = this;
			getUrl.getList('http://192.168.1.93:8090/resource/adherent.recherche').then(function (liste) {
				adh.catalog = liste;
			});
		});
