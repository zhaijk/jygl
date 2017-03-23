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

	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" />
	<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />
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
<body >
	
	<div id="head-nav" class="navbar navbar-default navbar-fixed-top">	
		<jsp:include page="topnav.jsp" flush="true" />
	</div>
	<div class="sb-collapsed" id="cl-wrapper">		
		<jsp:include page="sidebar.jsp" flush="true" />			
		<div id="page_content">
			<jsp:include page="monitor.jsp" flush="false" />				
		</div>
	</div>
	<div class="modal md-modal colored-header warning md-effect-10"	id="checkPassword">
	  <div class="modal-dialog"	style="width: 25%; height: 30%; position: absolution; top: 30%">
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
	<script type="text/javascript" 	src="js/jquery.js"></script>
	<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" 	src="js/behaviour/general.js"></script>	
	<script type="text/javascript"	src="js/jquery.ui/jquery-ui.js"></script>
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>		 
    <script type="text/javascript"  src="js/derun/main.js"></script>
	
<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.js"></script>
<script type="text/javascript" src="js/jquery.datatables/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script src="js/jquery.jqprint-0.3.js" type="text/JavaScript" language="javascript"></script>
<script src="js/jquery.printarea.js" type="text/JavaScript" ></script>
	<!-- 
	<script type="text/javascript" 	src="js/jquery.js"></script>
	<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="js/behaviour/general.js"></script>
	<script type="text/javascript"	src="js/jquery.ui/jquery-ui.js"></script>
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	 -->
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
		
    </script>    
	<!-- <script src="js/behaviour/voice-commands.js"></script> -->
	
	<!-- <script type="text/javascript" 		src="js/jquery.flot/jquery.flot.js"></script> -->
	<!-- <script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.resize.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.labels.js"></script> -->

</body>
</html>
