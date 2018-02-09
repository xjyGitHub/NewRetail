var userService=function(){
	var service=new Object();
	function getInstance(){
		return service;
	}
	
	function commonInvok(url,param,callback){
		$.post(url,param,callback);
	}
	
	service.queryDataInfo=function(param,callback){
		var url='userManager/queryUser';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.addUser=function(param,callback){
		var url='userManager/addUser';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.updateUser=function(param,callback){
		var url='userManager/updateUser';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.delUser=function(param,callback){
		var url='userManager/delUser';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	
	var exports={
		'getInstance':getInstance	
	};
	return exports;
}();
