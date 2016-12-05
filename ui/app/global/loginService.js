angular
	.module('global')
	.factory('loginService', function($location)
	{
		var myConn = false;
		return {
			connect : function()
			{
				$location.url('/media');
				myConn = true;
				console.log('conn '+myConn);
			},
			
			disconnect : function()
			{
				$location.url('/login');
				myConn = false;
				console.log('disconn '+myConn);
			},
			isConnected: function()
			{
				console.log('isconn '+myConn);
				return myConn;
			}
		}
	});