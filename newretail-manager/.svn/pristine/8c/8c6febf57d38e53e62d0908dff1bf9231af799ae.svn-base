<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--页面路径-->
<div class="breadcrumbs" id="breadcrumbs">
	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon"> <input type="text"
				placeholder="Search ..." class="nav-search-input"
				id="nav-search-input" autocomplete="off" /> <i
				class="icon-search nav-search-icon"></i>
			</span>
		</form>
	</div>
</div>
<!--页面路径-->
<!--主页面内容-->
<div class="page-content">
	<div class="page-header" style="border: 0px;">
		<div style="border-bottom: 1px dotted #e2e2e2; padding: 4px 0;">
			<!--基础按钮-->
			<%--<button class="btn btn-xs btn-info" onclick="page.onTapAdd()">新增</button>--%>
			<button class="btn btn-xs btn-info btn-save"
				onclick="page.onTapSave()">保存</button>
			<button class="btn btn-xs btn-info" onclick="page.onTapBack()">返回</button>
			<button class="btn btn-xs btn-info" onclick="page.onTapEdit()">编辑</button>
			<%--	<button class="btn btn-xs btn-info" onclick="page.onTapDel()">删除</button>--%>
			<button class="btn btn-xs btn-info" onclick="page.query()">查询</button>
			<!--page btn-->
			<button class="btn btn-xs btn-info" onclick="page.toPutOn()">审核通过</button>
			<button class="btn btn-xs btn-info" onclick="page.toPutDown()">审核不通过</button>
		</div>
		<%--根据商品名称--%>
		<div class="searchForm" style="padding: 4px 0;" id="searchForm">
			<div class="col-lg-9 col-md-4 col-sm-4 col-xs-12 ">
				<div class="form-group">
					<label
						class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right">商户账户</label>
					<div class="col-lg-4 col-md-8 col-sm-8">
						<span class="block input-icon input-icon-right"> <input
							type="text" id="userAccount" name="ebcuNameCn"
							class="form-control">
						</span>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label
						class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right">
						审核状态</label>
					<div class="col-lg-4 col-md-8 col-sm-8">
						<select class="form-control" id="goods_status">
							<option name="cat" value="0" selected="selected">全部</option>
							<option name="cat" value="1">待审核</option>
							<option name="cat" value="2">已通过</option>
							<option name="cat" value="4">不通过</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-lg-12 col-md-4 col-sm-4 col-xs-12 ">
				<div class="form-group">
					<label class="col-lg-3 col-md-12 col-sm-12 control-label">地址搜索</label>
					<div id="distpicker">
						<div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
							<label class="sr-only" for="province"></label> <select
								class="form-control" id="province" data-province="广东省"></select>
						</div>
						<div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
							<label class="sr-only" for="city"></label> <select
								class="form-control" id="city" data-city="深圳市"></select>
						</div>
						<div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
							<label class="sr-only" for="district"></label> <select
								class="form-control" id="district" data-district="南山区"></select>
						</div>
					</div>
				</div>
			</div>
			<div class="searchForm" style="padding: 4px 0;">
				<div class="col-lg-9 col-md-4 col-sm-4 col-xs-12 ">
					<div class="form-group">
						<label
							class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right">具体地址</label>
						<div class="col-lg-4 col-md-8 col-sm-8">
							<span class="block input-icon input-icon-right"> <input
								type="text" id="detailAddress" name="ebcuNameCn"
								class="form-control">
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.page-header -->
	<div class="row" id="mainCon">
		<div class="col-xs-12">
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
		</div>
	</div>
</div>
<!--主页面内容 end-->


</div>
<!--回到顶部-->
<a href="/#" id="btn-scroll-up"
	class="btn-scroll-up btn btn-sm btn-inverse"> <i
	class="icon-double-angle-up icon-only bigger-110"></i>
</a>
<!--回到顶部 end-->
</div>
<!-- /.main-container -->

<!--选择弹窗-->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">选择弹窗</h4>
			</div>
			<div class="modal-body">
				<div class="modal-search">
					<select class="select-sm">
						<option value="AL">编码</option>
						<option value="AK">名称</option>
					</select> <input class="input-sm" type="text" placeholder="请输入">
					<button class="btn btn-xs btn-info">查询</button>
					<button class="btn btn-xs btn-info">重置</button>
				</div>
				<table id="pop-grid-table" style="width: auto;"></table>
				<div id="pop-grid-pager"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary"
					onclick="allHandler.onTapChoseRow()">确定</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<!-- 详情弹窗 -->
