<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>加 油 监 控</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<!-- 
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/jquery.min.js"></script>
    <script src="bootstrap/bootstrap.min.js"></script>
    <script src="bootstrap/js-numeral.min.js"></script>
    
	<link rel="shortcut icon" href="gasstation.ico" type="image/x-icon"/>
	<style type="text/css">
	h1{
		text-align:center;
		text-shadow:2px 2px gray;
		font-size:300%
	}
	body{
		background-image:url('bootstrap/jyback.jpg');	
	}
	.info{
		color:white;
		background-color:black;		
		text-align:center;
		width:100%;
		disabled:true;
		readonly:true;
		
	}
	.title{
		text-align:center;		
		color:white;
		width:200%;
	}
	</style>
<!--  <script type="text/javascript" src="highcharts/jquery-1.8.3.min.js"></script>-->
  <script type="text/javascript" src="highcharts/highcharts.js"></script>
  <script type="text/javascript" src="highcharts/exporting.js"></script>
	<script type="text/javascript">
	$(function () {                                                                     
    $(document).ready(function() {                                                  
        //Highcharts.setOptions({                                                     
        //    global: {                                                               
        //        useUTC: false                                                       
        //    }                                                                       
        //});                                                                         
                                                                                    
     	var chart;                                                                  
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
                                                                                    
}); 
	window.setInterval("set()",40);
	var  i=0;
	function set(){
		i=i+1;		
		var con=printf('%06d',i);
		document.getElementById("jyl1").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		document.getElementById("jyl2").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		document.getElementById("jyl3").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
		document.getElementById("jyl4").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
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
		type: 'POST',
		data:JSON.stringify({username:'zhaijk',password:'liaojing',rightID:'16776'}),
		dataType:'json',
		contentType:'application/json',
		success:function(result){
			//alert(result);
			$("#status").text(result);
		}
	};
	window.setInterval("sendInfo()",1000);
	function sendInfo(){
		//alert("..");
		config.url="oilgunInfo";
		$.ajax(config);
	}
	</script>
  </head>  
  <body > 
  <nav class="navbar  navbar-inverse" role="navigation">
   	<div class="navbar-header">
      <a class="navbar-brand">加 油 监 控</a>
   	</div>
   	<div>
      <ul class="nav navbar-nav">
         <li><a href="#" onclick="gettankinfo();">油罐信息查询</a></li>
         <li><a href="#" onclick="gettankinfo();">输入加油机密码</a></li>
         <li><a href="#" onclick="gettankinfo();">强制退卡</a></li>
         <li><a href="#" onclick="gettankinfo();">加油机状态设置</a></li>
         <li><a href="#" onclick="gettankinfo();">加油机监控切换</a></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               系统功能 
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#" onclick="gettankinfo();">消费记录查询</a></li>
               <li class="divider"></li>               
               <li><a href="#" onclick="gettankinfo();">加油机重新初始化</a></li>
            </ul>
         </li>         
      </ul>      
      <ul class="nav navbar-nav navbar-right">          	
          	<li ><a href="#" onclick="logout();" style="color:white"><img src="bootstrap/user.jpg" style="height:25px"> 当前用户: ${user} 退 出</a></li>
      </ul>
          
   	</div>
   	
	</nav>
  	<h1><b>IC卡加油自动控制(监控模式)</b></h1>
	<div style="position:absolute;left:4%;top:30%">
		<table style="background-color:black;border:none;width:250px">
			<tr align="center"
				style="background-color:gray;font-family:黑体;font-size:200%;color:white;text-align:right">
				<td>1号枪</td>
				<td>93#汽油</td>
			</tr>
			<tr>
				<td id="jyl1" align="center" colspan="2"	style="background-color:black;font-family:Pixel LCD-7;font-size:300%;color:green">9999.66</td>
				<!--<td id="jyl" align="center" colspan="2"	style="background-color:black;font-family:superaircraft;font-size:300%;color:green">9999.66</td> -->
			</tr>			
			<tr>
				<td colspan="2"><button type="button" class="btn btn-primary btn-lg btn-block disabled" >等待插卡....</button></td>
			</tr>
			<tr>
				<td class="title">上次加油</td>
				<td align="center"><input type="text" value="12.34"   class="info" disabled></td>
			<tr>
				<td class="title">上次日期</td>
				<td align="center"><input type="text" value="2015-1-1" class="info" disabled></td>
			</tr>
			<tr>
				<td class="title">IC卡余额</td>
				<td align="center"><input type="text" value="12345.67 L" class="info" disabled> </td>
			</tr>
			<tr>
				<td class="title">车辆类型</td>
				<td align="center"><input type="text" value="小客车" class="info" disabled></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="text" value="通讯正常" class="info" disabled></td>
			</tr>
		</table>

	</div>
	<div style="position:absolute;left:29%;top:30%">
		<table style="background-color:black;border:none;width:250px">
			<tr align="center"
				style="background-color:gray;font-family:黑体;font-size:200%;color:white;text-align:right">
				<td>2号枪</td>
				<td>93#汽油</td>
			</tr>
			<tr>
				<td id="jyl2" align="center" colspan="2"	style="background-color:black;font-family:Pixel LCD-7;font-size:300%;color:lightgreen">9999.66</td>
				<!--<td id="jyl" align="center" colspan="2"	style="background-color:black;font-family:superaircraft;font-size:300%;color:green">9999.66</td> -->
			</tr>			
			<tr>
				<td colspan="2"><button type="button" class="btn btn-primary btn-lg btn-block" >开机...</button></td>
			</tr>
			<tr>
				<td class="title">上次加油</td>
				<td align="center"><input type="text" value="12.34"   class="info" disabled></td>
			<tr>
				<td class="title">上次日期</td>
				<td align="center"><input type="text" value="2015-1-1" class="info" disabled></td>
			</tr>
			<tr>
				<td class="title">IC卡余额</td>
				<td align="center"><input type="text" value="12345.67 L" class="info" disabled> </td>
			</tr>
			<tr>
				<td class="title">车辆类型</td>
				<td align="center"><input type="text" value="小客车" class="info" disabled></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="text" value="通讯正常" class="info" disabled></td>
			</tr>
		</table>

	</div>
	<div style="position:absolute;left:54%;top:30%">
		<table style="background-color:black;border:none;width:250px">
			<tr align="center"
				style="background-color:gray;font-family:黑体;font-size:200%;color:white;text-align:right">
				<td>3号枪</td>
				<td>0#柴油</td>
			</tr>
			<tr>
				<td id="jyl3" align="center" colspan="2"	style="background-color:black;font-family:Pixel LCD-7;font-size:300%;color:yellow">9999.66</td>
				<!--<td id="jyl" align="center" colspan="2"	style="background-color:black;font-family:superaircraft;font-size:300%;color:red">9999.66</td> -->
			</tr>			
			<tr>
				<td colspan="2"><button type="button" class="btn btn-primary btn-lg btn-block" >停止加油....</button></td>
			</tr>
			<tr>
				<td class="title">上次加油</td>
				<td align="center"><input type="text" value="12.34"   class="info" disabled></td>
			<tr>
				<td class="title">上次日期</td>
				<td align="center"><input type="text" value="2015-1-1" class="info" disabled></td>
			</tr>
			<tr>
				<td class="title">IC卡余额</td>
				<td align="center"><input type="text" value="12345.67 L" class="info" disabled> </td>
			</tr>
			<tr>
				<td class="title">车辆类型</td>
				<td align="center"><input type="text" value="小客车" class="info" disabled></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="text" value="通讯失败" class="info" disabled style="color:red"></td>
			</tr>
		</table>

	</div>
	<div style="position:absolute;left:79%;top:30%">
		<table style="background-color:black;border:none;width:250px">
			<tr align="center"
				style="background-color:gray;font-family:黑体;font-size:200%;color:white;text-align:right">
				<td>4号枪</td>
				<td>-10#柴油</td>
			</tr>
			<tr>
				<td id="jyl4" align="center" colspan="2"	style="background-color:black;font-family:Pixel LCD-7;font-size:300%;color:red">9999.66</td>
				<!--<td id="jyl" align="center" colspan="2"	style="background-color:black;font-family:superaircraft;font-size:300%;color:red">9999.66</td> -->
			</tr>			
			<tr>
				<td colspan="2"><button type="button" class="btn btn-primary btn-lg btn-block disabled" >加油完成....</button></td>
			</tr>
			<tr>
				<td class="title">上次加油</td>
				<td align="center"><input type="text" value="12.34"   class="info" disabled></td>
			<tr>
				<td class="title">上次日期</td>
				<td align="center"><input type="text" value="2015-1-1" class="info" disabled></td>
			</tr>
			<tr>
				<td class="title">IC卡余额</td>
				<td align="center"><input type="text" value="12345.67 L" class="info" disabled> </td>
			</tr>
			<tr>
				<td class="title">车辆类型</td>
				<td align="center"><input type="text" value="小客车" class="info" disabled></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="text" value="重试中......" class="info" disabled></td>
			</tr>
		</table>
	</div>	
	
	  <div id="curve" style="width:20%;height:20%;position:absolute;top:80%"></div> 
	 
	 <div class="modal fade"   id="checkPassword" >
     <div class="modal-dialog"style="width:25%;height:30%;position:absolution;top:30%">
	 <div class="modal-content" >
	 	<div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请输入密码
            </h4>
         </div>
		<div class="modal-body">
			<form id="functionForm" action="#" class="form-horizontal"	role="form" method="post">
				<div class="form-group">
					<label for="username" class="col-sm-3 control-label">用户名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="operatorcode" name="operatorcode" value="${user}" disabled>
					</div>
					<label for="password" class="col-sm-3 control-label">密&nbsp;&nbsp;码</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="operatorpassword" name=operatorpassword placeholder="请输入密  码">
					</div>
				</div>
				<button type="submit" class="btn btn-primary btn-lg btn-block" data-loading-text="信息提交中.....">
      			密 码 校 验
   				</button>
				
			</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>
