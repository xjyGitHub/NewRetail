<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8" />
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<title>轻松点商家登录</title>
		<link rel="stylesheet" href="assets/css/base.css" />
		<link rel="stylesheet" href="assets/css/layout.css" />
		<script type="text/javascript" src="/js/oss/promise-6.1.0.js"></script>
		<script type="text/javascript" src="/js/oss/aliyun-oss-sdk.min.js"></script>
		<script type="text/javascript" src="/js/user/register-app.js"></script>
		<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/js/user/imgdisplay.js"></script>
		<script type="text/javascript" src="/js/user/distpicker.data.min.js"></script>
		<script type="text/javascript" src="/js/user/distpicker.min.js"></script>
	</head>

	<body>
		<div id="wrapper">
			<header id="header">
				<div id="loginBar">
					<div class="w960 tr">
						<a href="#">登录</a> <span class="sp">|</span>
						<a href="#">注册</a>
					</div>
				</div>
				<div id="headBox">
					<div class="w960 oh">
						<!--<a href="#" class="fl mt10"><img src="assets/css/images/logo.png"
						alt="logo" /></a>-->
						<nav id="navs" class="fr">
							<a href="#">首页</a>
							<a href="/login">登录</a>
						</nav>
					</div>
				</div>
			</header>
			<!-- // header end -->
			<div class="container w960 mt20">
				<div id="processor">
					<ol class="processorBox oh">
						<li class="current">
							<div class="step_inner fl">
								<span class="icon_step">1</span>
								<h4>填写基本信息</h4>
							</div>
						</li>
						<li>
							<div class="step_inner fr">
								<span class="icon_step">2</span>
								<h4>填写商户信息</h4>
							</div>
						</li>
					</ol>
					<div class="step_line"></div>
				</div>
				<div class="content">
					<div id="step1" class="step hide">
						<form action="" method="post" id="step1_frm">
							<div class="frm_control_group">
								<label class="frm_label">姓名</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input username" maxlength="8" />
									<p class="frm_tips">请填写你的真实姓名</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">性别</label>
								<div class="frm_controls">
									<label><input name="sex" type="radio" value="1" checked />男 </label>
									<label><input name="sex" type="radio" value="0" />女 </label>
									<p class="frm_tips">请选择你的性别</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">密码</label>
								<div class="frm_controls">
									<input type="password" name="" class="frm_input passwd" />
									<p class="frm_tips">字母、数字或者英文符号，最短6位，区分大小写</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">再次输入密码</label>
								<div class="frm_controls">
									<input type="password" name="" class="frm_input passwd2" />
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">电子邮箱</label>
								<div class="frm_controls">
									<input type="text" name="" id="email" class="frm_input email" />
									<p class="frm_tips">电子邮箱用于您找回密码等验证"</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">手机号</label>
								<div class="frm_controls">
									<input type="text" name="" id="phone" class="frm_input phone" />
									<p class="frm_tips">请填写常用手机号</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">手机验证码</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input phoneYzm" />
									<input type="button" id="btnSendCode" value="获取验证码" onclick="clickButton(this)" class="btn btn_default" />
								</div>
							</div>
							<div class="toolBar">
								<a id="nextBtn" class="btn btn_primary" href="javascript:;">下一步</a>
							</div>
						</form>
					</div>
					<!-- // step1 end -->
					<div id="step3" class="step hide">
						<form action="" method="post" id="step2_frm">
							<div class="frm_control_group">
								<label class="frm_label">店铺名</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input shopName" maxlength="32" />
									<p class="frm_tips">请输入您的店铺名称</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">店铺封面</label>
								<div>
									<!--input-group start-->
									<div class="input-group row">
										<div class="col-sm-9 big-photo">
											<div id="preview1">
												<img id="imghead1" border="0" src="assets/css/images/photo_icon.png" width="90" height="90" onclick="$('#preview1Img').click();">
											</div>
											<input type="file" onchange="preview1Image(this)" style="display: none;" id="preview1Img">
										</div>
									</div>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">经营类型</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input manager_class" />
									<p class="frm_tips">请输入经营类型（零售,电商）</p>
								</div>
							</div>
														<div class="frm_control_group">
								<label class="frm_label">商户地址</label>
								<div class="form-inline">
									     <div id="distpicker">
									        <div class="form-group">
									          <label class="sr-only" for="province"></label>
									          <select class="form-control" id="province" data-province="广东省"></select>
									        </div>
									        <div class="form-group">
									          <label class="sr-only" for="city" ></label>
									          <select class="form-control" id="city" data-city="深圳市"></select>
									        </div>
									        <div class="form-group">
									          <label class="sr-only" for="district" ></label>
									          <select class="form-control" id="district" data-district="南山区"></select>
									        </div>
									    </div>
								</div>
							</div>
							<div class="frm_control_group">
									<label class="frm_label">详细地址</label>
									<div class="frm_controls">
										<input type="text" name="" class="frm_input detail_address" />
										<p class="frm_tips">请输入您所在的详细地址eg:XX区XX号</p>
									</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">管理员姓名</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input managerName" />
									<p class="frm_tips">请输入店铺管理姓名</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">身份证号码</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input idCard" maxlength="32" />
									<p class="frm_tips">请输入您的身份证号码</p>
								</div>
							</div>
							<div class="frm_control_group">

								<label class="frm_label">身份证正面照</label>
								<div>
									<!--input-group start-->
									<div class="input-group row">
										<div class="col-sm-9 big-photo">
											<div id="preview2">
												<img id="imghead2" border="0" src="assets/css/images/photo_icon.png" width="90" height="90" onclick="$('#preview2Img').click();">
											</div>
											<input type="file" onchange="preview2Image(this)" style="display: none;" id="preview2Img">
										</div>
									</div>
								</div>

							</div>
							<div class="frm_control_group">
								<label class="frm_label">身份证反面照</label>
								<div>
									<!--input-group start-->
									<div class="input-group row">
										<div class="col-sm-9 big-photo">
											<div id="preview3">
												<img id="imghead3" border="0" src="assets/css/images/photo_icon.png" width="90" height="90" onclick="$('#preview3Img').click();">
											</div>
											<input type="file" onchange="preview3Image(this)" style="display: none;" id="preview3Img">
										</div>
									</div>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">手持身份证照</label>
								<div>
									<div class="input-group row">
										<div class="col-sm-9 big-photo">
											<div id="preview4">
												<img id="imghead4" border="0" src="assets/css/images/photo_icon.png" width="90" height="90" onclick="$('#preview4Img').click();">
											</div>
											<input type="file" onchange="preview4Image(this)" style="display: none;" id="preview4Img">
										</div>
									</div>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">营业执照</label>
								<div class="frm_controls">
									<input type="text" name="" class="frm_input license" maxlength="32" />
									<p class="frm_tips">请输入您的营业执照编码</p>
								</div>
							</div>
							<div class="frm_control_group">
								<label class="frm_label">营业执照正面</label>
								<div id="addCommodityIndex">
									<!--input-group start-->
									<div class="input-group row">
										<div class="col-sm-9 big-photo">
											<div id="preview5">
												<img id="imghead5" border="0" src="assets/css/images/photo_icon.png" width="90" height="90" onclick="$('#preview5Img').click();">
											</div>
											<input type="file" onchange="preview5Image(this)" style="display: none;" id="preview5Img">
										</div>
									</div>
								</div>
							</div>
							<div class="toolBar">
								<a id="finishedBtn" class="btn btn_primary" href="javascript:;">提交审核</a>
							</div>
						</form>
					</div>
					<!-- // step3 end -->
				</div>
			</div>
			<!-- // container end -->
			<footer id="footer" class="w960 oh">
				<span class="fl">© 2017 轻松点 All Right Reserved.</span>
				<nav class="footNavs tr fr">
					<a href="#">联系（深圳）轻松点未来科技责任有限公司</a> <span class="sp">|</span>
					<a href="#">投诉建议</a>
				</nav>
			</footer>
			<!-- // footer end -->
		</div>
		<!-- // wrapper end -->
		<script>
			//初始化地址选择器
			  $('#distpicker').distpicker({
			    province: '广东省',
			    city: '深圳市',
			    district: '南山区'
			  });
			var province =  $("#province").val();
			var city = $("#city").val();
			var district = $("#district").val();
            var detail_address = $(".detail_address").val();
			var username = $('.username').val();
			var passwd = $('.passwd').val();
			var phone = $('.phone').val();
			var email = $('.email').val();
			var passwd2 = $('.passwd2').val();
			var phoneYzm = $('.phoneYzm').val();
			var sex = $('input:radio:checked').val();
			var EmailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
			var phoneReg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
			//验证文件是否已选
			var storeImage = document.getElementById('preview1Img').files[0];
			var idCardImage1 = document.getElementById('preview2Img').files[0];
			var idCardImage2 = document.getElementById('preview3Img').files[0];
			var idCardImage3 = document.getElementById('preview4Img').files[0];
			var licenseImage = document.getElementById('preview5Img').files[0];

			//商家信息
			var shopName = $(".shopName").val();
			var manager_class = $(".manager_class").val();
			var managerName = $(".managerName").val();
			var idCard = $(".idCard").val();
			var license = $(".license").val();
			//获取手机验证码
			function clickButton(obj) {
				var phone = $("#phone").val();
				if(phone == '') {
					showTips('请输入手机号码');
					return;
				} else if(!(/^1[34578]\d{9}$/.test(phone))) {
					showTips('请输入正确的手机号码');
					return;
				}
				var obj = $(obj);
				obj.attr("disabled", "disabled"); /*按钮倒计时*/
				var time = 60;
				var set = setInterval(function() {
					obj.val(--time + "(s)");
				}, 1000); /*等待时间*/
				setTimeout(function() {
					obj.attr("disabled", false).val("重新获取验证码"); /*倒计时*/
					clearInterval(set);
				}, 60000);
				//ajax形式获取验证码
				$.ajax({
					type: "post", //用GET方式传输
					dataType: "json", //数据格式:JSON */
					contentType: "application/json; charset=utf-8",
					url: '/sms/sendSms', //目标地址
					data: JSON.stringify({
						"phoneNumber": $('#phone').val()
					}),
					success: function(data) {
						//console.log(data);
						if(data.code == 200) {
							curCount = 60;
							//设置button效果，开始计时
							$("#btnSendCode").attr("disabled", "true");
							$("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
							InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
						} else {
							showTips(data.msg);
						}
					}
				});

			}

			$(function() {
				//AJAX提交以及验证表单,提交基本信息
				$('#nextBtn')
					.click(
						function() {
							//验证表单数据
							username = $('.username').val();
							passwd = $('.passwd').val();
							phone = $('.phone').val();
							passwd2 = $('.passwd2').val();
							phoneYzm = $('.phoneYzm').val();
							sex = $('input:radio:checked').val();
							email = $('.email').val();
							EmailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
							phoneReg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
							if(username == '') {
								showTips('请填写您的姓名');
							} else if(passwd == '') {
								showTips('请填写您的密码');
							} else if(passwd2 == '') {
								showTips('请再次输入您的密码');
							} else if(passwd != passwd2 ||
								passwd2 != passwd) {
								showTips('两次密码输入不一致呢');
							} else if(phoneYzm == '') {
								showTips('请输入验证码');
							} else if(email==''){
								showTips('邮箱不能为空');
							} else if(!EmailReg.test(email)){
								showTips('请输入正确的电子邮箱');
							}else if(phone == '') {
								showTips('请输入手机号码');
							} else if(!(/^1[34578]\d{9}$/.test(phone))) {
								showTips('请输入正确的手机号码');
							} else {
								//校验是否通过验证
								$.ajax({
									type: "post", //用GET方式传输
									dataType: "json", //数据格式:JSON */
									contentType: "application/json; charset=utf-8",
									url: '/sms/vildate', //目标地址
									data: JSON.stringify({
										"phone": $('#phone').val(),
										"code": phoneYzm
									}),
									success: function(data) {
										//console.log(data);
										if(data.status == 200) {
											$('.processorBox li')
												.removeClass('current').eq(1)
												.addClass('current');
											$('.step').fadeOut(300).eq(1).fadeIn(500);
										} else {
											showTips(data.msg);
										}
									},
									error: function(data) {
										showTips("请求失败,检查网络或者稍后再试");
									}
								});

							}

						});
				$("#finishedBtn").click(function() {
					//验证表单数据
					username = $('.username').val();
					passwd = $('.passwd').val();
					phone = $('.phone').val();
					passwd2 = $('.passwd2').val();
					phoneYzm = $('.phoneYzm').val();
					sex = $('input:radio:checked').val();
					email = $('.email').val();
					EmailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
					phoneReg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
					//验证文件是否已选
					storeImage = document.getElementById('preview1Img').files[0];
					idCardImage1 = document.getElementById('preview2Img').files[0];
					idCardImage2 = document.getElementById('preview3Img').files[0];
					idCardImage3 = document.getElementById('preview4Img').files[0];
					licenseImage = document.getElementById('preview5Img').files[0];

					//商家信息
					shopName = $(".shopName").val();
					manager_class = $(".manager_class").val();
					managerName = $(".managerName").val();
					idCard = $(".idCard").val();
					license = $(".license").val();
					//商家地址
                    province =  $("#province").val();
                    city 	= $("#city").val();
                    district = $("#district").val();
                    detail_address = $(".detail_address").val();
					//进行非空判断
					if(province==""){
                        showTips('请选择省份');
					}else if(city==""){
                        showTips('请选择城市');
					}else if(district==''){
					    showTips('请选择区县');
					}else if(detail_address==""){
                        showTips('请填写详细地址');
					}else if(shopName == '') {
						showTips('请填写商户名');
					} else if(manager_class == '') {
						showTips('请填写经营类型');
					} else if(managerName == '') {
						showTips('请填写管理员姓名');
					} else if(idCard == '') {
						showTips('请填写省份证');
					} else if(license == '') {
						showTips('请填写营业执照编号');
					} else if(username == '') {
						showTips('请填写您的姓名');
					} else if(passwd == '') {
						showTips('请填写您的密码');
					} else if(passwd2 == '') {
						showTips('请再次输入您的密码');
					} else if(passwd != passwd2 ||
						passwd2 != passwd) {
						showTips('两次密码输入不一致呢');
					} else if(phoneYzm == '') {
						showTips('请输入验证码');
					}else if(email==''){
						showTips('邮箱不能为空');
					} else if(!EmailReg.test(email)){
						showTips('请输入正确的电子邮箱');
					}else if(phone == '') {
						showTips('请输入手机号码');
					} else if(!(/^1[34578]\d{9}$/.test(phone))) {
						showTips('请输入正确的手机号码');
					} else if(storeImage == null || storeImage == '') {
						showTips('请选择店铺封面');
						return;
					} else if(idCardImage1 == null || idCardImage1 == '') {
						showTips('请选择省份证正面照');
						return;
					} else if(idCardImage2 == null || idCardImage2 == '') {
						showTips('请选择省份证反面照');
						return;
					} else if(idCardImage3 == null || idCardImage3 == '') {
						showTips('还没选择手持照片');
						return;
					} else if(licenseImage == null || licenseImage == '') {
						showTips('请上传手持照片');
						return;
					}else {
						//上传文件
						applyTokenDo(uploadFile);
					}

				});

				//切换步骤（目前只用来演示）
				$('.processorBox li').click(
					function() {
						var i = $(this).index();
						$('.processorBox li').removeClass('current').eq(i)
							.addClass('current');
						$('.step').fadeOut(300).eq(i).fadeIn(500);
					});
			});
		</script>
	</body>
</html>