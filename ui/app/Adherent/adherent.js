angular.module('adherent', ['ngRoute', 'services'])
	.config(function($routeProvider) {
	
		$routeProvider.when('/adherent/:idAdh', {
			templateUrl:'./Adherent/adherent.html',
			controller:'AdherentController',
			controllerAs:'aList'
		});
	})
	.controller('AdherentController', function($http, $routeParams, getAdherent) {
		
		var ctrl = this;
		
		this.currentId = $routeParams.idAdh;
		this.adherentList = [];
		var url = 'http://192.168.1.93:8090/resource/adherent.recherche';
		getAdherent.getAdherentList(url).then(function (liste) {
			ctrl.adherentList = liste;
		});
});