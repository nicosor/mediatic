angular
	.module('global')
	.factory('loginService', function($http, $location, $cookies, $rootScope)
	{
		var connected;
		
		return {
			connect : function(login, password)
			{
				var auth = 'Basic ' + btoa(login + ' : ' + password);
				var config = {
						headers : {
							'Authorization' : auth
						}
				};
				$http.get('http://192.168.1.93:8090/resource/connexion.rights', config)
					.then(function()
					{
						connected = true;
						$http.defaults.headers.common['Authorization'] = auth;
						$cookies.put('isConnected', connected);
						$rootScope.showMenu = $cookies.get('isConnected');
						$location.url('media/0');
						return true;
					},function()
					{
						connected = false;
						$http.defaults.headers.common['Authorization'] = 'Basic';
						return false;
					});
			},
			
			isConnected : function()
			{
				console.log(connected);
				return connected;
			},
			
			disconnect : function()
			{
				connected = false;
				$http.defaults.headers.common['Authorization'] = 'Basic';
				$cookies.remove('isConnected');
				$location.url('login');
				return false;
			}
		}
	});