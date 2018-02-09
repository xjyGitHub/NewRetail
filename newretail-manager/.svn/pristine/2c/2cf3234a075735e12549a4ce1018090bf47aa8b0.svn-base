var page=function(){
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
		initMainGrid:function(){
			var that=this;
			var buildGridObj={
				url:'data/data3.json',
				mtype:'GET',
				height:300,
				colNames:[ 'ID','商品名称','单价', '类别', '销量','库存','操作人','状态','时间','操作'],
				colModel:[
				{name:'id',index:'id', width:60, sorttype:"int"},
				{name:'skuName',index:'skuName', width:150},
				{name:'price',index:'price', width:70},
				{name:'payStatus',index:'payStatus',width:90},
				{name:'deliveryStatus',index:'deliveryStatus', width:90},
				{name:'orderStatus',index:'orderStatus', width:150},
				{name:'money',index:'money', width:150},
				{name:'status',index:'status', width:150},
				{name:'orderTime',index:'orderTime', width:150},
				{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
				formatter: function (value, grid, rows, state) { return "<button class=\"btn btn-xs btn-info\" onclick=\"page.viewDetail(" + rows.id + ")\">查看</button>" }  
			},
			], 
			rowList:[10,20,30],
			pager:that.pager_selector,
			viewrecords:true,
			multiselect: true,
			multiboxonly: true,
			rowList:[10,20,30],
			caption:'订单列表',
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


$(function(){
	page.initMainGrid();
})