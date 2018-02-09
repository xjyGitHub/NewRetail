<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%-- <%@page import="com.newretail.pojo.custom.DeliverInfoAddTable" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- 配送管理 -->
<div id="deliver_page">
<!--页面路径-->
					<div class="breadcrumbs" id="breadcrumbs">

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="${pageContext.request.contextPath}/#">首页</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/#">配送管理</a>
							</li>
							<li class="active">配送情况</li>
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
						<div class="page-header" style="border: 0px;">
							<div style="border-bottom: 1px dotted #e2e2e2;padding: 4px 0;">
								<button class="btn btn-xs btn-info" onclick="page.onTapAdd()">新增</button>
								<button class="btn btn-xs btn-info" onclick="page.onTapSave()">保存</button>
								<button class="btn btn-xs btn-info" onclick="page.onTapBack()">返回</button>
								<button class="btn btn-xs btn-info">编辑</button>
								<button class="btn btn-xs btn-info" id="query">查询</button>
								<button class="btn btn-xs">关闭</button>
							</div>
							<!--新增区-->
		
							<!---->
							<div class="searchForm" style="padding: 4px 0;" id="searchForm">
								<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
									<div class="form-group">
										<label class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right" for="form-field-1"> 状态</label>
										<div class="col-lg-9 col-md-8 col-sm-8">
											<select class="form-control" id="form-field-select-1">
											  <option value=""></option>
												<option value="1">待配送</option>
												<option value="2">配送中</option>
												<option value="3">已配送</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
									<div class="form-group">
										<label class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right" for="form-field-1"> 店铺</label>
										<div class="col-lg-9 col-md-8 col-sm-8">
											<span class="block input-icon input-icon-right">
												<input type="text" name="ebcuNameCn" class="form-control">
												<input type="text" name="pmCode" hidden="true">
												<i class="icon-search" data-toggle="modal" data-target="#myModal" data-url="data/data1.json" onclick="allHandler.onTapFindPop(this)"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
									<div class="form-group">
										<label class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right" for="form-field-1"> 配送员</label>
										<div class="col-lg-9 col-md-8 col-sm-8">
											<span class="block input-icon input-icon-right">
												<input type="text" name="ebcuNameCn" class="form-control">
												<input type="text" name="pmCode" hidden="true">
												<i class="icon-search" data-toggle="modal" data-target="#myModal" data-url="data/data1.json" onclick="allHandler.onTapFindPop(this)"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
									<div class="form-group">
										<label class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right" for="form-field-1"> 日期从</label>
										<div class="col-lg-9 col-md-8 col-sm-8">
											<input class="form-control date-picker" id="id-date-picker-1" type="text" data-date-format="yyyy-mm-dd">
										</div>
									</div>
								</div>

								<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 ">
									<div class="form-group">
										<label class="col-lg-3 col-md-4 col-sm-4 control-label no-padding-right" for="form-field-1"> 日期到</label>
										<div class="col-lg-9 col-md-8 col-sm-8">
											<input class="form-control date-picker" id="id-date-picker-2" type="text" data-date-format="yyyy-mm-dd">
										</div>
									</div>
								</div>
								
							</div>
						</div><!-- /.page-header -->
						<div class="row" id="mainCon">
							<div class="col-xs-12">
							<table id="grid-table"></table>
							<div id="grid-pager"></div>
								<table class="table table-bordered table-striped" >
									<thead class="thin-border-bottom">
										<tr class="text-c">
											<th>
											<i class="icon-caret-right blue"></i>
												订单号
											</th>
											<th>
											<i class="icon-caret-right blue"></i>
												下单时间
											</th>
											<th>
											<i class="icon-caret-right blue"></i>
												配送人
											</th>
											<th>配送状态</th>
											<th>开始时间</th>
											<th>结束时间</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list }" var="i">
											<tr>
												<td>${i.orderId }</td>
												<td>${i.orderTime }</td>
												<td>${i.senderName }</td>
												<td>
													<c:if test="${i.deliverStatus =='1' }">待配送</c:if>
													<c:if test="${i.deliverStatus =='2' }">配送中</c:if>
													<c:if test="${i.deliverStatus =='3' }">已配送</c:if>
												</td>
												<td>${i.startTime }</td>
												<td>${i.endTime }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div id="grid-pager"></div>

							</div>
						</div>
					</div>
					<!--回到顶部-->
					<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
						<i class="icon-double-angle-up icon-only bigger-110"></i>
					</a>
					<!--主页面内容 end-->
					<!--选择弹窗-->
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							选择弹窗
						</h4>
					</div>
					<div class="modal-body">
						<div class="modal-search">
							<select class="select-sm">
								<option value="AL">编码</option>
								<option value="AK">名称</option>
							</select>
							<input class="input-sm" type="text"  placeholder="请输入">
							<button class="btn btn-xs btn-info">查询</button>
							<button class="btn btn-xs btn-info">重置</button>
						</div>
						<table id="pop-grid-table" style="width: auto;"></table>
						<div id="pop-grid-pager"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消
						</button>
						<button type="button" class="btn btn-primary" onclick="allHandler.onTapChoseRow()">
							确定
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
</div>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/allHandler.js"></script>
<script type="text/javascript" src="/js/deliver/deliver2.js"></script>
