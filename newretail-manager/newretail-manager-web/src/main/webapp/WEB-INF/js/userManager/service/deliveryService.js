var deliveryService=function(){
	var service=new Object();
	function getInstance(){
		return service;
	}
	
	function commonInvok(url,param,callback){
		$.post(url,param,callback);
	}
	
	service.queryDataInfo=function(param,callback){
		var url='userManager/queryDelivery';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.addDelivery=function(param,callback){
		var url='userManager/addDelivery';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.updateDelivery=function(param,callback){
		var url='userManager/updateDelivery';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.delDelivery=function(param,callback){
		var url='userManager/delDelivery';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	service.checkDelivery=function(param,callback){
		var url='userManager/checkDelivery';
		var param=param||{};
		commonInvok(url,param,callback);
	}
	var exports={
		'getInstance':getInstance	
	};
	return exports;
}();
