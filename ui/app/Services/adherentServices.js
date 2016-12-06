angular.module('adherent.services',[])
	.factory('currentAdh', function(){
		var currentAdh = [];
		return {
			setCurrentAdh : function(adh) {
				currentAdh = adh;
			},
			getCurrentAdh : function() {
				return currentAdh;
			}
		}
	});
////	.factory('listAdh', function(getAdherent, currentAdh){
////		var listAdh = [];
////		return {
////			setListAdh : function(url) {
////				var promise = getAdherent.getAdherentList(url, fdgd, listAdh);
////				return promise.then(function(response) {
////					console.log(response.data)
////					listAdh = response.data;
////					console.log('set' + listAdh);
////					
////				});
////			},
////			getListAdh : function() {
////				console.log('get' + listAdh);
////				return listAdh;
////			}
////		}
//	});