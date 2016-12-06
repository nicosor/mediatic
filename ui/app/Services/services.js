angular.module('services', ['infinite-scroll'])
	.factory('getUrl',function($http, $q) {
			var previous = $q.resolve();
			return {
				getList : function(url, ctrl, liste) {
					var temp = previous;
					var defer = $q.defer();
					previous = defer.promise;
					temp.then( function() {
						var page = (ctrl.loadedPage===undefined?0:ctrl.loadedPage+1);
						$http.get(url, {params:{page:page}}).then(function(response) {
							console.log(page, response.data.length, ctrl.loadedPage, response.data);
							for(var i = 0; i < response.data.length; i++) {
								liste.push(response.data[i]);
							} 
							ctrl.loadedPage = page;
							defer.resolve();
						});
					});
					return previous;
				}
			}
		})
	.factory('getAdherent', function(getUrl){
		return {
			getAdherentList : function(url) {
				return getUrl.getList(url).then(function(resp){
					for (var i = 0 in resp) {
						resp[i].date_naissance = new Date(resp[i].date_naissance);
						resp[i]["cotisation"].debut = new Date(resp[i]["cotisation"].debut);
						resp[i]["cotisation"].fin = new Date(resp[i]["cotisation"].fin);
						for (var j = 0 in resp[i]["emprunt"]) {
							resp[i]["emprunt"][j].depart = new Date(resp[i]["emprunt"][j].depart);
							resp[i]["emprunt"][j].retour = new Date(resp[i]["emprunt"][j].retour);
						};
					};
					return resp;
				});
			}
		}		
	})
	.factory('getMedia', function(getUrl)
	{
		return {
			getMediaList : function(url)
			{
				return getUrl.getList(url).then(function(resp)
				{
					return resp;
				});
			}
		}
			
	});
