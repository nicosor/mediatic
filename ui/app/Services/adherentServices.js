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
	})
	.factory('mediaDropDown',function($http, $q) {
			var previous = $q.resolve();
			return {
				getMediaList : function(url, ctrl, liste) {
					var temp = previous;
					var defer = $q.defer();
					previous = defer.promise;
					temp.then( function() {
						var titre = (ctrl.titre===undefined?0:ctrl.titre);
						console.log('titre ctrl : ' , ctrl.titre);
						$http.get(url, {params:{page:0, titre:titre}}).then(function(response) {
							for(var i = 0; i < response.data.length; i++) {
								liste.push(response.data[i]);
								liste[i].readableName = response.data[i].titre;
							}
							defer.resolve();
						});
					});
					return previous;
				}
			}
		});