angular.module('mediaSearch', [ 'ngRoute', 'services', 'ngSanitize', 'ui.bootstrap' ]).config(
		function($routeProvider) {
			$routeProvider.when('/mediaSearch', {
				templateUrl : './MediaSearch/mediaSearch.html',
				controller : 'mediaSearchController',
				controllerAs : 'mediaSrchCtrl'
			});
		}).controller(
		'mediaSearchController',
		function($http, getUrl, $uibModal, $log, $document) {
			var med = this;
			med.disableScroll=false;
			med.catalog = [];
			med.actualOrder=undefined;
			med.sort = false;
			//med.loadedPage=0;
			
			med.setOrder = function (order) {
				if(order === med.actualOrder){
					med.actualOrder = '-' + order;
				} else {
					med.actualOrder = order;
				}
				med.sort = true;
				med.catalog = [];
				med.loadedPage=0;
				med.disableScroll=false;
				console.log(med.actualOrder);
				getUrl.getSortedList('http://192.168.1.93:8090/resource/media.recherche', med, med.catalog, med.actualOrder);
				
			}

			getUrl.getList('http://192.168.1.93:8090/resource/media.recherche', med, med.catalog);

			med.animationsEnabled = true;
			
			med.nextPage = function () {
				console.log(med.sort);
				if(med.sort) {
					getUrl.getSortedList('http://192.168.1.93:8090/resource/media.recherche', med, med.catalog, med.actualOrder);
				} else {
					getUrl.getList('http://192.168.1.93:8090/resource/media.recherche', med, med.catalog);
				}
				
			}
			
			med.post = function(data) {
				postUrl.post("http://192.168.1.93:8090/resource/media.cration", data);
				ok();
			}

			med.open = function(size, parentSelector) {
				var parentElem = parentSelector ? angular.element($document[0]
						.querySelector('.modal-demo ' + parentSelector))
						: undefined;
				var modalInstance = $uibModal.open({
					animation : med.animationsEnabled,
					ariaLabelledBy : 'modal-title',
					ariaDescribedBy : 'modal-body',
					templateUrl : 'MediaSearch/mediaSearchModal.html',
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

				modalInstance.result.then(function(selectedItem) {
					$ctrl.selected = selectedItem;
				}, function() {
					$log.info('Modal dismissed at: ' + new Date());
				});
			};

			med.openComponentModal = function() {
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
					$ctrl.selected = selectedItem;
				}, function() {
					$log.info('modal-component dismissed at: ' + new Date());
				});
			};

			med.openMultipleModals = function() {
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

			med.toggleAnimation = function() {
				$ctrl.animationsEnabled = !$ctrl.animationsEnabled;
			};
		}).controller('ModalInstanceCtrl', function($uibModalInstance, items) {
	var $ctrl = this;

	$ctrl.ok = function() {
		$uibModalInstance.close($ctrl.selected.item);
	};

	$ctrl.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	};
}).component('modalComponent', {
	templateUrl : 'searchMediaModal',
	bindings : {
		resolve : '<',
		close : '&',
		dismiss : '&'
	},
	controller : function() {
		var $ctrl = this;

		$ctrl.$onInit = function() {
			$ctrl.items = $ctrl.resolve.items;
			$ctrl.selected = {
				item : $ctrl.items[0]
			};
		};

		$ctrl.ok = function() {
			$ctrl.close({
				$value : $ctrl.selected.item
			});
		};

		$ctrl.cancel = function() {
			$ctrl.dismiss({
				$value : 'cancel'
			});
		};
	}
})
