var dataGridUtils=function(){

	 function loadDataGrid(pageId,param,url,colModeldata,fieldisplayName) { // 初始化
		 	var colModels=new Array();
			for(var i=0;i<colModeldata.length;i++){
				var colModel={};
				colModel.name=colModeldata[i].name;
				colModel.index=colModeldata[i].name;
				colModel.width=colModeldata[i].width;
				colModels[i]=colModel;
			}
		 
			var buildGridObj = {
				datatype : "json",
				mtype : 'post',
				postData : {
					//"goodsName" : searchGoodsName,
					//"searchSelect" : searchSelect
				},
				url : url,// 默认不去请求数据，只显示表格头部
				height : 400,
				autowidth : true,
				colNames : fieldisplayName/*[ 'ID', '商品ID', '商品名称', '单价(元)', '折扣(折)', '商品分类', '销量',
						'库存','状态', '时间', '操作' ]*/,
				colModel : /*[// 当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
				{
					name : 'id',
					index : 'id',
					width : 30,
					sorttype : "int",
					key : true,
					editable : false,
					editoptions : {
						size : "20",
						maxlength : "30"
					}
				}, {
					name : 'goodsId',
					index : 'goodsId',
					width : 60,
					hidden : true
				}, {
					name : 'goodsName',
					index : 'goodsName',
					sortable: true,
					editable : true,
					edittype : "text",
					width : 90
				}, {
					name : 'goodsPrice',
					index : 'goodsPrice',
					sortable: true,
					editable : true,
					edittype : "text",
					width : 70
				}, {
					name : 'discount',
					index : 'discount',
					sortable: true,
					editable : true,
					edittype : "text",
					width : 50
				}, {
					name : 'goodsType',
					index : 'goodsType',
					sortable: true,
					editable : true,
					edittype : "text",
					width : 90
				}, {
					name : 'sales',
					index : 'sales',
					editable : false,
					width : 60
				}, {
					name : 'stock',
					index : 'stock',
					editable : true,
					sortable: true,
					edittype : "text",
					width : 60
				}, {
					name : 'goodsStatus',
					index : 'goodsStatus',
					editable : true,
					edittype : "text",
					width : 60
				},
				{
					name : 'updateTime',
					index : 'updateTime',
					editable : true,
					editoptions : { // 这部分使用日期控件
						dataInit : function(e) {
							$(e).datetimepicker({
								language : "zh-CN",// 语言
								format : "yyyy-mm-dd hh:ii:ss",
								autoclose : true,
								todayBtn : true,
								pickerPosition : "bottom-left"
							});
							$(this).click(function(e) {// 选中时间后隐藏
								$(e).parent().datepicker('hide');
							});
						}
					},
					sortable : false,
					width : 100
				}, 
				{
					name : 'edit',
					index : 'edit',
					width : 100,
					height : 300,
					align : "right"
				}, ]*/colModels,
				rowList : [ 10, 20, 30],
				jsonReader:{
					root: "data",  
					page: "currentPage", 
					total: "totalPage",
					records:"totalCount", 
					repeatitems : true      
				},
				pager : $("#grid-pager"),
				viewrecords : true,
				multiselect : true,
				multiboxonly : true,
				altRows : true,
				rownumbers : true,// 如果为ture则会在表格左边新增一列，显示行顺序号
				sortable:true,
			    sortorder:'asc',
				//caption : '订单列表',
				ondblClickRow : function(){
					$('#edit').click();
				},
			}
			
			common.buildGrid($(pageId+"#managerDataGrid"), buildGridObj,
					$(pageId+"#grid-pager"));
			//$("#sellerManagerDataGrid").jqGrid(buildGridObj);
		}
	 
	 var exports={
		'loadDataGrid':loadDataGrid,
	 }
	 return exports;
}();