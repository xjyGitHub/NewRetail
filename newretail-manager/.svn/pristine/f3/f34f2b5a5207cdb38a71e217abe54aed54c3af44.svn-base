<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>栏目</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="/assets/css/ui.jqgrid.css" />
	<link rel="stylesheet" href="/assets/css/datepicker.css" />
	<link rel="stylesheet" href="/assets/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" href="/assets/css/ace.min.css" />
		<style type="text/css">
			.form-control{height: 28px !important;}
			.addForm{position: relative;display: none;}
			.addForm .tab-content{position: absolute;width: 100%;left: 0;top: 40px;border: 0px;}
			 #myModal .modal-body{padding-bottom: 0;}
			 #myModal .modal-footer{padding:5px 20px;}
			.modal-search{margin-top:-10px;padding-bottom: 10px;}
			.modal-search button{display: inline-block;margin-top:-2px;}
		</style>
	</head>
	<body>
		<div class="navbar navbar-default" id="navbar">
	<div class="navbar-container" id="navbar-container">
		<!--左侧logo-->
		<div class="navbar-header pull-left">
			<a href="/#" class="navbar-brand">
				<small>
					<i class="icon-leaf"></i>
					Ace Admin
				</small>
			</a>
		</div>
		<!--右侧-->
		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="purple">
					<a data-toggle="dropdown" class="dropdown-toggle" href="/#">
						<i class="icon-bell-alt icon-animated-bell"></i>
						<span class="badge badge-important">8</span>
					</a>

					<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header">
							<i class="icon-warning-sign"></i>
							8 消息
						</li>

						<li>
							<a href="/#">
								<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												未读消息
											</span>
									<span class="pull-right badge badge-info">+12</span>
								</div>
							</a>
						</li>
					</ul>
				</li>

				<li class="light-blue">
					<a data-toggle="dropdown" href="/#" class="dropdown-toggle">
						<img class="nav-user-photo" src="/assets/avatars/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
									<small>Welcome</small>
									风清扬
								</span>

						<i class="icon-caret-down"></i>
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="/#">
								<i class="icon-cog"></i>
								系统参数
							</a>
						</li>
						<li>
							<a href="/#">
								<i class="icon-user"></i>
								个人中心
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="/#">
								<i class="icon-off"></i>
								登出
							</a>
						</li>
					</ul>
				</li>
			</ul><!-- /.ace-nav -->
		</div>

	</div>
</div><!--顶部NAV END-->
		<table width="100%" height="100%">
		 <tr>	
		<td width="300px" height="100%">
    <div class="main-container" id="main-container" style="width: 300px;height: 900px">
	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="/#">
			<span class="menu-text"></span>
		</a>
		<!--左侧导航-->
	<div class="sidebar" id="sidebar" style="width: 300px;height: 900px">
			<!--快捷功能区-->
			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>

					<span class="btn btn-info"></span>

					<span class="btn btn-warning"></span>

					<span class="btn btn-danger"></span>
				</div>
			</div>
		<ul class="nav nav-list">
			<li>
				<a href="/#" class="dropdown-toggle">
					<i class="icon-desktop"></i>
					<span class="menu-text">订单管理 </span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
					<li>
						<a href="javascript:void(0)" onclick="goUrl('/order')">
							<i class="icon-double-angle-right"></i>
							订单管理
						</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="/#" class="dropdown-toggle">
					<i class="icon-desktop"></i>
					<span class="menu-text">配送管理 </span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
					<li>
						<a href="javascript:void(0)" onclick="goUrl('/deliveryInfo')">
							<i class="icon-double-angle-right"></i>
							配送管理
						</a>
					</li>
				</ul>
			</li>
			<li>
				<a href="/#" class="dropdown-toggle">
					<i class="icon-desktop"></i>
					<span class="menu-text">商品管理 </span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
					<li>
						<a href="javascript:void(0)" onclick="goUrl('/product')">
							<i class="icon-double-angle-right"></i>
							商品管理
						</a>
					</li>

				</ul>
			</li>
		</ul>
		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
		</div>
		</div>
		</div>
		</div>
		</td>	 
		<td  width="80%" height="100%">
			<iframe width="100%" height="100%"  name="newretail_date" id="newretail_date"  src="/default" scrolling="auto" frameborder="0"></iframe>
		</td>
	     </tr>
		</table>

	</body>
<!-- basic scripts -->
<script type="text/javascript">
		window.jQuery || document.write("<script src='js/jquery-1.7.2.min.js'>"+"<"+"/script>");
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
<script src="/js/index.js"></script>
<script type="text/javascript">
    
	function goUrl(url){
		
		$("#newretail_date").attr('src',url);
	}
</script>
</html>

