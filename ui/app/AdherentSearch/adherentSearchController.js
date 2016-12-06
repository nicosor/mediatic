angular
		.module('adherentSearch', ['ngRoute', 'services', 'ngSanitize', 'ui.bootstrap'])
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
			};

		})
		.controller('ModalAdherentSearchController', function ($scope, $uibModal, $log, currentAdh){
			var adh = this;

			adh.animationEnabled = true;
			
			this.newAdherent = {nom : "", 
					prenom : "",
					date_naissance : "",
					email : "",
					adresse : {ligne1 : "", ligne2 : "", ville : "", codepostal : ""},
					cotisation : {debut : "", fin : "", montant : ""}
			};
			
			adh.ok = function () {
				this.curAdh = (currentAdh.getCurrentAdh())
				adh.addAdherent(this.curAdh);
				$scope.$close(undefined);
			};
			
			adh.cancel = function(){
				$scope.$close(undefined);
			};
			
			adh.open = function(size, parentSelector){
				
				var parentElem = parentSelector ? angular.element($document[0]
						.querySelector('.modal-demo ' + parentSelector))
						: undefined;
				var modalInstance = $uibModal.open({
					animation : adh.animationEnabled,
					arialLabelledBy : 'modal-title',
					arialDescribedBy : 'modal-body',
					templateUrl : 'AdherentSearch/adherentSearchModal.html',
					controller : 'ModalInstanceCtrl',
					controllerAs : '$ctrl',
					size : size,
					appendTo : parentElem,
					resolve : {
						items : function() {
							return med.items;
						}
					}
				});
				
				modalInstance.result.then(function(selectedItem){
					adh.selected = selectedItem;
				}, function(){
					$log.info('Modal dismissed at: ' + new Date());
				});
			};
			
			this.openComponentModal = function() {
				var modalInstance = $uibModal.open({
					animation : adh.animationEnabled,
					component : 'modalComponent',
					resolve : {
						items : function(){
							return $ctrl.items;
						}
					}
				});
				
				modalInstance.result.then(function(selectedItem) {
					adh.selected = selectedItem;
				}, function() {
					$log.info('modal-component dismissed at: ' + new Date());
				});
			};

			this.openMultipleModals = function() {
				$uibModal.open({
					animation : $ctrl.animationsEnabled,
					ariaLabelledBy : 'modal-title-bottom',
					ariaDescribedBy : 'modal-body-bottom',
					templateUrl : 'stackedModal.html',
					size : 'sm',
					controller : function($scope) {
						$scope.name = 'bottom';
					}
				});

				$uibModal.open({
					animation : $ctrl.animationsEnabled,
					ariaLabelledBy : 'modal-title-top',
					ariaDescribedBy : 'modal-body-top',
					templateUrl : 'stackedModal.html',
					size : 'sm',
					controller : function($scope) {
						$scope.name = 'top';
					}
				});
			};

			this.toggleAnimation = function() {
				adh.animationsEnabled = !adh.animationsEnabled;
			};
		})
		.component('modalComponent', {
			templateUrl : 'searchAdherentModal',
			bindings : {
				resolve : '<',
				close : '&',
				dismiss : '&'
		},
		controller : function() {
			var $adh = this;
	
			$adh.$onInit = function() {
				$adh.items = $adh.resolve.items;
				$adh.selected = {
					item : $ctrl.items[0]
				};
			};
	
			$adh.ok = function() {
				$adh.close({
					$value : $adh.selected.item
				});
			};
	
			$adh.cancel = function() {
				$adh.dismiss({
					$value : 'cancel'
				});
			};
		}
});
