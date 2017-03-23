<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" />
	<!-- <link rel="stylesheet" type="text/css" href="js/flipclock/flipclock.css" /> -->
	<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
<div class="container-fluid">
<div class="row-fluid">
	<div  class="col-md-2">
		<div class="block-flat  no-padding ">	
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
  			<td colspan="2"><button id="sets" style="width:100%;margin:0px;" class="btn btn-primary" >批量操作</button></td>
  		</tr>  				
		</tbody>
		</table>
		</div>	
    </div>  
    <div class="col-md-10">    	
    	<div class="block-flat ">
    	<div class="header">
    		<h3>下传控制码</h3>
    	</div>
    	<div class="content">
    	<div class="form-horizontal" >           
    		<div class="form-group">
              	<label class="col-md-3 control-label">加油站名称:</label>
              	<div class="col-md-7">
                	<input  class="form-control"  value="${paras.stationName}" readonly>
              	</div>
            </div>
            <div class="form-group">
              	<label class="col-sm-3 control-label">总队控制码:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  value="${paras.amountCortrolCode}" readonly>
              	</div>
            </div>
            <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">总部控制码:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  value="${paras.headQuartersCortrolCode}" readonly>
              	</div>
            </div>
            <div class="col-md-offset-4">
            	<button style="width:50%" class="btn btn-primary" id="setCode">设置控制码</button>            
            </div>
        </div>
    	</div>	
    	</div>
    	<div class="block-flat ">        	
    	<div class="header">
    		<h3>下传时钟</h3>
    	</div>
    	<div class="content">
    		<div class="form-horizontal" >      		
    		<div class="form-group ">
    		<div class="col-md-3 col-md-offset-1">
        	<div class=" input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd hh:ii">
				<input id="setSystemClock" name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>
				<span  class="input-group-addon btn btn-primary" id="setClock">设置时钟
				<span  class="glyphicon glyphicon-th" >
				</span></span>				
			</div>
			</div>			
    		<div class="col-md-3 col-md-offset-2">
        	<div class=" input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd hh:ii">
				<input name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>
				<span  class="input-group-addon btn btn-info" id="getClock">读取时钟
				<span  class="glyphicon glyphicon-th" >
				</span></span>		
			</div>
			</div>			
			</div>			
			</div>      
    	</div>
    	</div>
    	<div class="block-flat ">        	
    	<div class="header">
    		<h3>下传油品,单价</h3>
    	</div>
    	<div class="content">
    		<div class="form-horizontal" >     		
    		<div class="form-group ">
    		<div class="col-md-3 col-md-offset-1">
    		<div class=" input-group ">
        		<input name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>				
        		<input name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>
        		<span  class="input-group-addon btn btn-primary" id="setPriceOiltype">设置油品单价
				<span  class="glyphicon glyphicon-th" >
				</span></span>		        		        		 
			</div>
			</div>
			<div class="col-md-3 col-md-offset-2">
    		<div class=" input-group ">
        		<input name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>				
        		<input name="systemClock" style="width:140px;font-size:14px;" class="form-control " type="text" name="date_from" readonly>
        		<span  class="input-group-addon btn btn-info" id="getPriceOiltype">读取油品单价
				<span  class="glyphicon glyphicon-th" >
				</span></span>		        		        		 
			</div>
			</div>	
			</div>						
			</div>      
    	</div>
    	</div>
	</div>
</div>
</div>
<script type="text/javascript" 	src="js/jquery.js"></script>
<!-- <script type="text/javascript" 	src="js/flipclock/flipclock.min.js"></script> -->
<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>	
<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" 	src="js/behaviour/general.js"></script>
<script>
	//$(".datetime").datetimepicker({
	//	autoclose: true,todayHighlight:true	,show:true	
	//});	
	$('.icheck').iCheck({
    	checkboxClass: 'icheckbox_square-blue checkbox',
    	radioClass: 'iradio_square-blue'
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
		var count=0;
		var index=1;
		var value=0;
		$('input[name=cheers]:checkbox').each(function(){
			if(true == $(this).is(':checked')){
				var obj={index:count,value:1};
				cheerStatus.push(obj);
				count++;
				value=index;
			}else{
				var obj={index:count,value:0};
				cheerStatus.push(obj);
			}
			index++;
		});	
		if(count==0) return -2;
		if(count>=2) return -1;
		return value;
	};
	$('#sets').click(function(){
		getStatus();
		//alert(cheerStatus.toString());
		$.ajax({
			type:"post", 
	        url:"setCheers/all", 
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
	$('#setCode').click(function(){
		getStatus();
		//alert(cheerStatus.toString());
		$.ajax({
			type:"post", 
	        url:"setCheers/code", 
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
	$('#setClock').click(function(){
		$('#setSystemClock').val('下传时钟中.....');
		getStatus();
		//alert(cheerStatus.toString());
		$.ajax({
			type:"post", 
	        url:"setCheers/clock", 
	        //dataType:"json",      
	        contentType:"application/json;charset=UTF-8",               
	        data:JSON.stringify(cheerStatus),
			success:function(data){
				$('#setSystemClock').val(data);
			},
			error:function(xhr){
				$('#setSystemClock').val('下传失败:'+xhr.status);
			}
		});
	});	
	$('#getClock').click(function(){
		var index=getSingleStatus();
		if ((index==-1) || (index==0)||(index==-2)){
			alert('请单选' +index);
			return ;
		}
		//alert('单选 '+index);
		$.ajax({
			type:"get", 
	        url:"getCheerClock/"+index, 
	        //dataType:"json",      
	        contentType:"application/json;charset=UTF-8",               
	        //data:JSON.stringify(cheerStatus),
			success:function(data){
				alert(data);
			},
			error:function(xhr){
				alert(xhr.status);
			}				
		})
	});
	$('#setPriceOiltype').click(function(){
		getStatus();
		//alert(cheerStatus.toString());
		$.ajax({
			type:"post", 
	        url:"setCheers/price", 
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
	$('#getPriceOiltype').click(function(){
		var index=getSingleStatus();
		if ((index==-1) || (index==0)||(index==-2)){
			alert('请单选' +index);
			return ;
		}
		//alert('单选 '+index);
		$.ajax({
			type:"get", 
	        url:"getCheerPrice/"+index, 
	        //dataType:"json",      
	        contentType:"application/json;charset=UTF-8",               
	        //data:JSON.stringify(cheerStatus),
			success:function(data){
				alert(data);
			},
			error:function(xhr){
				alert(xhr.status);
			}				
		})
	});
</script>        
</body>
</html>
