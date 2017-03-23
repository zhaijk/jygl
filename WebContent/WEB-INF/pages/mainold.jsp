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
    $(document).ready(function() {                                                  
        //Highcharts.setOptions({                                                     
        //    global: {                                                               
        //        useUTC: false                                                       
        //    }                                                                       
        //});                                                                         
                                                                                    
     	//var chart;                                                                  
        $('#curve').highcharts({                                                
            chart: {                                                                
                type: 'spline',                                                     
                animation: Highcharts.svg, // don't animate in old IE               
                marginRight: 10,                                                    
                events: {                                                           
                    load: function() {                                              
                                                                                    
                        // set up the updating of the chart each second             
                        var series = this.series[0];                                
                        	setInterval(function() {                                    
                            var x = (new Date()).getTime(), // current time         
                                y=Math.random()*10;                             
                            series.addPoint([x, y], true, true);                                               
                        }, 1000);                                                   
                    }                                                               
                }                                                                   
            },                                                                      
            title: {                                                                
                text: '通讯状态'                                            
            },                                                                      
            xAxis: {                                                                
                type: 'datetime',                                                   
                tickPixelInterval: 1000                                              
            },                                                                      
            yAxis: {                                                                
                title: {                                                            
                    text: 'Status'                                                   
                },                                                                  
                plotLines: [{                                                       
                    value: 0,                                                       
                    width: 1,                                                       
                    color: '#808080'                                                
                }]                                                                  
            },                                                                      
            tooltip: {                                                              
                formatter: function() {                   
                		return '<b>'+ "1号枪通讯状态" +'</b><br>'+                
                        //Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br>'+
                        //Highcharts.numberFormat(this.y, 2);
                        "查询状态命令"+'<br>'+"响应正常";                          
                        /*return '<b>'+ this.series.name +'</b><br>'+                
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br>'+
                        Highcharts.numberFormat(this.y, 2);
                        */                         
                }                                                                   
            },                                                                      
            legend: {                                                               
                enabled: false                                                      
            },                                                                      
            exporting: {                                                            
                enabled: false                                                      
            },                                                                      
            series: [{                                                              
                name: 'Random data',                                                
                data: (function() {                                                 
                    // generate an array of random data                             
                    var data = [],                                                  
                        time = (new Date()).getTime(),                              
                        i;                                                          
                                                                                    
                    for (i = -19; i <= 0; i++) {                                    
                        data.push({                                                 
                            x: time + i * 1000,                                     
                            y: Math.random()                                        
                        });                                                         
                    }                                                               
                    return data;                                                    
                })()                                                                
            }]                                                                      
        });                                                                         
    });                                                                             
                                                                                    
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
	<!-- Fixed navbar -->
	<div id="head-nav" class="navbar navbar-default navbar-fixed-top">
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
						<img alt="Avatar" src="images/avatar2.jpg" /><span>zhaijk</span> 
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
	</div>
	<!-- Fixed navbar -->
	<div class="sb-collapsed" id="cl-wrapper">
		<div class="cl-sidebar" >
			<div class="cl-navblock">
				<div class="menu-space">
					<div class="content">
						<ul class="cl-vnavigation">
							<li><a href="monitor.htm"><i class="fa fa-desktop"></i><span>加油监控模式</span></a></li>
							<li><a href="monitor.htm"><i class="fa fa-sitemap"></i><span>加油主控模式</span></a></li>
							<li><a href="#"><i class="fa fa-search"></i><span>消费记录操作</span></a>
								<ul class="sub-menu">
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询消费记录</a></li>
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询发放记录</a></li>
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询进油记录</a></li>
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询油位记录</a></li>
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询操作日志</a></li>
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询黑名单</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-gear"></i><span>系统设置-设备参数定义</span></a>
								<ul class="sub-menu">
									<li><a href="index-2.html">加油机定义</a></li>
									<li><a href="index-2.html">油罐定义</a></li>
									<li><a href="index-2.html">车类型定义</a></li>
									<li><a href="index-2.html">油品定义</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-gears"></i><span>系统设置-系统信息设置</span></a>
								<ul class="sub-menu">
									<li><a href="index-2.html">加油站单位信息</a></li>
									<li><a href="index-2.html">加油监控参数设置</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-exchange"></i><span>设备参数设置</span></a>
								<ul class="sub-menu">
									<li><a href="form-elements.html">下传黑名单</a></li>
									<li><a href="form-validation.html">下传指标</a></li>
									<li><a href="form-wizard.html">下传系统时钟</a></li>
									<li><a href="form-masks.html">下传油品</a></li>
									<li><a href="form-masks.html">下传单价</a></li>
									<li><a href="form-masks.html">下传控制码</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-tags"></i><span>卡操作</span></a>
								<ul class="sub-menu">
									<li><a href="tables-general.html">读卡</a></li>
									<li><a href="tables-general.html">IC卡解灰</a></li>
									<li><a href="tables-general.html">断电处理</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-search"></i><span>消费记录操作</span></a>
								<ul class="sub-menu">															
									<li><a href="#" onclick="getinfo('queryCardTrade.htm')">读脱机记录</a></li>
									<li><a href="tables-general.html">读IC卡机记录</a></li>
									<li><a href="tables-general.html">读取原始IC卡机记录</a></li>									
								</ul></li>
							<li><a href="#"><i class="fa fa-print"></i><span>报表管理</span></a>
								<ul class="sub-menu">
									<li><a href="tables-general.html">月报</a></li>
									<li><a href="tables-general.html">日报</a></li>
									<li><a href="tables-general.html">年报</a></li>
									<li><a href="tables-general.html">自定义报</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-refresh"></i><span>数据同步管理</span></a>
								<ul class="sub-menu">
									<li><a href="maps.html">参数定义</a></li>
									<li><a href="maps.html">手动操作</a></li>
									<li><a href="maps.html">数据上传</a></li>
									<li><a href="maps.html">数据下载</a></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-refresh"></i><span>系统用户管理</span></a>
								<ul class="sub-menu">								
									<li><a href="#" onclick="getinfo('userManager.htm')">用户管理</a></li>									
								</ul></li>	
						</ul>
					</div>
				</div>
				<div class="text-right collapse-button" style="padding: 7px 9px;">
					<button id="sidebar-collapse" class="btn btn-default" >
						<i style="color: #fff;" class="fa fa-angle-right"></i>
					</button>
				</div>
			</div>
		</div>
		<div id="page_content">
		<div class="container-fluid" id="pcont">
		 	<div class="stats_bar">
				<div class="butpro butstyle" data-step="2">
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
									<a class="collapsed" data-toggle="collapse" data-parent="#accordion2${value.gunID}" href="#collapse${value.gunID}">
										<table>
											<tr style="background-color:black">
												<td align="left" style="font-weight:bold;font-size:25px;color:white"><i class="fa fa-angle-right"></i>${value.gunID}号枪</td>
												<td align="right" style="font-weight:bold;font-size:20px;color:yellow">${value.oilType}</td>
											</tr>
											<tr >
												<td id="jyl${counter.count}" colspan="2" align="center" 
													style="background-color: black; font-family: Pixel LCD-7; font-size: 250%; color: red">
													9999.99							
												</td>
											</tr>
										</table>
									</a>
								</h4>
							</div>
							<div id="collapse${value.gunID}" class="panel-collapse collapse ">
								<div class="panel-body" style="background-color:gray">
									<table class="table" style="background-color:black">
										<tr style="background-color:black">
											<td align="center" colspan="2">
											<button onclick="setonoff(${counter.count})" class="btn btn-danger btn-lg btn-block" 
											        id="status${counter.count}">等待插卡....</button>
											</td>
										</tr>
										<tr style="background-color:black">
											<td class="title" id="title1${counter.count}">上次加油</td>
											<td align="center" id="value1${counter.count}">12.34</td>
										<tr style="background-color:black">
											<td class="title" id="title2${counter.count}">上次日期</td>
											<td align="center" id="value2${counter.count}">2015-01-01</td>
										</tr>
										<tr style="background-color:black">
											<td class="title" id="title3${counter.count}">卡号</td>
											<td align="center" id="value3${counter.count}">720000123456</td>
										</tr>
										<tr style="background-color:black">
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
	<script type="text/javascript"		src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" 		src="js/jquery.flot/jquery.flot.js"></script> -->
	<!-- <script type="text/javascript" src="js/jquery.flot/jquery.flot.pie.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.resize.js"></script> -->
	<!-- <script type="text/javascript"	src="js/jquery.flot/jquery.flot.labels.js"></script> -->

</body>
</html>
