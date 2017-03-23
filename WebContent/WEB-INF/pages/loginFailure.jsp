<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系 统 登 录</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="shortcut icon" href="gasstation.ico" type="image/x-icon"/>
   	<script type="text/javascript">
	function show()
	{
		//$('#loginForm').modal('show');
		$('#username').val('');
		$('#password').val('');
		alert("错误的用户名或者密码");
	}
	function load()
	{
		var ajax;
		ajax=new XMLHttpRequest();
		ajax.onreadystatechange=function(){
			if((ajax.readyState==4)&&(ajax.status==200))
				document.getElementById("info").innerHTML=ajax.responseText;
		};
	
		ajax.open("GET","getinfo",true);
		ajax.send();
	}
	</script>
	<style type="text/css">
	body
	{
		background-image:url('images/background.jpg');
		background-repeat:no-repeat;
		background-attachment:fixed;
		background-size:cover;	
		//background-position:50%;	
	}
	#loginForm
	{
		
	}
	</style>
  </head>  
  <body onload="show()">
   	<div class="modal-content" style="width:30%;height:30%;position:absolute;left:55%;top:50%">
		<div class="modal-body">
			<hr>
			<form action="log_in" class="form-horizontal"	role="form" method="post">
				<div class="form-group">
					<label for="username" class="col-sm-4 control-label">用户名:</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="operatorcode" name="j_username" placeholder="请输入用户名">
					</div>
					<label for="password" class="col-sm-4 control-label">密码:</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="operatorpassword" name=j_password placeholder="请输入密  码">
					</div>
				</div>				
					<div class="col-sm-offset-3 ">						
						<button type="submit" class="btn btn-default" style="width:100px">登录</button>
						<button type="reset" class="btn btn-default" style="width:100px">退出</button>						
					</div>				
			</form>
		</div>
	</div>
	<script src="js/jquery.js"></script>
   	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>    
</body>
</html>
