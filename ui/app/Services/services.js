angular.module('services', []).factory(
		'getUrl',
		function($http) {
			return {
				getList : function(url) {
					var promise = $http.get(url);
					return promise.then(function(response) {
						console.log(response.data);
						return response.data;
					});
				}
			}
		});