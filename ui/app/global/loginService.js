angular.module('global')
.value('loginService', {
	isConnected: function(){
		return true;
	}
});