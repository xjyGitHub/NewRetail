var adminDeliver=function(){
	return{
		$addForm:$("#addForm"),
		$mainCon:$("#mainCon"),
		$searchForm:$("#searchForm"),
		$grid_selector:$('#grid-table'),
		pager_selector:'#grid-pager',
		//新增
		onTapAdd:function(){
			var that=this;
			that.$addForm.show();
			that.$mainCon.hide();
			that.$searchForm.hide();
		},
		//保存
		onTapSave:function(){
			var that=this;
			common.showTip('正在保存中...');
			setTimeout(function(){
				common.hideTip();
			},1000);
		},
		//返回
		onTapBack:function(){
			var that=this;
			that.$addForm.hide();
			that.$mainCon.show();
			that.$searchForm.show();
		},
		//编辑
		onTapEdit:function(){
			var that=this;
			that.checkRadio();

		},
		//删除
		onTapDel:function(){
			common.confirm('',function(){
				console.log('sure to delete')
			})

		},
		//查看详情
		viewDetail:function(rowId){
			var that=this;
			var rowData = that.$grid_selector.jqGrid('getRowData',rowId);
			$("#myModalDetail").modal('show');
		},
		//上架
		toPutOn:function(){
			var that=this;
			that.checkRadio(function(){
				common.confirm('您确定上架该商品',function(){
				
			  })
			});

		},
		//下架
		toPutDown:function(){
			var that=this;
			that.checkRadio(function(){
				common.confirm('您确定下架该商品',function(){
			  })

			});
		},
		//确认订单
		toConfirm:function(obj){
			var that=this,html='',
			$currModal=$(obj).parents('.modal');
			html+='<div class="">请选择配送方式：';
			html+='<select class="select-sm"><option value="AL">编码</option><option value="AK">名称</option></select>';
			html+='</div>';
			$currModal.find('.modal-body').html(html);
			$(obj).attr('onclick','');
		},
		////商家按状态+时间查询
		queryDeliverDetail:function(rowId){
			var that=this;
			var rowData = that.$grid_selector.jqGrid('getRowData',rowId);
			$("#myModalDetail").modal('show');
		},
		initMainGrid:function(){
			console.log("test查询");
			var that=this;
			var buildGridObj={
				url:'#',	//访问路径
				mtype:'post',	//访问方式
				height:300,		//grid-table表格的高
				colNames:[ '店铺号','店铺名','订单号','下单时间','配送人', '配送状态', '开始时间','结束时间'],//列名，列名的个数与colModel的个数要一致
				colModel:[
				{name:'shopId',index:'shopId', width:150,align:'center'},
				{name:'shopName',index:'shopName', width:60,align:'center'},
				{
					name:'orderId',//这个单元格数据的name
					index:'orderId', //后台数据对应的key值
					width:60, 		//单元格的宽度
					align:'center'	//单元格内容居中
				},
				{name:'orderTime',index:'orderTime', width:150},
				{name:'senderName',index:'senderName', width:70},
				{name:'deliverStatus',index:'deliverStatus',width:90,
					formatter: function(cellvalue, options, rowObject){										
						if(cellvalue=='1'){
							return "待配送";
						}
						if(cellvalue=='2'){
							return "配送中";
						}
						if(cellvalue=='3'){
							return "已配送";
						}
						return "";
					}
				
				},
				{name:'startTime',index:'startTime', width:90},
				{name:'endTime',index:'endTime', width:150},
			], 
			rowList:[10,20,30],	//表示每页的数据数，可以是10,20,30
			pager:that.pager_selector,	//对应分页的控件
			viewrecords:true,
			multiselect: true,
			multiboxonly: true,
			rowList:[10,20,30],
			caption:'配送列表',
			ondblClickRow:function(id){

			}
		}
		common.buildGrid(that.$grid_selector,buildGridObj,that.pager_selector);
	},
	checkRadio:function(callback){
		var that=this;
		var flag=that.$grid_selector.find('tr input[type="checkbox"]:checked').eq(0).val();
		if(!flag){
			layer.msg('请选择操作行');
			return false;
		}else{
			if(callback) callback();
		}

	}
	
	
}
}();

//管理员按条件查询
function queryDeliverByCondition(){
	console.log("22");
	$("#grid-table").jqGrid('clearGridData');
	var orderId = $('#form-field-select-00').val();
	var deliverStatus = $('#form-field-select-1').val();
	var shopId = $('#form-field-select-01').val();
	var startTime = $('#id-date-picker-1').val();
	var endTime = $('#id-date-picker-2').val();
	console.log("订单号："+orderId);
	console.log("配送状态："+deliverStatus);
	console.log("店铺id："+shopId);
	console.log("开始时间："+startTime);
	console.log("结束时间："+endTime);
	$('#grid-table').jqGrid('setGridParam', {
		datatype : "json",
		postData : {
			"orderId" : orderId,
			"deliverStatus" : deliverStatus,
			"shopId" : shopId,
			"startTime" : startTime,
			"endTime" : endTime,
		},		
		mtype : 'post',
		url: '/deliver/queryDeliverByCondition.do',		
	}).trigger('reloadGrid');
}
$(function(){
	adminDeliver.initMainGrid();
	$('#adminQuery').click(function(){queryDeliverByCondition()});
})