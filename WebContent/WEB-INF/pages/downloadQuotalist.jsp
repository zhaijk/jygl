<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<!-- <link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="js/flipclock/flipclock.css" /> -->
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" />
	<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
<div class="container-fluid">
<div class="row-fluid">
	<div  class="col-md-2 ">
		<div class="block-flat no-padding">	
		<table class="table table-condensed no-border table-hover" >
		<thead class="no-border">
		<tr>
			<td colspan="2"> </td>
		</tr>
		</thead>
		<tbody class="no-border-y">
		<tr>
			<td ><input type="checkbox"  id="select_op" class="icheck"></td>
			<td style="font-size:16px">全选</td>
		</tr>
		<c:forEach items="${cheers}" var="value" varStatus="counter">
  			<tr >
  				<td><input type="checkbox"   name="cheers" class="icheck"></td>
  				<td style="font-size:16px">${value.gunCode}号卡机</td>  				
  			</tr>  			
  		</c:forEach>
  		<tr>
  			<td colspan="2"><button id="set" style="width:100%;margin:0px;" class="btn btn-primary" >下传操作</button></td>
  		</tr>  				
		<tr>
  			<td colspan="2"><button id="sets" style="width:100%;margin:0px;" class="btn btn-primary" >批量操作</button></td>
  		</tr>  				
		</tbody>
		</table>
		</div>	
    </div>  
    <div class="col-md-10 ">    	
    <div class="block-flat ">
    	<div class="header">
    		<h3>下传指标</h3>
    	</div>  
    	<div class="table-responsive">  	
    	<table class="table table-hover  table-bordered table-condensed display" id="quotalist">
    		<thead>
    		<tr>
    			<th>日期</th>
    			<th>时间</th>
    			<th>卡号</th>
    			<th>油品</th>
    			<th>发放次数</th>
    			<th>发放量</th>
    		</tr>
    		</thead>
    		<tbody>
    		<c:forEach items="${cardPutouts}" var="value" varStatus="counter">
    			<tr>
    				<td>${value.providedate}</td>
    				<td>${value.providetime}</td>
    				<td>${value.cardcode}</td>
    				<td>${value.oiltype}</td>
    				<td>${value.sendflag}</td>
    				<td>${value.guidelinecount}</td>
    			</tr>
    		</c:forEach>
    		</tbody>
    		<tfoot>
    		<tr>
    			<th>日期</th>
    			<th>时间</th>
    			<th>卡号</th>
    			<th>油品</th>
    			<th>发放次数</th>
    			<th>发放量</th>    	  			
    		</tr>
    		</tfoot>
    	</table>    	
    	</div>
	</div>
	</div>
</div>
</div>
<div class="progress progress-striped active">
	<div id="pro" class="progress-bar progress-bar-success" style="width:50%"><p id="info">下传指标</p></div>
</div>
<!-- <script type="text/javascript" 	src="js/jquery.js"></script> -->
<!-- <script type="text/javascript" 	src="js/flipclock/flipclock.min.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>	
<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript" src="js/jquery.datatables/js/jquery.dataTables.min.js"></script>
 -->
 <script type="text/javascript" src="js/jquery.datatables/js/jquery.dataTables.min.js"></script>
<!-- <script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script> -->
<!-- <script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script> -->
<!-- <script type="text/javascript" 	src="js/behaviour/general.js"></script> -->
<script>
	//$(".datetime").datetimepicker({
	//	autoclose: true,todayHighlight:true	,show:true	
	//});	
	$('.icheck').iCheck({
    	checkboxClass: 'icheckbox_square-blue checkbox',
    	radioClass: 'iradio_square-blue'
	});
	$(function() {
		$('#quotalist').dataTable({
			pagingType:"full_numbers",
			//sort:false,
			"bAutoWidth": false,
    		"bLengthChange" : false,
    		"bSort" :false,
    		"sSearch":true,
    		"bFilter":true
		});
	});
	
	$('#select_op').on('ifChecked', function(event){
		$('.icheck').iCheck('check');
	});
	$('#select_op').on('ifUnchecked', function(event){
		$('.icheck').iCheck('uncheck');
	});
	var cheerStatus=new Array();
	function getStatus(){
		cheerStatus.length=0;
		var count=1;
		$('input[name=cheers]:checkbox').each(function(){
			if(true == $(this).is(':checked')){
				var obj={index:count,value:1};
				cheerStatus.push(obj);
			}else{
				var obj={index:count,value:0};
				cheerStatus.push(obj);
			}
			count++;
		});
	};
	function getSingleStatus(){
		cheerStatus.length=0;
		var count=0;
		var index=1;
		var value=0;
		$('input[name=cheers]:checkbox').each(function(){
			if(true == $(this).is(':checked')){
				var obj={index:index,value:1};
				cheerStatus.push(obj);
				count++;
				value=index;
			}else{
				var obj={index:index,value:0};
				cheerStatus.push(obj);
			}
			index++;
		});	
		if(count==0) return -2;
		if(count>=2) return -1;
		return value;
	};
	function getall(){
		cheerStatus.length=0;
		for(i=1;i<5;i++){
			var obj={index:i,value:1};
			cheerStatus.put(obj);	
		}		
	}
	$('#sets').click(function(){
		//getStatus();
		//alert(cheerStatus.toString());
		getall();
		$.ajax({
			type:"post", 
	        url:"downloadQuotalist/all", 
	        //dataType:"json",      
	        contentType:"application/json;charset=UTF-8",               
	        data:JSON.stringify(cheerStatus),
			success:function(data){
				alert(data);
			},
			error:function(xhr){
				alert(xhr.status);
			}
		});
	});
	$('#set').click(function(){
		var index=getSingleStatus();
		if (index==-2){
			alert('请选择');
			return ;
		}
		var getTimer=window.setInterval("getquotainfo()",250);
		$.ajax({
			type:"post", 
	        url:"downloadQuotalist/code", 
	        //dataType:"json",      
	        contentType:"application/json;charset=UTF-8",               
	        data:JSON.stringify(cheerStatus),
			success:function(data){
				alert(data);
				window.clearInterval(getTimer);
			},
			error:function(xhr){
				alert(xhr.status);
				window.clearInterval(getTimer);
			}
		});
	});
	function getquotainfo(){
		$.ajax({
			type:"get", 
	        url:"getDownloadInfo/quota",
	        //contentType:"application/json;charset=UTF-8",               
	        //data:JSON.stringify(cheerStatus),
			success:function(data){
				info=data.split(",");
				value=Math.round(Number(info[1])*100/Number(info[2]));
				pro=value+'%';
				$('#pro').css("width",pro);
				$('#info').text(info[0]+'号卡机 下载了'+info[1]+'条'+' 共有'+info[2]+'条 '+pro);
			},
			error:function(xhr){
				alert(xhr.status);
			}
		});
	}
</script>        
</body>
</html>
