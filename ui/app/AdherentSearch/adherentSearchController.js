angular
		.module('adherentSearch', ['ngRoute', 'services'])
		.config(function($routeProvider) {
			$routeProvider.when('/adherentSearch', {
				templateUrl : './AdherentSearch/adherentSearch.html',
				controller : 'AdherentSearchController',
				controllerAs : 'adherentSrchCtrl'
			});
		})
		.controller('AdherentSearchController', function($http, getUrl) {
			var adh = this;
			var url ='http://192.168.1.93:8090/resource/adherent.recherche'
			
			adh.catalog = [];
			getUrl.getList(url, this, adh.catalog);
			
			adh.getFilter = function(){
				return {
					id:(adh.idFilter==null?undefined:adh.idFilter), 
					nom:adh.nameFilter, 
					prenom:adh.surnameFilter
				};
			};
			
			adh.checkCotisation = function(item){
				return item.cotisation.fin > new Date();
			};
			
			adh.nextPage = function () {
				getUrl.getList(url, adh, adh.catalog);
			}

		});
