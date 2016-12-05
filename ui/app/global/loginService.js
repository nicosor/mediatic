angular
	.module('global')
	.factory('loginService', function($location, $cookies)
	{
		var myConn;
		if($cookies.get('isConnected') != undefined)
		{
			console.log('cookieVar '+ $cookies.get('isConnected'));
			myConn = $cookies.get('isConnected');
		}
		else
		{
			myConn = false;
		}
		
		return {
			connect : function()
			{
				$location.url('/media');
				myConn = true;
				$cookies.put('isConnected', myConn);
			},
			
			disconnect : function()
			{
				$location.url('/login');
				myConn = false;
				$cookies.remove('isConnected');
				console.log('disconn '+ myConn);

			}		
		}
	});