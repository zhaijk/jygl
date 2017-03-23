<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<!-- Fixed navbar -->
	
		<div class="container-fluid" style="background-color:green">
					
			<div class="navbar-collapse collapse">
			<div class="navbar-header">
      			<a class="navbar-brand">加油管理系统</a>
   			</div>
				<ul class="nav navbar-nav" >
					<li><a href="#" onclick="gettankinfo();">油罐信息查询</a></li>
					<li><a href="#">输入卡密码</a></li>
					<li><a href="#">强制退卡</a></li>
					<li><a href="#">加油机状态设置</a></li>
					<li><a href="#">监控主控切换</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">系统功能<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">消费记录查询</a></li>
							<li><a href="#">重新初始化</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">串口操作<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="">信息</a></li>
							<li><a href="#">串口关闭</a></li>
							<li><a href="#">线程信息</a></li>
							<li><a href="#">重启线程</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="dropdown profile_menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="Avatar" src="images/avatar2.jpg" /><span>${username}</span> 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
							<li><a href="#">My Account</a></li>
							<li><a href="#">Profile</a></li>
							<li><a href="#">Messages</a></li>
							<li class="divider"></li>
							<li><a href="j_spring_security_logout">Sign Out</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse animate-collapse -->
		</div>	
	<!-- Fixed navbar -->
</body>
</html>