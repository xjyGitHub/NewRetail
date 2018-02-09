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
		initMainGrid:function(){
			var that=this;
			var buildGridObj={
				url:'data/data2.json',
				mtype:'GET',
				height:300,
				colNames:[ 'ID','姓名','性别', '创建日期', 'Ship via','Notes'],
				colModel:[
				{name:'id',index:'id', width:60, sorttype:"int"},
				{name:'name',index:'name', width:150},
				{name:'stock',index:'stock', width:70},
				{name:'sdate',index:'sdate',width:90},
				{name:'ship',index:'ship', width:90},
				{name:'note',index:'note', width:150} 
				], 
				rowList:[10,20,30],
				pager:that.pager_selector,
				viewrecords:true,
				multiselect: true,
				multiboxonly: true,
				rowList:[10,20,30],
				caption:'用户列表',
				ondblClickRow:function(id){

				}
			}
			common.buildGrid(that.$grid_selector,buildGridObj,that.pager_selector);
		}
	}
}();


$(function(){
	page.initMainGrid();
})