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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">初始化<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="initdeviceall();">全部初始化</a></li>
							<li><a href="#" onclick="initdevice(prompt('请输入枪号','1'));">单个初始化</a></li>
							<li><a href="#" onclick="">当前设备信息</a></li>							
						</ul>
					</li>
					<!-- 
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">下传参数<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="initdeviceall();">全部下传</a></li>
							<li><a href="#" onclick="initdevice(prompt('请输入枪号','1'));">单个下传</a></li>														
						</ul>
					</li>
					 -->		
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">同步数据<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="initparam(8);">同步加油数据</a></li>							
							<li><a href="#" onclick="initparam(7);">同步指标数据</a></li>
							<li><a href="#" onclick="initparam(6);">同步黑名单</a></li>
							<li><a href="#" onclick="initparam(1);">同步系统参数</a></li>
							<li><a href="#" onclick="initparam(3);">同步车辆类型</a></li>
							<li><a href="#" onclick="initparam(2);">同步油品定义</a></li>							
							<li><a href="#" onclick="initparam(4);">同步IC卡机定义</a></li>
							<li><a href="#" onclick="initparam(5);">同步油罐定义</a></li>														
							<li><a href="#" onclick="initparam(0);">同步所有数据</a></li>														
						</ul>
					</li>					
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">系统功能<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="close_device(prompt('请输入枪号','1'));">关闭设备控制线程</a></li>
							<li><a href="#" onclick="open_device(prompt('请输入枪号','1'));">打开设备控制线程</a></li>
							<li><a href="#" onclick="">当前线程信息</a></li>							
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">串口操作<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="reopenport();">重新初始化</a></li>							
							<li><a href="#" onclick="closeport();">关闭端口</a></li>
							<li><a href="#" onclick="openport();">打开端口</a></li>
							<li><a href="#" onclick="">当前串口状态</a></li>														
						</ul>
					</li>
				</ul> 
				<ul class="nav navbar-nav navbar-right user-nav">
					<li class="dropdown profile_menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="Avatar" src="images/avatar2.jpg" /><span>${username}</span> 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
							<!-- <li><a href="#">My Account</a></li>
							<li><a href="#">Profile</a></li>
							<li><a href="#">Messages</a></li>
							<li class="divider"></li>
							 -->
							<li><a href="j_spring_security_logout">Sign Out</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse animate-collapse -->
		</div>	
	<!-- Fixed navbar -->
</body>
</html>