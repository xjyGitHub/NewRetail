var adminService=function(){
	var service=new Object();
	function getInstance(){
		return service;
	}
	
	function commonInvok(url,param,callback){
		$.post(url,param,callback);
	}
	
	service.queryDataInfo=function(param,callback){
		var url='userManager/queryAdmin';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.addAdmin=function(param,callback){
		var url='userManager/addAdmin';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.updateAdmin=function(param,callback){
		var url='userManager/updateAdmin';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.delAdmin=function(param,callback){
		var url='userManager/delAdmin';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	
	var exports={
		'getInstance':getInstance	
	};
	return exports;
}();
