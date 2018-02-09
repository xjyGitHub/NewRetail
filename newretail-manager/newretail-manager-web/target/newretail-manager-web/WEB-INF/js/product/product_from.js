'use strict';
var appServer = 'http://39.108.94.35:3000';
var bucket = 'newretail-app';
var region = 'oss-cn-shenzhen';
var urllib = OSS.urllib;
var Buffer = OSS.Buffer;
var OSS = OSS.Wrapper;
var STS = OSS.STS;
//用于图片上传
var applyTokenDo = function(func) {
	var url = appServer;
	return urllib.request(url, {
		method: 'GET'
	}).
	then(function(result) {
		var creds = JSON.parse(result.data);
		var client = new OSS({
			region: region,
			accessKeyId: creds.AccessKeyId,
			accessKeySecret: creds.AccessKeySecret,
			stsToken: creds.SecurityToken,
			bucket: bucket
		});
		var f = func(client);
		return f;
	});
};
//上传图片
var uploadFile = function(client) {
	//获取文件
	var goods_photo = document.getElementById('preview1Img').files[0];
	//获取文件路径
	var goods_photoName = filenameUtils(goods_photo.name);
	//店铺封面			
	client.multipartUpload(goods_photoName, goods_photo).then(function(res) {
		console.log("status:" + res.res.status);
		console.log("url:" + res.name);
		$.ajax({
			type: "post", //用GET方式传输
			dataType: "json", //数据格式:JSON */
			contentType: "application/json; charset=utf-8",
			url: 'goods/add', //目标地址
			data: JSON.stringify({
				"goods_name": goods_name,
				"goods_photo": goods_photoName,
				"goods_discount": goods_discount,
				"goods_type": goods_type,
				"stock":stock,
				"goods_price": goods_price
			}),
			error:function(){
				common.showTip('提交表单失败');
				setTimeout(function(){
					common.hideTip();
				},5);
			},
			success: function(data) {
				console.log(data);
				if(data.status == 200) { //提交表单成功
					common.showTip('保存成功');
					setTimeout(function(){
						common.hideTip();
					},5);
					window.location.href ='http://localhost:8080/login';
				} else {
					showTips(data.msg, 2500, 1);
					console.log(data.msg);
				}
			}
		});
	});
	return null;
};

function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "/";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if(month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if(strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	return currentdate;
};

function filenameUtils(filename) {
	var index1 = filename.lastIndexOf(".");
	var index2 = filename.length;
	var suffix = filename.substring(index1, index2)
	var random = parseInt((Math.random()*9+1)*9*100000);
	return "/shop/images/" + getNowFormatDate() + "/" + (new Date()).valueOf() +random+ suffix;
};
//显示提示框，目前三个参数(txt：要显示的文本；time：自动关闭的时间（不设置的话默认1500毫秒）；status：默认0为错误提示，1为正确提示；)
function showTips(txt, time, status) {
	var htmlCon = '';
	if(txt != '') {
		if(status != 0 && status != undefined) {
			htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#4AAF33;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;"><img src="assets/css/images/ok.png" style="vertical-align: middle;margin-right:5px;" alt="OK，"/>' +
				txt + '</div>';
		} else {
			htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#D84C31;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;"><img src="assets/css/images/err.png" style="vertical-align: middle;margin-right:5px;" alt="Error，"/>' +
				txt + '</div>';
		}
		$('body').prepend(htmlCon);
		if(time == '' || time == undefined) {
			time = 1500;
		}
		setTimeout(function() {
			$('.tipsBox').remove();
		}, time);
	}
};
