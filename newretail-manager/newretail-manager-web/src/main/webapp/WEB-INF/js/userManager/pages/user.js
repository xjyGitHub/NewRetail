var user=function(){
	var pageId='#user_page ';
	var service=userService.getInstance();
	var fieldsSetting=new Array();
	var fieldsDisplayName=new Array();
	
	
	function init(){
		console.log("im user");
		getTableSetting();
		console.log(fieldsSetting);
		console.log(fieldsDisplayName);//userManger/getuserList
		dataGridUtils.loadDataGrid(pageId,{},'userManager/getUserList',fieldsSetting,fieldsDisplayName);//selectId,data,ur
		console.log(22);//#userMangerDataGrid",{},''
		//dataGridUtils.initMainGrid();
		buttonBindEvent();
	}
	
	function buttonBindEvent(){
		$(pageId+' #add').bind('click',function(){
			$(pageId+"#userAddForm").modal('show');
		});
		$(pageId+' #edit').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getUserData(id);
		});
		$(pageId+'#userAddForm #btnSave').bind('click',function(){
			var password=$("#userAddForm #password").val();
			var username=$("#userAddForm #username").val();
			var phone=$("#userAddForm #phone").val();
			var email=$("#userAddForm #email").val();
			var param={
					'username':username,
					'password':password,
					'phone':phone,
					'email':email,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					$(pageId+"#userAddForm").modal('hide');
					reloadDataGrid();
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.addUser(param,callback);
		});
		$(pageId+'#userUpdateForm #btnUpdate').bind('click',function(){
			var id=$("#userUpdateForm #id").val();
			var password=$("#userUpdateForm #password").val();
			var username=$("#userUpdateForm #username").val();
			var sex=$("#userUpdateForm #sex").val();
			var phone=$("#userUpdateForm #phone").val();
			var email=$("#userUpdateForm #email").val();
			console.log(username);
			var param={
					'id':id,
					'username':username,
					'password':password,
					'sex':sex,
					'phone':phone,
					'email':email,
			};
			var callback=function(resultVo){
				if(resultVo.status==200){
					reloadDataGrid();
					$(pageId+"#userUpdateForm").modal('hide');
				}else{
					alert(resultVo.msg||'系统异常');
				}
				
			};
			service.updateUser(param,callback);
		});
		
		$(pageId+' #query').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			getUserDataInfo(id);
		});
		
		$(pageId+' #delete').bind('click',function(){
			var id=$(pageId+'#managerDataGrid').jqGrid('getGridParam','selrow');
			deluser(id);
		});
		
		$(pageId+' #fresh').bind('click',function(){
			reloadDataGrid();
		});
		
		
	}
	function getUserDataInfo(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var username=data.username;
				var sex=data.sex;
				var phone=data.phone;
				var email=data.email;
				var createTime=data.createTime;
				var updateTime=data.updateTime;
				$("#userDataInfo #username").html(username);
				$("#userDataInfo #sex").html(sex);
				$("#userDataInfo #phone").html(phone);
				$("#userDataInfo #email").html(email);
				$("#userDataInfo #createTime").html(createTime);
				$("#userDataInfo #updateTime").html(updateTime);
				$(pageId+"#userDataInfo").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
	function getUserData(id){
		var param={'id':id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				var data=resultVo.data;
				var password=data.password;
				var username=data.username;
				var sex=data.sex;
				var phone=data.phone;
				var email=data.email;
				$(pageId+"#userUpdateForm #id").val(id);
				$(pageId+"#userUpdateForm #password").val(password);
				$(pageId+"#userUpdateForm #sex").val(sex);
				$(pageId+"#userUpdateForm #username").val(username);
				$(pageId+"#userUpdateForm #phone").val(phone);
				$(pageId+"#userUpdateForm #email").val(email);
				$(pageId+"#userUpdateForm").modal('show');
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.queryDataInfo(param,callback);
	}
		
	function getTableSetting(){//
		var tds=$("#user_page  #mainCon #managerDataGrid td");
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
		$("#user_page  #mainCon #managerDataGrid").html('');
	}
	
	
	function delUser(id){
		var param={id:id};
		var callback=function(resultVo){
			if(resultVo.status==200){
				reloadDataGrid();
			}else{
				alert(resultVo.msg||'系统异常');
			}
		}
		service.delUser(param,callback);
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
	user.init();
})