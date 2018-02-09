<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8"/>
    <title>新零售后台管理</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<%--js 一定要放在最开始位置--%>
    <script src="/js/jquery-1.7.2.min.js"></script>
    <!-- basic styles -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- ace styles -->
    <link rel="stylesheet" href="/assets/css/ace.min.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <!-- ace settings handler -->

    <script src="/assets/js/ace-extra.min.js"></script>

    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
    <!-- basic styles -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/assets/css/ui.jqgrid.css"/>
    <link rel="stylesheet" href="/assets/css/datepicker.css"/>
    <link rel="stylesheet"
          href="/assets/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace.min.css"/>

    <!-- 对话框插件 -->
    <link rel="stylesheet"
          href="/assets/css/jquery-confirm.min.css">
</head>

<body>
<!--顶部NAV-->
<div class="navbar navbar-default" id="navbar">
    <div class="navbar-container" id="navbar-container">
        <!--左侧logo-->
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small><i
                        class="icon-leaf"></i> Ace Admin
                </small>
            </a>
        </div>
        <!--右侧-->
        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="purple"><a data-toggle="dropdown"
                                      class="dropdown-toggle" href="#"> <i
                        class="icon-bell-alt icon-animated-bell"></i> <span
                        class="badge badge-important">8</span>
                </a>

                    <ul
                            class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header"><i class="icon-warning-sign"></i>
                            0 消息
                        </li>

                        <li><a href="#">
                            <div class="clearfix">
										<span class="pull-left"> <i
                                                class="btn btn-xs no-hover btn-pink icon-comment"></i> 未读消息
										</span> <span class="pull-right badge badge-info">+12</span>
                            </div>
                        </a></li>
                    </ul>
                </li>

                <li class="light-blue"><a data-toggle="dropdown" href="#"
                                          class="dropdown-toggle"> <img class="nav-user-photo"
                                                                        src="/assets/avatars/user.jpg"
                                                                        alt="Jason's Photo"/> <span
                        class="user-info"> <small>欢迎你登陆</small> 管理员
						</span> <i class="icon-caret-down"></i>
                </a>

                    <ul
                            class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li><a href="#"> <i class="icon-cog"></i> 系统参数
                        </a></li>

                        <li><a href="#"> <i class="icon-user"></i> 个人中心
                        </a></li>
                        <li class="divider"></li>

                        <li><a href="#"> <i class="icon-off"></i> 退出
                        </a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.ace-nav -->
        </div>

    </div>
</div>
<!--顶部NAV END-->

<div class="main-container" id="main-container">

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#"> <span
                class="menu-text"></span>
        </a>
        <!--左侧导航-->
        <div class="sidebar" id="sidebar">
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
                    <span class="btn btn-success"></span> <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
                </div>
            </div>
            <!--主菜单-->
            <ul class="nav nav-list">
                <li class="active">
                    <a href="#" class="dropdown-toggle"> <i
                            class="icon-desktop"></i> <span class="menu-text">用户管理 </span> <b
                            class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li><a id="user"> <i class="icon-double-angle-right"></i>
                            普通用户
                        </a></li>

                        <li><a id="seller"> <i class="icon-double-angle-right"></i>
                            商家管理
                        </a></li>

                        <li><a id="delivery"> <i class="icon-double-angle-right"></i>
                            配送员管理
                        </a></li>

                        <li><a id="admin"> <i class="icon-double-angle-right"></i>
                            管理员管理
                        </a></li>
                    </ul>
                </li>


                <li class="active">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"> </i>
                        <span class="menu-text"> 配送管理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a id="deliveryInfo"> <i class="icon-text-width"></i>
                                <span class="menu-text"> 配送情況 </span>
                            </a>
                        </li>
                    </ul>

                </li>

                <li class="active">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"> </i>
                        <span class="menu-text"> 商品管理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a id="productAuthenticate"> <i class="icon-text-width"></i>
                                <span class="menu-text"> 商品审核 </span>
                            </a>
                        </li>
                    </ul>

                </li>
            </ul>
            <!--收缩键-->
            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left"
                   data-icon1="icon-double-angle-left"
                   data-icon2="icon-double-angle-right"></i>
            </div>
        </div>
        <!--左侧导航 end-->
        <!--主页面-->
        <div class="main-content" id="contentPage">

            <!--主页面内容 end-->
        </div>
    </div>
    <a href="#" id="btn-scroll-up"
       class="btn-scroll-up btn btn-sm btn-inverse"> <i
            class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>
<script src="/assets/js/jquery-confirm.min.js"></script>

<script type="text/javascript">
    if ("ontouchend" in document)
        document
            .write("<script src='/assets/js/jquery.mobile.custom.min.js'>"
                + "<" + "/script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<!-- 日期控件 这个是原本提供的，反正我没使用-->
<script src="/assets/js/date-time/bootstrap-datepicker.min.js"></script>

<!--日期控件，新增加，注意需要再顶部引入CSS:bootstrap-datetimepicker.min.css  -->
<script src="/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/index.js"></script>
</body>
</html>

