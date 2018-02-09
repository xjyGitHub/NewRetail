var seller=function(){
	var pageId='#seller_page ';
	var service=sellerService.getInstance();
	var fieldsSetting=new Array();
	var fieldsDisplayName=new Array();
	var tableButton=new Array();
	
	function init(){
		console.log("im user");
		getTableSetting();
		console.log(fieldsSetting);
		console.log(fieldsDisplayName);//userManger/getSellerList
		dataGridUtils.loadDataGrid(pageId,{},'userManager/getSellerList',fieldsSetting,fieldsDisplayName);//selectId,data,ur
		console.log(22);//#sellerMangerDataGrid",{},''
		//dataGridUtils.initMainGrid();
		buttonBindEvent();
	}
	
	function buttonBindEvent(){
		$(pageId+' #add').bind('click',function(){
			$(pageId+"#sellerAddForm").modal('show');
		});
		$(pageId+' #edit').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getSellerData(id);
		});
		$(pageId+'#sellerAddForm #btnSave').bind('click',function(){
			var password=$("#sellerAddForm #password").val();
			var shopName=$("#sellerAddForm #shopName").val();
			var managerName=$("#sellerAddForm #sellerName").val();
			var phone=$("#sellerAddForm #phone").val();
			var email=$("#sellerAddForm #email").val();
			var managementClass=$("#sellerAddForm #managementClass").val();
			var createTime=$("#sellerAddForm #createTime").val();
			var updateTime=$("#sellerAddForm #updateTime").val();
			var param={
					'username':managerName,
					'password':password,
					'shop_name':shopName,
					'manager_name':managerName,
					'phone':phone,
					'email':email,
					'management_class':managementClass,
					'createTime':createTime,
					'updateTime':updateTime,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					$(pageId+"#sellerAddForm").modal('hide');
					reloadDataGrid();
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.addSeller(param,callback);
		});
		
		$(pageId+'#sellerUpdateForm #btnUpdate').bind('click',function(){
			var id=$("#sellerUpdateForm #id").val();
			var password=$("#sellerUpdateForm #password").val();
			var shopName=$("#sellerUpdateForm #shopName").val();
			var managerName=$("#sellerUpdateForm #sellerName").val();
			var phone=$("#sellerUpdateForm #phone").val();
			var email=$("#sellerUpdateForm #email").val();
			var managementClass=$("#sellerUpdateForm #managementClass").val();
			var param={
					'id':id,
					'username':managerName,
					'password':password,
					'shop_name':shopName,
					'manager_name':managerName,
					'phone':phone,
					'email':email,
					'management_class':managementClass,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					reloadDataGrid();
					$(pageId+"#sellerUpdateForm").modal('hide');
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.updateSeller(param,callback);
		});
		
		$(pageId+' #query').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getSellerDataInfo(id);
		});
		
		$(pageId+' #delete').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			delSeller(id);
		});
		
		$(pageId+' #check_pass').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			var param={'id':id,'check':1};
			var callback=function(resultVo){
				if(resultVo.status==200){
					reloadDataGrid();
				}else{
					alert(resultVo.msg||'系统异常');
				}
			}
			service.checkSeller(param,callback);
		});
		$(pageId+' #check_unpass').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			var param={'id':id,'check':2};
			var callback=function(resultVo){
				if(resultVo.status==200){
					reloadDataGrid();
				}else{
					alert(resultVo.msg||'系统异常');
				}
			}
			service.checkSeller(param,callback);
		});
		
		$(pageId+' #fresh').bind('click',function(){
			reloadDataGrid();
		});
		
		
	}
	function getSellerDataInfo(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var seller=data.seller;
				var user=data.user;
				var shopName=seller.shopName;
				var managerName=seller.managerName;
				var phone=user.phone;
				var email=user.email;
				var managementClass=seller.managementClass;
				var createTime=seller.createTime;
				var updateTime=seller.updateTime;
				var authenticationStatus=seller.authenticationStatus;
				$("#sellerDataInfo #shopName").html(shopName);
				$("#sellerDataInfo #managerName").html(managerName);
				$("#sellerDataInfo #phone").html(phone);
				$("#sellerDataInfo #email").html(email);
				$("#sellerDataInfo #managementClass").html(managementClass);
				$("#sellerDataInfo #createTime").html(createTime);
				$("#sellerDataInfo #updateTime").html(updateTime);
				$("#sellerDataInfo #authenticationStatus").html(authenticationStatus);
				$(pageId+"#sellerDataInfo").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
	function getSellerData(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var seller=data.seller;
				var user=data.user;
				var password=user.password;
				var shopName=seller.shopName;
				var managerName=seller.managerName;
				var phone=user.phone;
				var email=user.email;
				var managementClass=seller.managementClass;
				$(pageId+"#sellerUpdateForm #id").val(id);
				$(pageId+"#sellerUpdateForm #password").val(password);
				$(pageId+"#sellerUpdateForm #shopName").val(shopName);
				$(pageId+"#sellerUpdateForm #sellerName").val(managerName);
				$(pageId+"#sellerUpdateForm #phone").val(phone);
				$(pageId+"#sellerUpdateForm #email").val(email);
				$(pageId+"#sellerUpdateForm #managementClass").val(managementClass);
				$(pageId+"#sellerUpdateForm").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
		
	function getTableSetting(){//
		var tds=$("#seller_page  #mainCon #managerDataGrid td");
		for(var i=0;i<tds.length;i++){
			var field={};
			var $td=$(tds[i]);
			var displayName=$td.attr('displayName');
				var name=$td.attr('fieldName');
				var index=$td.attr('fieldName');
				var width=$td.attr('width');
				field.name=name;
				field.index=index;
				field.width=width;
				fieldsSetting[i]=field;
				fieldsDisplayName[i]=displayName;
		}
		//$("#seller_page  #mainCon #managerDataGrid").html('');
	}
	
	
	function delSeller(id){
		var param={id:id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				reloadDataGrid();
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.delSeller(param,callback);
	}
	
	function reloadDataGrid(){ // 去查询数据
	 	$(pageId+'#managerDataGrid').jqGrid('clearGridData');
		$(pageId+'#managerDataGrid').trigger('reloadGrid');
	}
	
	function bindEvent(){
		$("#user").bind('click',function(){
		});
	}
	var exports={
		'init':init
	};
	return exports;
}();
$(function(){
	seller.init();
})