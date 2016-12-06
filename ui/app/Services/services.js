angular.module('services', [])
	.factory('getUrl',function($http) {
			return {
				getList : function(url) {
					var promise = $http.get(url);
					return promise.then(function(response) {
						return response.data;
					});
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
			
	})