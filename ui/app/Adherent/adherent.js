angular.module('adherent', ['ngRoute', 'services'])
	.config(function($routeProvider) {
	
		$routeProvider.when('/adherent', {
			templateUrl:'./adherent/adherent.html',
			controller:'AdherentController',
			controllerAs:'adherentCtrl'
		});
	})
	.controller('AdherentController', function($http, getAdherent, $filter) {
		
		var ctrl = this;
		
		this.adherentList = [];
		var url = 'http://192.168.1.93:8090/resource/adherent.recherche';
		getAdherent.getAdherentList(url).then(function (liste) {
			ctrl.adherentList = liste;
			console.log(ctrl.adherentList)
		});
		this.tutu = new Date()
		this.test="tutu";
});