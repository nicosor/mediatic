angular.module('adherent', ['ngRoute'])
	.config(function($routeProvider) {
	
		$routeProvider.when('/adherent', {
			templateUrl:'./adherent/adherent.html',
			controller:'AdherentController',
			controllerAs:'adherentCtrl'
		});
	})
	.controller('AdherentController', function($http) {
		
		var ctrl = this;
		
		this.adherentList = [];
		var url = 'http://192.168.1.93:8090/resource/adherent.recherche';
		$http.get(url).then(function(response){
			for(var i in response.data){
				console.log(response.data[i]);
				ctrl.adherentList.push(response.data[i]);
			};
		});
		this.test="tutu";
});