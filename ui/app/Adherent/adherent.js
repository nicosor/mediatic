angular.module('adherent', ['ngRoute', 'services', 'ngSanitize', 'ui.bootstrap', 'adherent.services'])
	.config(function($routeProvider) {
	
		$routeProvider.when('/adherent/:idAdh', {
			templateUrl:'./Adherent/adherent.html',
			controller:'AdherentController',
			controllerAs:'aList'
		});
	})

	.controller('modalAdherentController', function ($scope, $uibModal, $log, currentAdh) {
		  var ctrl = this;
		  
		  this.mydata = {titre : "", date : ""};
		  
		  ctrl.addBorrow = function (curAdh){
			  var url = 'http://192.168.1.93:8090/resource/adherent.accession';
			  console.log("ajout de l'emprunt : " + this.mydata.titre + this.mydata.date)
			  curAdh['emprunt'].push({titre : this.mydata.titre, depart : this.mydata.date})
			  console.log(curAdh['emprunt'])
		  };
	
		  
		  ctrl.ok = function () {
			  this.curAdh = (currentAdh.getCurrentAdh())
			  ctrl.addBorrow(this.curAdh);
			  $scope.$close(undefined);
		  };
		  
	
		  ctrl.cancel = function () {
			  $scope.$close(undefined);
		  };
		  
		  
		  this.open = function(size, parentSelector) {
				var parentElem = parentSelector ? angular.element($document[0]
						.querySelector('.modal-demo ' + parentSelector))
						: undefined;
				var modalInstance = $uibModal.open({
					animation : this.animationsEnabled,
					ariaLabelledBy : 'modal-title',
					ariaDescribedBy : 'modal-body',
					templateUrl : 'Adherent/adherentModal.html',
					controller : 'ModalInstanceCtrl',
					controllerAs : '$ctrl',
					size : size,
					appendTo : parentElem,
					resolve : {
						items : function() {
							return this.items;
						}
					}
				});

				modalInstance.result.then(function(selectedItem) {
					ctrl.selected = selectedItem;
				}, function() {
					$log.info('Modal dismissed at: ' + new Date());
				});
			};

			this.openComponentModal = function() {
				var modalInstance = $uibModal.open({
					animation : $ctrl.animationsEnabled,
					component : 'modalComponent',
					resolve : {
						items : function() {
							return $ctrl.items;
						}
					}
				});

				modalInstance.result.then(function(selectedItem) {
					ctrl.selected = selectedItem;
				}, function() {
					$log.info('modal-component dismissed at: ' + new Date());
				});
			};

			this.openMultipleModals = function() {
				$uibModal.open({
					animation : ctrl.animationsEnabled,
					ariaLabelledBy : 'modal-title-bottom',
					ariaDescribedBy : 'modal-body-bottom',
					templateUrl : 'stackedModal.html',
					size : 'sm',
					controller : function($scope) {
						$scope.name = 'bottom';
					}
				});

				$uibModal.open({
					animation : ctrl.animationsEnabled,
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
				ctrl.animationsEnabled = !ctrl.animationsEnabled;
			};
		})
		.controller('ModalInstanceCtrl', function($uibModalInstance, items) {
			var ctrl = this;
			
			}).component('modalComponent', {
			templateUrl : 'searchMediaModal',
			bindings : {
				resolve : '<',
				close : '&',
				dismiss : '&'
			},
			controller : function() {
				var ctrl = this;
			
				ctrl.$onInit = function() {
					ctrl.items = ctrl.resolve.items;
					ctrl.selected = {
						item : ctrl.items[0]
					};
				};
			
				ctrl.ok = function() {
					ctrl.close({
						$value : ctrl.selected.item
					});
				};
			
				ctrl.cancel = function() {
					ctrl.dismiss({
						$value : 'cancel'
					});
				};
			}
	})
	.controller('AdherentController', function($http, $routeParams, currentAdh, getUrl) {
		
		var ctrl = this;
		
		this.currentId = $routeParams.idAdh;
		var url = 'http://192.168.1.93:8090/resource/adherent.recherche';
		this.adherentList = [];
		getUrl.getList(url, this, this.adherentList).then (function() {
			console.log("toto" , ctrl.adherentList)
			for (var i = 0 in ctrl.adherentList) {
				ctrl.adherentList[i].date_naissance = new Date(ctrl.adherentList[i].date_naissance);
				ctrl.adherentList[i]["cotisation"].debut = new Date(ctrl.adherentList[i]["cotisation"].debut);
				ctrl.adherentList[i]["cotisation"].fin = new Date(ctrl.adherentList[i]["cotisation"].fin);
				for (var j = 0 in ctrl.adherentList[i]["emprunt"]) {
					ctrl.adherentList[i]["emprunt"][j].depart = new Date(ctrl.adherentList[i]["emprunt"][j].depart);
					ctrl.adherentList[i]["emprunt"][j].retour = new Date(ctrl.adherentList[i]["emprunt"][j].retour);
				};
			};
		});

});
