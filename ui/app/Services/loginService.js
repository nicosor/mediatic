angular
	.module('global')
	.factory('loginService', function($location)
	{
		var myConn = true;
		return {
			connect : function()
			{
				$location.url('/mediaSearch');
				myConn = false;
			},
			
			disconnect : function()
			{
				$location.url('/login');
				myConn = true;
			},
			isConnected: function(){
				return myConn;
			}
		}
	});