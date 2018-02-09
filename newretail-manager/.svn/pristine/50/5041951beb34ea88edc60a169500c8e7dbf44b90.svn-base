var allHandler=function(){
	return{
		/****/
		$popupTable:$("#pop-grid-table"),
		popupPager:"#pop-grid-pager",
		currPopRow:'',
		$modal:'',
		
		//查找
		onTapFindPop:function(ele){
			var that=this;
			var modalId=$(ele).attr('data-target'),
			url=$(ele).attr('data-url');
			that.$modal=$(modalId);
			var buildGridObj={
				url:url,
				mtype:'GET',
				height:250,
				width:538,
				autowidth:538,
				colNames:[ '编码','名称'],
				colModel:[
				{name:'pmCode',index:'pmCode', sorttype:"int",sortable:true},
				{name:'ebcuNameCn',index:'ebcuNameCn',sortable:true}
				], 
				pager:that.popupPager,
				viewrecords:false,
				onSelectRow: function(id){     
					that.currPopRow=id;
				}, 
				ondblClickRow:function(id){
					var rowData = that.$popupTable.jqGrid('getRowData',id);
					common.fillToPage(rowData,$("#searchForm"));
					that.$modal.modal('hide');
				}
			}
			common.buildGrid(that.$popupTable,buildGridObj);
		},
		//确定选择
		onTapChoseRow:function(){
			var that=this;
			console.log(that.currPopRow);
			if(that.currPopRow){
				var rowData = that.$popupTable.jqGrid('getRowData',that.currPopRow);
				common.fillToPage(rowData,$("#searchForm"));
				that.$modal.modal('hide');
			}
		}

	}
}();