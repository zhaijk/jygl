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
	<style type="text/css">
	body
	{
		background-image:url('images/background.jpg');
		background-repeat:no-repeat;
		background-attachment:fixed;
		background-size:cover;	
		//background-position:50%;	
	}	
	</style>
  </head>  
  <body>
   	<div class="modal-content" style="width:25%;height:32%;position:absolution;left:60%;top:45%">
		<div class="modal-body">
			<hr>			
			<form action="log_in" class="form-horizontal"	role="form" method="post">
				<div class="form-group">					
					<label for="username" class="col-md-4 control-label">用户名:</label>
					<div class="col-md-8">
						<input type="text" class="form-control username"  id="operatorcode" name="j_username" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">	
					<label for="password" class="col-md-4 control-label">密&nbsp;&nbsp;码:</label>
					<div class="col-md-8">
						<input type="password" class="form-control password" id="operatorpassword" name=j_password placeholder="请输入密  码">						  
					</div>
				</div>
				<div class="form-group ">
				<button type="submit" class="btn btn-primary btn-block btn-lg" data-loading-text="信息提交中....." onclick="check()">
      			系统登录
   				</button>   			
   				</div>	
			</form>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script type="text/javascript">
   		$(document).ready(function(){
   			$('#operatorcode').val('');
			$('#operatorpassword').val('');
			$('#operatorcode').focus();			
   		});	
   		function check(){
   			var user=$('#operatorcode').val();   			
   			var password=$('#operatorpassword').val();   	
   			if(user==''){   				
   				//$('.username').popover('show');
   				alert('请输入用户名');
   				//exit;
   			}
   			if(password==''){
   				//$('.password').popover('show');
   				alert('请输入密码');
   				//exit;
   			}
   		}
   		//$(function () { $('.popover-show').popover('show');});
		//$(function () { $('.popover-hide').popover('hide');});
   		/*function show()
		{
			//$('#loginForm').modal('hide');
			$('#operatorcode').val('');
			$('#operatorpassword').val('');	
		}*/
	</script>
   	<script src="js/bootstrap/dist/js/bootstrap.min.js"></script>    
</body>
</html>
