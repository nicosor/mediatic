angular
		.module('mediaSearch', ['ngRoute'])
		.config(function($routeProvider) {
			$routeProvider.when('/mediaSearch', {
				templateUrl : './MediaSearch/mediaSearch.html',
				controller : 'mediaSearchController',
				controllerAs : 'mediaSrchCtrl'
			});
		})
		.controller('mediaSearchController', 
		function($http, getUrl) {
			var med = this;
			getUrl.getList('http://192.168.1.93:8090/resource/media.recherche').then(function (liste) {;
			med.catalog = liste;
			});
		})
		.factory(
				'getUrl',
				function($http) {
					return {
						getList : function(url) {
							var promise = $http.get(url);
							return promise.then(function(response) {
								console.log(response.data);
								return response.data;
							});
						}
					}
				});