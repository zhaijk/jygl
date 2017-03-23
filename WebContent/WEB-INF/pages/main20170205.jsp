<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="public">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="images/favicon.png">
<title>加油管理系统</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" 	type="text/css"	href="js/bootstrap/dist/css/bootstrap.css"  />
<link rel="stylesheet"	type="text/css"	href="fonts/font-awesome-4/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" 	href="js/jquery.gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css"	href="js/jquery.nanoscroller/nanoscroller.css" />
<link rel="stylesheet" type="text/css"	href="js/jquery.easypiechart/jquery.easy-pie-chart.css" />

<link rel="stylesheet" type="text/css"	href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"	href="js/jquery.select2/select2.css" />
<link rel="stylesheet" type="text/css"	href="js/bootstrap.slider/css/slider.css" />


<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" 	href="css/style.css"  />

<link rel="shortcut icon" href="gasstation.ico" type="image/x-icon" />
<!-- 
	<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/jquery.min.js"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <script src="bootstrap/js-numeral.min.js"></script>
     -->

<!-- <style type="text/css">
h1 { //
	//text-align: center; //
	//text-shadow: 2px 2px gray; //
	//font-size: 300%
}

body { //
	//background-image: url('bootstrap/jyback.jpg');
}
</style> -->
<!-- <script type="text/javascript" src="highcharts/jquery-1.8.3.min.js"></script> 
  	<script type="text/javascript" src="highcharts/highcharts.js"></script>
  	<script type="text/javascript" src="highcharts/exporting.js"></script>
-->

</head>
<body>
	<jsp:include page="topnav.jsp" flush="true" />
	<div class="sb-collapsed" id="cl-wrapper">
		<jsp:include page="sidebar.jsp" flush="true" />
		<div id="page_content">
				<div class="container-fluid" id="pcont">
	<div class="stats_bar">
		<div class="butpro butstyle" data-step="2"
					data-intro="<strong>Beautiful Elements</strong> <br/> 
				If you are looking for a different UI, this is for you!.">
					<div class="sub">
						<h2>加油次数</h2>
						<span id="total_clientes">183次</span>
					</div>
					<div class="stat">
						<span class="gt">13,5%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>93# 汽油</h2>
						<span>1123.6 L</span>
					</div>
					<div class="stat">
						<span class="up">13,5%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>0# 汽油</h2>
						<span>1225.8 L</span>
					</div>
					<div class="stat">
						<span class="down"> 20,7%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>存油量</h2>
						<span>28765 L</span>
					</div>
					<div class="stat">
						<span class="equal"></span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>存油比</h2>
						<span>35%</span>
					</div>
					<div class="stat">
						<span class="spk1"></span>
						<img alt="" src="images/comm4.jpg" style="height:25%;width:100%;">
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>communication</h2>
						<span>184</span>
						<img alt="" src="images/comm.jpg" style="height:25%;width:100%;">
					</div>
					<div class="stat">
						<span class="spk3"></span>
					</div>
				</div>
			</div>


			<c:forEach items="${cheersInfo}" var="value" varStatus="counter">
				<div class="col-sm-6 col-md-4 col-lg-3" >
					<div class="panel-group accordion" id="accordion2${value.gunID}"> 
						<div class="panel panel-default" >
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion2${value.gunID}" href="#collapse${value.gunID}">
										<table>
											<tr style="background-color:black">
												<td align="left" style="font-weight:bold;font-size:25px;color:white"><i class="fa fa-angle-right"></i>${value.gunID}号枪</td>
												<td align="right" style="font-weight:bold;font-size:20px;color:yellow">${value.oilType}</td>
											</tr>
											<tr >
												<td id="jyl${counter.count}" colspan="2" align="center"
													style="background-color: black; font-family: Pixel LCD7; font-size: 250%; color: red">
													6666.99							
												</td>
											</tr>
										</table>
									</a>
								</h4>
							</div>
							<div id="collapse${value.gunID}" class="panel-collapse collapse in">
								<div class="panel-body">
									<table class="no-border">
										<tr>
											<td align="center" colspan="2">
											<button onclick="setonoff(${counter.count})" class="btn btn-danger btn-lg btn-block" 
											        id="status${counter.count}">等待插卡....</button>
											</td>
										</tr>
										<tr>
											<td class="title" id="title1${counter.count}">上次加油</td>
											<td align="center" id="value1${counter.count}">12.34</td>
										<tr>
											<td class="title" id="title2${counter.count}">上次日期</td>
											<td align="center" id="value2${counter.count}">2015-01-01</td>
										</tr>
										<tr>
											<td class="title" id="title3${counter.count}">卡号</td>
											<td align="center" id="value3${counter.count}">720000123456</td>
										</tr>
										<tr>
											<td class="title" id="title4${counter.count}">车辆类型</td>
											<td align="center"><image src="images/bigbus.gif" id="value4${counter.count}"></td>
										</tr>
										<!-- 
										<tr>
											<td align="center" colspan="2"><image src="images/comm.jpg" style="width:100%;"></td>
										</tr>
										-->
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</div>
		<!-- <div class="modal fade"   id="checkPassword" > -->
		<div class="modal md-modal colored-header warning md-effect-10"
			id="checkPassword">
			<div class="modal-dialog"
				style="width: 25%; height: 30%; position: absolution; top: 30%">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">请输入密码</h4>
					</div>
					<div class="modal-body">
						<form id="functionForm" action="#" class="form-horizontal"
							role="form" method="post">
							<div class="form-group">
								<label for="username" class="col-sm-3 control-label">用户名</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="operatorcode"
										name="operatorcode" value="${user}" disabled>
								</div>
								<label for="password" class="col-sm-3 control-label">密&nbsp;&nbsp;码</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="operatorpassword" name=operatorpassword
										placeholder="请输入密  码">
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-lg btn-block" data-loading-text="信息提交中.....">密 码 校 验</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<script type="text/javascript" 	src="js/jquery.js"></script>
	<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="js/behaviour/general.js"></script>
	<script type="text/javascript"	src="js/jquery.ui/jquery-ui.js"></script>
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<!-- 
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>	
	<script type="text/javascript"	src="js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="js/jquery.datatables/jquery.datatables.min.js"></script>
	<script type="text/javascript" src="js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script> 
	-->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript">
		//$("#sidebar-collapse").click();
      $(document).ready(function(){
        //initialize the javascript
        App.init();     
        
      });
      function getinfo(strurl){
			$.ajax({
				url:strurl,//"queryCardTrade.htm",
				type:"GET",
				//dataType:'json',
				//data:"page=0&counter=4",  						
				success:function(result){
					//alert(result);
					$('#page_content').html(result);
				},
				error:function(xhr){
					//alert(xhr.status+" "+xhr.statusText);
					alert("没有访问权限");
				}
			});
		};
		
    </script>
	<!-- <script src="js/behaviour/voice-commands.js"></script> -->
	
	<!-- <script type="text/javascript" 		src="js/jquery.flot/jquery.flot.js"></script> -->
	<!-- <script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.resize.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.labels.js"></script> -->

</body>
</html>
