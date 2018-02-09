var index=function(){
	
	function init(){
		bindEvent();
	}
	function bindEvent(){
		$("#user").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=userManager");
		});
		$("#admin").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=adminManager");
		});
		$("#seller").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=sellerManager");
		});
		$("#delivery").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=deliveryManager");
		});
		$("#deliveryInfo").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=deliveryInfo");
		});
		/*商品审核*/
		$("#productAuthenticate").bind('click',function(){
			$("#contentPage").load("getPageByUrl?page=productAuthenticate");
		});
	
	}
	var exports={
		'init':init	
	};
	return exports;
}();
$(function(){
	index.init();
})