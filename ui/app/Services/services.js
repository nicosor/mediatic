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
		});