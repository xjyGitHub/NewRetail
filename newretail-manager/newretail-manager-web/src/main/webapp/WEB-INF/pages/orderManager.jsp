<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<!--页面路径-->
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="icon-home home-icon"></i>
				<a href="#">首页</a>
			</li>
			<li class="active">管理员管理</li>
		</ul><!-- .breadcrumb -->

		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon">
					<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
					<i class="icon-search nav-search-icon"></i>
				</span>
			</form>
		</div>
	</div>
<!--页面路径-->
<!--主页面内容-->
<div class="page-content">
	<!-- 	<div class="page-header" style="border: 0px;">
							<div style="border-bottom: 1px dotted #e2e2e2;padding: 4px 0;">
								<button class="btn btn-xs btn-info" id="queryBtn">查询</button>
							</div>
							新增区
							<div class="addForm" id="addForm">
								<ul id="myTab" class="nav nav-tabs">
									<li class="active">
										<a href="/#home" data-toggle="tab">
											基本信息
										</a>
									</li>
									<li><a href="/#other" data-toggle="tab">其它信息</a></li>
								</ul>
								<div id="myTabContent" class="tab-content">
									<div class="tab-pane fade in active" id="home">
										<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
											<div class="form-group">
												<label class="col-lg-2 col-md-3 col-sm-3 control-label no-padding-right" for="form-field-1"> 姓名</label>
												<div class="col-lg-10 col-md-9 col-sm-9">
													<input type="text" id="form-field-1" placeholder="Username" class="form-control">
												</div>
											</div>
										</div>

										<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
											<div class="form-group">
												<label class="col-lg-2 col-md-3 col-sm-3 control-label no-padding-right" for="form-field-1"> 姓名</label>
												<div class="col-lg-10 col-md-9 col-sm-9">
													<input type="text" id="form-field-1" placeholder="Username" class="form-control">
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="other">
										
									</div>
								</div>
							</div> -->
	<!---->
	<div class="searchForm" style="padding: 4px 0;" id="searchForm">

		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
			<div class="form-group">
				<label
					class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right"
					for="form-field-1"> 订单号</label>
				<div class="col-lg-8 col-md-8 col-sm-8">
					<span class="block input-icon input-icon-right"> <input
						type="text" id="orderCode" class="form-control">
					</span>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
			<div class="form-group">
				<label
					class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right"
					for="form-field-1"> 下单时间</label>
				<div class="col-lg-9 col-md-8 col-sm-8">
					<input class="form-control date-picker" id="orderTime" type="text"
						data-date-format="yyyy-mm-dd">
				</div>
			</div>
		</div>

		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label
					class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right"
					for="form-field-1"> 订单状态</label>
				<div class="col-lg-8 col-md-8 col-sm-8">
					<select class="form-control" id="orderStatus" name="orderStatus">
						<option value="">&nbsp;</option>
						<option value="0">0-已下单</option>
						<option value="1">1-已确认</option>
						<option value="2">2-交易中</option>
						<option value="3">3-订单取消中</option>
						<option value="4">4-交易结束</option>
						<option value="5">5-订单取消</option>
					</select>
				</div>
			</div>
		</div>

		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label
					class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right"
					for="form-field-1"> 物流状态</label>
				<div class="col-lg-8 col-md-8 col-sm-8">
					<select class="form-control" id="deliverStatus"
						name="deliverStatus">
						<option value="">&nbsp;</option>
						<option value="1">1-待发货</option>
						<option value="2">2-已发货</option>
						<option value="3">3-已签收</option>
					</select>
				</div>
			</div>
		</div>

		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label
					class="col-lg-4 col-md-4 col-sm-4 control-label no-padding-right"
					for="form-field-1"> 配送方式</label>
				<div class="col-lg-8 col-md-8 col-sm-8">
					<select class="form-control" id="deliverType" name="deliverType">
						<option value="">&nbsp;</option>
						<option value="0">0-商家配送</option>
						<option value="1">1-第三方配送</option>
					</select>
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


<!--选择弹窗-->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">选择弹窗</h4>
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
				<h4 class="modal-title" id="myModalLabel">查看详情</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0">
					订单号：<span id="modal_orderCode"></span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0"></div>
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0">
					订单时间：<span id="modal_orderTime"></span>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0">
					支付状态：<span id="modal_payStatus"></span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0">
					配送状态：<span id="modal_deliverStatus"></span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0">
					订单状态：<span id="modal_orderStatus"></span>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-4  align-left"
					style="padding: 5px 0">
					收款人：<span id="modal_receiverName"></span>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 align-left"
					style="padding: 5px 0"></div>
				<div class="col-lg-4 col-md-4 col-sm-4  align-left"
					style="padding: 5px 0">
					联系方式：<span id="modal_receiverPhone"></span>
				</div>

				<div class="col-lg-12 col-md-12 col-sm-12 align-left"
					style="padding: 5px 0">
					收货地址：<span id="modal_deliverAddress"></span>
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

						<tbody id="modal_goodsList">

						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="confimBtn" class="btn btn-primary hidden">确认</button>
				<button type="button" id="reconfimBtn"
					class="btn btn-primary hidden">再次确认</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消
				</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
<!-- 更改窗口 -->
<div class="modal fade" id="updateStatusModal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">配送方式的选择</h4>
			</div>
			<div class="modal-body clearfix">
				<div class="">
					请选择配送方式： <select class="select-sm" id="selectMethod">
						<option value="0">0-商家配送</option>
						<option value="1">第三方配送</option>
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="confimBtn2" class="btn btn-primary">确认</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

	<input type="hidden" id="flagVaule" value="${userIdentify }">
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/allHandler.js"></script>
	<script type="text/javascript" src="/js/order/order.js"></script>