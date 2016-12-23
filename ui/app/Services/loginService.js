angular
	.module('global')
	.factory('loginService', function($http, $location, $cookies, $rootScope)
	{
		/**var connected;
		
		if($cookies.get('auth') != undefined)
		{
			connected = true;
			$http.defaults.headers.common['Authorization'] = 'Basic ' + $cookies.get('auth');
			$rootScope.showMenu = true;
		}
		
		return {
			connect : function(login, password)
			{
				var code = btoa(login + ':' + password);
				var auth = 'Basic ' + code;
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
						$cookies.put('auth', code);
						$rootScope.showMenu = true;
						$location.url('mediaSearch');
						return true;
					},function()
					{
						connected = false;
						$http.defaults.headers.common['Authorization'] = 'Basic';
						$cookies.remove('auth');
						$rootScope.showMenu = false;
						return false;
					});
			},
			
			isConnected : function()
			{
				return connected;
			},
			
			disconnect : function()
			{
				connected = false;
				$http.defaults.headers.common['Authorization'] = 'Basic';
				$cookies.remove('auth');
				$rootScope.showMenu = false;
				$location.url('login');
				return false;
			}
		}**/
		
		var connected;
		
		if($cookies.get('user') != undefined)
		{
			connected = true;
			$rootScope.showMenu = true;
		}
		
		return {
			
			connect : function(login, password)
			{
				$http.get("localhost:8080/mediatic/login")
					.then(function(response)
					{
						connected = true;
						$cookies.put('user', connected);
						$location.url(response);
						return true;
					},function()
					{
						connected = false;
						$cookies.remove('user');
						$rootScope.showMenu = false;
						return false;
					});
			},
			
			isConnected : function()
			{
				return connected;
			},
			
			disconnect : function()
			{
				connected = false;
				$cookies.remove('user');
				$rootScope.showMenu = false;
				$location.url('login');
				return false;
			}
		}
	});