angular
		.module('adherentSearch', ['ngRoute', 'services'])
		.config(function($routeProvider) {
			$routeProvider.when('/adherentSearch', {
				templateUrl : './AdherentSearch/adherentSearch.html',
				controller : 'AdherentSearchController',
				controllerAs : 'adherentSrchCtrl'
			});
		})
		.controller('AdherentSearchController', function($http, getAdherent) {
			var adh = this;
			var url ='http://192.168.1.93:8090/resource/adherent.recherche'
			getAdherent.getAdherentList(url).then(function (liste) {
				adh.catalog = liste;
			});
		});
