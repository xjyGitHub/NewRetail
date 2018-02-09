var delivery=function(){
	var pageId='#delivery_page ';
	var service=deliveryService.getInstance();
	var fieldsSetting=new Array();
	var fieldsDisplayName=new Array();
	
	
	function init(){
		console.log("im user");
		getTableSetting();
		console.log(fieldsSetting);
		console.log(fieldsDisplayName);//userManger/getDeliveryList
		dataGridUtils.loadDataGrid(pageId,{},'userManager/getDeliveryList',fieldsSetting,fieldsDisplayName);//selectId,data,ur
		console.log(22);//#deliveryMangerDataGrid",{},''
		//dataGridUtils.initMainGrid();
		buttonBindEvent();
	}
	function buttonBindEvent(){
		$(pageId+' #add').bind('click',function(){
			$(pageId+"#deliveryAddForm").modal('show');
		});
		$(pageId+' #edit').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getDeliveryData(id);
		});
		$(pageId+'#deliveryAddForm #btnSave').bind('click',function(){
			var senderName=$("#deliveryUpdateForm #senderName").val();
			var senderPhone=$("#deliveryUpdateForm #senderPhone").val();
			var param={
					'id':id,
					'senderName':senderName,
					'senderPhone':senderPhone,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					$(pageId+"#deliveryAddForm").modal('hide');
					reloadDataGrid();
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.addDelivery(param,callback);
		});
		
		$(pageId+'#deliveryUpdateForm #btnUpdate').bind('click',function(){
			var id=$("#deliveryUpdateForm #id").val();
			var senderName=$("#deliveryUpdateForm #senderName").val();
			var senderPhone=$("#deliveryUpdateForm #senderPhone").val();
			var param={
					'id':id,
					'senderName':senderName,
					'senderPhone':senderPhone,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					reloadDataGrid();
					$(pageId+"#deliveryUpdateForm").modal('hide');
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.updateDelivery(param,callback);
		});
		
		$(pageId+' #query').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getDeliveryDataInfo(id);
		});
		
		$(pageId+' #delete').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			delDelivery(id);
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
	function getDeliveryDataInfo(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var senderName=data.senderName;
				var senderPhone=data.senderPhone;
				var authenticationStatus=data.authenticationStatus;
				$("#deliveryDataInfo #senderName").html(senderName);
				$("#deliveryDataInfo #senderPhone").html(senderPhone);
				$("#deliveryDataInfo #authenticationStatus").html(authenticationStatus);
				$(pageId+"#deliveryDataInfo").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
	function getDeliveryData(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var id=data.id;
				var senderName=data.senderName;
				var senderPhone=data.senderPhone;
				$(pageId+"#deliveryUpdateForm #id").val(id);
				$(pageId+"#deliveryUpdateForm #senderName").val(senderName);
				$(pageId+"#deliveryUpdateForm #senderPhone").val(senderPhone);
				$(pageId+"#deliveryUpdateForm").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
		
	function getTableSetting(){//
		var tds=$("#delivery_page  #mainCon #managerDataGrid td");
		for(var i=0;i<tds.length;i++){
			var field={};
			var $td=$(tds[i]);
			var name=$td.attr('fieldName');
			var index=$td.attr('fieldName');
			var displayName=$td.attr('displayName');
			var width=$td.attr('width');
			field.name=name;
			field.index=index;
			field.width=width;
			fieldsSetting[i]=field;
			fieldsDisplayName[i]=displayName;
		}
		$("#delivery_page  #mainCon #managerDataGrid").html('');
	}
	
	
	function delDelivery(id){
		var param={id:id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				reloadDataGrid();
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.delDelivery(param,callback);
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
		'init':init	,
	};
	return exports;
}();
$(function(){
	delivery.init();
})