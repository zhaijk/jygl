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

<script type="text/javascript">
	//$(function () {                                                                     
                                                     
//}); 
	//window.setInterval("set()",40);
	var  i=0;
	function set(){
		i=i+1;		
		var con=printf('%06d',i);
		//document.getElementById("jyl1").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		//for(var i=1;i<17;i++){
			//var idname=printf('jyl%d',i);
			//$(idname).text(con.substring(0,4)+'.'+con.substring(4,6)); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		//}
		//$("#jyl1").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl2").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl3").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl4").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl5").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl6").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl7").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl8").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl9").text(con.substring(0,4)+'.'+con.substring(4,6));
		$("#jyl10").text(con.substring(0,4)+'.'+con.substring(4,6));
		
		//document.getElementById("jyl2").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		//document.getElementById("jyl3").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		//document.getElementById("jyl4").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
	};
	function printf(){
    var as=[].slice.call(arguments),fmt=as.shift(),i=0;
  	return     fmt.replace(/%(\w)?(\d)?([dfsx])/ig,function(_,a,b,c){
          var s=b?new Array(b-0+1).join(a||''):'';
          if(c=='d') s+=parseInt(as[i++]);
          return b?s.slice(b*-1):s;
     });
	};
	function gettankinfo()
	{
		$("#checkPassword").modal('show');
		$("#functionForm").attr("action", "getTanksinfo");
	};
	function logout()
	{
		$("#checkPassword").modal('show');
		$("#functionForm").attr("action", "logout");
	};
	var config={
		type: 'GET',
		//data:JSON.stringify({username:'zhaijk',password:'liaojing',rightID:'16776'}),		
		dataType:'JSON',
		contentType:'application/json',
		success:function(result){
		
		//alert();
			for(var i=0,index=0;i<16;i++)
			{	
				index=i+1;
				$("#commstatus"+index).val(result[i]["commStatus"]);
				if(result[i]["status"]=="(开机)")//插卡状态
				{
					//$("#status"+index).
					$("#status"+index).removeClass("disabled");
					//$("#status"+i).addClass("disabled");
					$("#value3"+index).val(result[i]["value3"]);
					$("#jyl"+index).css("color","yellow");
				}
				else if(result[i]["status"]=="加油中 (停止加油)")//加油中...
				{
					$("#status"+index).removeClass("disabled");
					var con=result[i]["value3"];
					con=con.substring(0,4)+'.'+con.substring(4,6);
					$("#jyl"+index).text(con);		
					$("#value4"+index).attr("src",result[i]["value4"]);		
					$("#jyl"+index).css("color","lightgreen");	
				}				
				else//待机状态
				{
					$("#status"+index).addClass("disabled");
					//$("#value3"+index).attr("src",result[i]["value3"]);
					$("#value4"+index).attr("alt",result[i]["value4"]);
					$("#value3"+index).val(result[i]["value3"]);
					$("#jyl"+index).css("color","red");
				}
				$("#status"+index).text(result[i]["status"]);
				
				$("#title1"+index).text(result[i]["item1"]);
				$("#value1"+index).val(result[i]["value1"]);
				$("#title2"+index).text(result[i]["item2"]);
				$("#value2"+index).val(result[i]["value2"]);				
				$("#title3"+index).text(result[i]["item3"]);								
				$("#title4"+index).text(result[i]["item4"]);
				//$("#value4"+index).attr("src",result[i]["value4"]);
				//$("#jyl1").text(result[i]["value1"]);
			}
		}
	};
	window.setInterval("sendInfo()",1000);
	//var index=0;
	function sendInfo(){
		//alert("..");
		//for(var i=0;i<10;i++)
		//{
			config.url="oilgunInfo/0";
			$.ajax(config);
			//index++;
			//if(index>16) index=1;
		//}	
	}
	var onoffconfig={
		
		type: 'GET',
		//data:JSON.stringify({username:'zhaijk',password:'liaojing',rightID:'16776'}),		
		dataType:'JSON',
		contentType:'application/json',
		success:function(result){
			alert(result);
		}
	};
	function setonoff(gunid)
	{
		onoffconfig.url="setonoff/"+gunid;
		$.ajax(onoffconfig);
	}
	</script>
</head>
<body>
	<jsp:include page="topnav.jsp" flush="true" />
	<div class="sb-collapsed" id="cl-wrapper">
		<jsp:include page="sidebar.jsp" flush="true" />
		<div id="page_content">
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
