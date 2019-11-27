<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css">
<link rel="stylesheet" href="/airsys/assets/css/main.css">

</head>
<body>
	<form class="layui-form" action="/airsys/login/log" method="post">
		<div class="container">
			<h2>登录</h2>
			<!--<div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="06.png" height="35">
        </div>-->
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input type="text" name="name" required lay-verify="required"
						placeholder="请输入用户名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密 &nbsp;&nbsp;码</label>
				<div class="layui-input-inline">
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input">
				</div>
				<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			</div>
			
			<div class="layui-form-item"style="margin: auto">
			<div id="vcode" class="nc-container" style="margin: auto;width:300px"></div>
			<!-- 	<label class="layui-form-label">验证码</label>
				<div class="layui-input-inline">
					<input type="text" name="title" required lay-verify="required"
						placeholder="请输入验证码" autocomplete="off" class="layui-input verity">
					<img src="vcode" width="120" height="50" onclick="changeCode(this)">
				</div> -->
			</div>
			<!--<div class="layui-form-item">
                            <label class="layui-form-label">记住密码</label>
                            <div class="layui-input-block">
                              <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                            </div>
                      </div> -->
                      
			<div class="layui-form-item">
				<label class="layui-form-label">用户选择</label>
				<div class="layui-input-block">
					<input type="radio" name="role" value="1" title="管理员" checked="">
					<input type="radio" name="role" value="2" title="营业员"> <input
						type="radio" name="role" value="3" title="营业员管理员">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
				</div>
			</div>
			<a href="http://localhost:8080/airsys/main/pwd" class="font-set">忘记密码?</a>
			<a href="http://localhost:8080/airsys/main/resign" class="font-set">立即注册</a>
		</div>
	</form>
	<script type="text/javascript" src="/airsys/assets/layui/layui.js"></script>
	  <script type="text/javascript" charset="utf-8" src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>
	<script>
	function changeCode(that){
		that.src=that.src+"?"+Math.random();
		
	}
		layui
				.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							form.on('submit(demo1)', function(data) {
								layer.alert(JSON.stringify(data.field), {
									title : '最终的提交信息'
								})
								return false;
							});
						});
	</script>
	<script type="text/javascript">
    var nc_token = ["CF_APP_1", (new Date()).getTime(), Math.random()].join(':');
    var NC_Opt =
        {
            renderTo: "#vcode",
            appkey: "CF_APP_1",
            scene: "register",
            token: nc_token,
            customWidth: 300,
            trans:{"key1":"code0"},
            elementID: ["usernameID"],
            is_Opt: 0,
            language: "cn",
            isEnabled: true,
            timeout: 3000,
            times:5,
            apimap: {
                // 'analyze': '//a.com/nocaptcha/analyze.jsonp',
                // 'get_captcha': '//b.com/get_captcha/ver3',
                // 'get_captcha': '//pin3.aliyun.com/get_captcha/ver3'
                // 'get_img': '//c.com/get_img',
                // 'checkcode': '//d.com/captcha/checkcode.jsonp',
                //' umid_Url': '//e.com/security/umscript/3.2.1/um.js',
                // 'uab_Url': '//aeu.alicdn.com/js/uac/909.js',
                // 'umid_serUrl': 'https://g.com/service/um.json'
            },
            callback: function (data) {
                window.console && console.log(nc_token)
                window.console && console.log(data.csessionid)
                window.console && console.log(data.sig)
            }
        }
    
    var nc = new noCaptcha(NC_Opt);

    nc.upLang('cn', {
        _startTEXT: "请按住滑块，拖动到最右边",
        _yesTEXT: "验证通过",
        _error300: "哎呀，出错了，点击<a href=\"javascript:__nc.reset()\">刷新</a>再来一次",
        _errorNetwork: "网络不给力，请<a href=\"javascript:__nc.reset()\">点击刷新</a>",
    })
</script>
</body>
</html>
