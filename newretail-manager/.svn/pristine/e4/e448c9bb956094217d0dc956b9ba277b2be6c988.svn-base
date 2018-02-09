var sellerService=function(){
	var service=new Object();
	function getInstance(){
		return service;
	}
	
	function commonInvok(url,param,callback){
		$.post(url,param,callback);
	}
	
	service.queryDataInfo=function(param,callback){
		var url='userManager/querySeller';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.addSeller=function(param,callback){
		var url='userManager/addSeller';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.updateSeller=function(param,callback){
		var url='userManager/updateSeller';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.delSeller=function(param,callback){
		var url='userManager/delSeller';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.checkSeller=function(param,callback){
		var url='userManager/checkSeller';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	
	var exports={
		'getInstance':getInstance	
	};
	return exports;
}();
