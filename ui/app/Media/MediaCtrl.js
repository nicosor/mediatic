var media = angular.module('myMedia', ['ngRoute', 'global', 'services', 'ngSanitize', 'ui.bootstrap']);

media.config(function($routeProvider)
{
	$routeProvider.when('/media/:idMed',
			{
				templateUrl : './Media/Media.html',
				controller : 'MediaController',
				controllerAs : 'MedCtrl'
			});
});

media.controller('MediaController', function($scope, $http, $routeParams, getUrl, $uibModal, $log, $document)
{

	var media = this;
	$scope.showmebis = true;
	media.modify = function(str)
	{
		if(str == 'mod')
		{
			$scope.showmebis = false;
			$scope.showme = true;
		}
		else
		{
			$scope.showmebis = true;
			$scope.showme = false;
		}
		
	}
	this.currentId = $routeParams.idMed;
	media.mediaList = [];
	var url = 'http://192.168.1.93:8090/resource/media.recherche';
	getUrl.getList(url, media, media.mediaList);
	
	media.open = function(size, parentSelector) {
		var parentElem = parentSelector ? angular.element($document[0]
				.querySelector('.modal-demo ' + parentSelector))
				: undefined;
		var modalInstance = $uibModal.open({
			animation : media.animationsEnabled,
			ariaLabelledBy : 'modal-title',
			ariaDescribedBy : 'modal-body',
			templateUrl : 'Media/mediaModal.html',
			controller : 'ModalCtrl',
			controllerAs : '$medCtrl',
			size : size,
			appendTo : parentElem,
			resolve : {
				items : function() {
					return media.items;
				}
			}
		});

		modalInstance.result.then(function(selectedItem) {
			$medCtrl.selected = selectedItem;
		}, function() {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};

}).controller('ModalCtrl', function($uibModalInstance, items) {
	var $ctrl = this;
	  $ctrl.items = items;
	  $ctrl.selected = {
	    item: $ctrl.items[0]
	  };

	$medCtrl.ok = function() {
		$uibModalInstance.close($medCtrl.selected.item);
	};

	$medCtrl.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	};
}).component('modalComponent', {
	templateUrl : 'mediaModal',
	bindings : {
		resolve : '<',
		close : '&',
		dismiss : '&'
	},
	controller : function() {
		var $medCtrl = this;
		$medCtrl.items = items;
		  $medCtrl.selected = {
		    item: $medCtrl.items[0]
		  };
		  
		$medCtrl.$onInit = function() {
			$medCtrl.items = $medCtrl.resolve.items;
			$medCtrl.selected = {
				item : $medCtrl.items[0]
			};
		};

		$medCtrl.ok = function() {
			$medCtrl.close({
				$value : $medCtrl.selected.item
			});
		};

		$medCtrl.cancel = function() {
			$medCtrl.dismiss({
				$value : 'cancel'
			});
		};
	}
})