<div class="modal fade" id="myModalDetail" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">查看详情</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-lg-6 col-md-6 col-sm-6 align-left"
					style="padding: 5px 0">
					订单号：<span>e56465</span>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 align-right"
					style="padding: 5px 0">
					订单时间：<span>2017/09/08 12:00</span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 " style="padding: 5px 0">
					支付状态：<span>已支付</span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 " style="padding: 5px 0">
					配送状态：<span>待配送</span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 " style="padding: 5px 0">
					订单状态：<span>待配送</span>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 " style="padding: 5px 0">
					收款人：<span>小明</span>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6" style="padding: 5px 0">
					联系方式：<span>13640568956</span>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12" style="padding: 5px 0">
					收货地址：<span>dsfdfdsdddddddddd</span>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12" style="padding: 5px 0">
					<table class="table table-bordered table-striped">
						<thead class="thin-border-bottom">
							<tr>
								<th><i class="icon-caret-right blue"></i> 商品名称</th>

								<th><i class="icon-caret-right blue"></i> 价格</th>

								<th><i class="icon-caret-right blue"></i> 购买数量</th>

								<th><i class="icon-caret-right blue"></i> 总价</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>internet.com</td>
								<td><small> <s class="red">$29.99</s>
								</small> <b class="green">$19.99</b></td>
								<td>5</td>
								<td>100</td>
							</tr>

							<tr>
								<td>internet.com</td>
								<td><small> <s class="red">$29.99</s>
								</small> <b class="green">$19.99</b></td>
								<td>5</td>
								<td>100</td>
							</tr>
							<tr>
								<td colspan="4"><span>订单总金额：250</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消
				</button>
				<button type="button" class="btn btn-primary"
					onclick="page.toConfirm(this)">确认</button>
				<!-- <button type="button" class="btn btn-primary" onclick="page.toEdit()">
							编辑
						</button> -->
				<!-- <button type="button" class="btn btn-primary" onclick="page.save()">
							保存
						</button> -->
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
<!-- basic scripts -->
<script type="text/javascript">
		window.jQuery || document.write("<script src='js/jquery-3.2.1.min.js'>"+"<"+"/script>");
</script>
<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<!-- 阿里云oss 图片上传 -->
<script type="text/javascript" src="/js/oss/promise-6.1.0.js"></script>
<script type="text/javascript" src="/js/oss/aliyun-oss-sdk.min.js"></script>
<script type="text/javascript" src="/js/user/imgdisplay.js"></script>

<script type="text/javascript" src="/js/layer/layer.js"></script>
<!-- page specific plugin scripts -->
<script src="/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="/assets/js/jqGrid/i18n/grid.locale-en.js"></script> 


<!-- 日期控件 这个是原本提供的，反正我没使用-->
<script src="/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<!--日期控件，新增加，注意需要再顶部引入CSS:bootstrap-datetimepicker.min.css  -->

<script src="/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript" src="/js/user/distpicker.data.min.js"></script>
<script type="text/javascript" src="/js/user/distpicker.min.js"></script>
<!-- ace scripts -->
<script src="/assets/js/ace.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/allHandler.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>
<!-- 自定义js -->
<script type="text/javascript" src="js/product/product_from.js"></script>
<script type="text/javascript" src="js/product/product_authenticate.js"></script>
<script type="text/javascript">
	//初始化地址选择器
	$('#distpicker').distpicker({
		province : '广东省',
		city : '深圳市',
		district : '南山区'
	});
	var goods_name = $("#goods_name").val();
	var goods_photo = document.getElementById('preview1Img').files[0];
	var goods_discount = $("#discount").val();
	var goods_type = $("#goods_type").val();
	var stock = $("#stock").val();
	var goods_price = $("#goods_price").val();
	$(".btn-save").click(function() {
		saveFrom();
	});
	//用于添加商品提交表单
	function saveFrom() {
		goods_name = $("#goods_name").val();
		goods_photo = document.getElementById('preview1Img').files[0];
		goods_discount = $("#discount").val();
		goods_type = $("#goods_type").val();
		stock = $("#stock").val();
		goods_price = $("#goods_price").val();
		if (goods_name != '' && goods_photo != '' && goods_discount != ''
				&& goods_type != '' && stock != '' && goods_price != '') {
			//上传商品图片及提交表单，在product_from.js里面
			applyTokenDo(uploadFile);
			console.log("------提交表单中-----");
		} else {
			console.log("------数据为空-----");
		}
	}
</script>


