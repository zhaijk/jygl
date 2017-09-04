<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- Mirrored from condorthemes.com/cleanzone/pages-404.html by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:37:32 GMT -->
<head>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="images/favicon.png">
	<link rel="stylesheet" href="js/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="js/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" href="js/bootstrap3-editable/css/bootstrap-editable.css">
      
	<!-- Bootstrap core CSS -->
	<!-- 
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="fonts/font-awesome-4/css/font-awesome.min.css">
 	-->
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="../../assets/js/html5shiv.js"></script>
	  <script src="../../assets/js/respond.min.js"></script>
	<![endif]-->

	<!-- Custom styles for this template -->
	<!-- <link href="css/style.css" rel="stylesheet" /> -->	
		
</head>

<body>
<div class="container-fluid" >
<div class="cl-mcont">
<div class="row">
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">	
	<div id="toolbar" class="btn-group">	
	<button id="btn_cheers_add" type="button"  class="btn  btn-default">
		<span class="glyphicon glyphicon-plus" aria-hidden="false"></span>新增
	</button>
	<button id="btn_cheers_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	</button>
	<button id="btn_cheers_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	</button>	
	<button id="btn_cheers_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-ok" aria-hidden="false"></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:16%">IC卡机参数</span>		
	</div>
</div>    
<div class="content">
<table class="table table-hover  table-bordered  table-condensed display" data-toggle="table"  id="cheers">
<thead>
  <tr> 
	<th data-field="state" data-checkbox="true"></th>
	<th data-field="gunCode" data-editable="true">IC卡机编号</th>
	<th data-field="alleywayMark" data-editable="true">通道号</th>
	<th data-field="machineCode" data-editable="true">加油机编号</th>	
	<th data-field="jarCode" data-editable="true">油罐编号</th>	
	<th data-field="machineType" data-editable="true">加油机类型</th>
   </tr>	
</thead>
<tbody>
<c:forEach items="${cheerinfos}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.gunCode}</td>
	<td>${value.alleywayMark}</td>
	<td>${value.machineCode}</td>		
	<td>${value.jarCode}</td>
	<td>${value.machineType}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">
	<div id="toolbar" class="btn-group">	
	<button id="btn_oilcans_add" type="button" class="btn   btn-default">
		<span class="glyphicon glyphicon-plus" ></span>新增
	</button>
	<button id="btn_oilcans_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" ></span>修改
	</button>
	<button id="btn_oilcans_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" ></span>删除
	</button>		
	<button id="btn_oilcans_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-ok" ></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:16%">油罐信息</span>
	</div>	
</div>    
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" data-toggle="table"  id="oilcans">
<thead>
  <tr>
  	<th  data-field="state" data-checkbox="true"></th>
	<th  data-field="jarCode" data-editable="true">罐号</th>
	<th  data-field="oilType" data-editable="true">油品类型</th>
	<th  data-field="cubage" data-editable="true">罐容积</th>
	<th  data-field="alarmUpperLimit" data-editable="true">高液位报警</th>
	<th  data-field="alarmLowerLimit" data-editable="true">低液位报警</th>					
</thead>
<tbody> 
<c:forEach items="${oilcans}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.jarCode}</td>	
	<td>${value.oilType}</td>	
	<td>${value.cubage}</td>
	<td>${value.alarmUpperLimit}</td>
	<td>${value.alarmLowerLimit}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">
	<div id="toolbar" class="btn-group">	
	<button id="btn_oiltype_add" type="button" class="btn   btn-default">
		<span class="glyphicon glyphicon-plus" ></span>新增
	</button>
	<button id="btn_oiltype_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" ></span>修改
	</button>
	<button id="btn_oiltype_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" ></span>删除
	</button>		
	<button id="btn_oiltype_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-ok" ></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:16%">油品信息</span>
	</div>	
</div>    
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" data-toggle="table" id="oiltype">
<thead>
  <tr>
  	<th data-field="state" data-checkbox="true"></th>
	<th data-field="code" data-editable="true">代码</th>
	<th data-field="name" data-editable="true">名称</th>
	<th data-field="density" data-editable="true">密度</th>
	<th data-field="unitPrice" data-editable="true">单价</th>
	<th data-field="tMemo" data-editable="true">备注</th>
  </tr>					
</thead>
<tbody> 
<c:forEach items="${oiltypes}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.code}</td>
	<td>${value.name}</td>
	<td>${value.density}</td>
	<td>${value.unitPrice}</td>
	<td>${value.tMemo}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
 <!-- 
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">
	<div id="toolbar" class="btn-group">	
	<button id="btn_cartype_add" type="button" class="btn   btn-default">
		<span class="glyphicon glyphicon-plus" ></span>新增
	</button>
	<button id="btn_cartype_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" ></span>修改
	</button>
	<button id="btn_cartype_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" ></span>删除
	</button>		
	<button id="btn_cartype_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-ok" ></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:16%">车类型</span>
	</div>	
</div> 
<div class="content">
<table class="table table-hover  table-bordered table-condensed display"  data-toggle="table" id="cartype">
<thead>
  <tr>
  	<th data-field="state" data-checkbox="true" ></th>
	<th data-field="code" data-editable="true" >编号</th>
	<th data-field="name" data-editable="true">名称</th>						
	<th data-field="classcode" data-editable="true">备注</th>
  </tr>
</thead>
<tbody> 
<c:forEach items="${cartypes}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.code}</td>	
	<td>${value.name}</td>	
	<td>${value.classcode}</td>	
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>-->
</div>
</div>
</div>
<script type="text/javascript" 	src="js/jquery.js"></script>
<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript"  src="js/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
<script type="text/javascript"  src="js/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" 	src="js/behaviour/general.js"></script>
<script>
	//$.fn.editable.defaults.mode ='inline';	
	//$('#userinfo .editable').editable('toggleDisabled');  
	var	$cheers = $('#cheers'),
    	$cheers_add = $('#btn_cheers_add'),
		$cheers_remove = $('#btn_cheers_remove'),	
		$cheers_edit = $('#btn_cheers_edit'),
		$cheers_submit=$('#btn_cheers_submit');
	var counter=0;	
    $(function () {
    	$('#cheers .editable').editable('toggleDisabled');    
    	$('#oilcans .editable').editable('toggleDisabled');
    	$('#oiltype .editable').editable('toggleDisabled');
    	$('#cartype .editable').editable('toggleDisabled');
    	//$('#role .editable').editable('toggleDisabled');
    	//IC卡机参数表编辑功能
    	$cheers_edit.click(function(){
			$('#cheers .editable').editable('toggleDisabled');   
		});	
    	//删除数据行
        $cheers_remove.click(function () {
            var ids = $.map($cheers.bootstrapTable('getSelections'), function (row) {
            	//alert(row.gunCode);
                return row.gunCode;
            });
            var rows=$.map($cheers.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}
			else{					
            	var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({gunCode:rows[i].gunCode,machineCode:rows[i].machineCode,machineType:rows[i].machineType,jarCode:rows[i].jarCode,alleywayMark:rows[i].alleywayMark});
				}
				//alert(1);
            	$.ajax({ 
		    		type:"post", 
		        	url:"editCheer/delete",		            
		        	contentType:"application/json;charset=UTF-8",               
		        	data:JSON.stringify(infos), 
		        	error:function(result){ 
		        		alert('删除出错！！');
		        		$cheers.bootstrapTable('remove', {
		                	field: 'gunCode',
		                	values: ids
		            	});    	
		        	},
		        	success:function(result){ 
		        		$cheers.bootstrapTable('remove', {
		                	field: 'gunCode',
		                	values: ids
		            	});    	     	                      
		        	}
				});
            }
        });		
		$cheers_add.click(function(){			
			$cheers.bootstrapTable('insertRow', {index: 0, row: {                    
					state:null,
					gunCode: counter,
					machineCode: '',
					machineType: '',					
					jarCode: '',
					alleywayMark:''					
                }});
			counter++;	
		});	
		$cheers_submit.click(function(){			
			var rows=$.map($cheers.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}
			else{
				var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({gunCode:rows[i].gunCode,machineCode:rows[i].machineCode,machineType:rows[i].machineType,jarCode:rows[i].jarCode,alleywayMark:rows[i].alleywayMark});
				}
				$.ajax({ 
			    	type:"post", 
			        url:"editCheer/update", 
			        //dataType:"json",      
			        contentType:"application/json;charset=UTF-8",               
			        data:JSON.stringify(infos), 
			        error:function(result){ 
			        	alert('error: '+result);     	                      
			        },
			        success:function(result){ 
			        	alert('success: '+result);     	                      
			        }
				}); 
			}
		});
		var	$oilcans = $('#oilcans'),
    		$oilcans_add = $('#btn_oilcans_add'),
			$oilcans_remove = $('#btn_oilcans_remove'),	
			$oilcans_edit = $('#btn_oilcans_edit'),
			$oilcans_submit = $('#btn_oilcans_submit');
		//油罐表编辑属性
		$oilcans_edit.click(function(){
			$('#oilcans .editable').editable('toggleDisabled');			
		});
		//油罐表添加空行
		$oilcans_add.click(function(){			
			$oilcans.bootstrapTable('insertRow', {index: 0, row: {                    
					state:null,
					jarCode: counter,
					oilType: '',
					cubage: '',					
					alarmUpperLimit: '',
					alarmLowerLimit:''					
                }});
			counter++;	
		});
		//删除油罐数据行
        $oilcans_remove.click(function () {
            var ids = $.map($oilcans.bootstrapTable('getSelections'), function (row) {
            	//alert(row.gunCode);
                return row.jarCode;
            });
            var rows=$.map($oilcans.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}else{					
           		var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({jarCode:rows[i].jarCode,oilType:rows[i].oilType,cubage:rows[i].cubage,alarmUpperLimit:rows[i].alarmUpperLimit,alarmLowerLimit:rows[i].alarmLowerLimit});
				}
				//alert(1);
            	$.ajax({ 
		    		type:"post", 
		        	url:"editOilcans/delete",		            
		        	contentType:"application/json;charset=UTF-8",               
		        	data:JSON.stringify(infos), 
		        	error:function(result){ 
		        		alert('删除出错！！');
		        		$oilcans.bootstrapTable('remove', {
		                	field: 'jarCode',
		                	values: ids
		            	});    	
		        	},
		        	success:function(result){ 
		        		$oilcans.bootstrapTable('remove', {
		                	field: 'jarCode',
		                	values: ids
		            	});    	     	                      
		        	}
				});
            }
        });
		//确认修改
        $oilcans_submit.click(function(){			
			var rows=$.map($oilcans.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}
			else{
				var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({jarCode:rows[i].jarCode,oilType:rows[i].oilType,cubage:rows[i].cubage,alarmUpperLimit:rows[i].alarmUpperLimit,alarmLowerLimit:rows[i].alarmLowerLimit});
				}
				$.ajax({ 
			    	type:"post", 
			        url:"editOilcans/update", 
			        //dataType:"json",      
			        contentType:"application/json;charset=UTF-8",               
			        data:JSON.stringify(infos), 
			        error:function(result){ 
			        	alert('更新失败');     	                      
			        },
			        success:function(result){ 
			        	alert('更新成功');     	                      
			        }
				}); 
			}
		});
        var	$oiltype = $('#oiltype'),
			$oiltype_add = $('#btn_oiltype_add'),
			$oiltype_remove = $('#btn_oiltype_remove'),	
			$oiltype_edit = $('#btn_oiltype_edit'),
			$oiltype_submit = $('#btn_oiltype_submit');
		//油品表编辑属性
		$oiltype_edit.click(function(){
			$('#oiltype .editable').editable('toggleDisabled');
		});
		//油品表添加空行
		$oiltype_add.click(function(){			
		$oiltype.bootstrapTable('insertRow', {index: 0, row: {                    
				state:null,
				code: counter,
				name: '',
				density: '',					
				unitPrice: '',
				tMemo:''					
            }});
		counter++;	
		});
		//删除油罐数据行
    	$oiltype_remove.click(function () {
        	var ids = $.map($oiltype.bootstrapTable('getSelections'), function (row) {
        		//alert(row.gunCode);
            	return row.code;
        	});
        	var rows=$.map($oiltype.bootstrapTable('getSelections'), function (row) {
            	return row;
        	});
			if(rows.length==0){
				alert('没有选项');				
			}else{					
       			var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({code:rows[i].code,name:rows[i].name,density:rows[i].density,unitPrice:rows[i].unitPrice,tMemo:rows[i].tMemo});
				}
				//alert(1);
        		$.ajax({ 
	    			type:"post", 
	        		url:"editOilType/delete",		            
	        		contentType:"application/json;charset=UTF-8",               
	        		data:JSON.stringify(infos), 
	        		error:function(result){ 
	        			alert('删除出错！！');	        		
	        		},
	        		success:function(result){		        		
	        		}
				});
        		$oiltype.bootstrapTable('remove', {
            		field: 'code',
            		values: ids
        		});    	
        	}
    	});
		//确认修改
    	$oiltype_submit.click(function(){			
			var rows=$.map($oiltype.bootstrapTable('getSelections'), function (row) {
            	return row;
        	});
			if(rows.length==0){
				alert('没有选项');				
			}else{
				var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({code:rows[i].code,name:rows[i].name,density:rows[i].density,unitPrice:rows[i].unitPrice,tMemo:rows[i].tMemo});
				}
				$.ajax({ 
		    		type:"post", 
		        	url:"editOilType/update", 
		        	//dataType:"json",      
		        	contentType:"application/json;charset=UTF-8",               
		        	data:JSON.stringify(infos), 
		        	error:function(result){ 
		        		alert('更新失败');     	                      
		        	},
		        	success:function(result){ 
		        		alert('更新成功');     	                      
		        	}
				}); 
			}
		});
    	var	$cartype = $('#cartype'),
			$cartype_add = $('#btn_cartype_add'),
			$cartype_remove = $('#btn_cartype_remove'),	
			$cartype_edit = $('#btn_cartype_edit'),
			$cartype_submit = $('#btn_cartype_submit');
		//车类型编辑属性
		$cartype_edit.click(function(){
			$('#cartype .editable').editable('toggleDisabled');
		});
		//车类型表添加空行
		$cartype_add.click(function(){			
			$cartype.bootstrapTable('insertRow', {index: 0, row: {                    
				state:null,
				code: counter,
				name: '',				
				classcode:''					
       		}});
			counter++;	
		});
		//删除车类型数据行
    	$cartype_remove.click(function () {
        	var ids = $.map($cartype.bootstrapTable('getSelections'), function (row) {
        		//alert(row.gunCode);
            	return row.code;
        	});
        	var rows=$.map($cartype.bootstrapTable('getSelections'), function (row) {
            	return row;
        	});
			if(rows.length==0){
				alert('没有选项');				
			}else{					
       			var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({code:rows[i].code,name:rows[i].name,classcode:rows[i].classcode});
				}
				//alert(1);
        		$.ajax({ 
	    			type:"post", 
	        		url:"editCarType/delete",		            
	        		contentType:"application/json;charset=UTF-8",               
	        		data:JSON.stringify(infos), 
	        		error:function(result){ 
	        			alert('删除出错！！');	        		
	        		},
	        		success:function(result){		        		
	        		}
				});
        		$cartype.bootstrapTable('remove', {
            		field: 'code',
            		values: ids
        		});    	
        	}
    	});
		//确认修改
    	$cartype_submit.click(function(){			
			var rows=$.map($cartype.bootstrapTable('getSelections'), function (row) {
            	return row;
        	});
			if(rows.length==0){
				alert('没有选项');				
			}else{
				var infos = new Array();
				for(var i=0;i<rows.length;i++){
					infos.push({code:rows[i].code,name:rows[i].name,classcode:rows[i].classcode});
				}
				$.ajax({ 
		    		type:"post", 
		        	url:"editCarType/update", 
		        	//dataType:"json",      
		        	contentType:"application/json;charset=UTF-8",               
		        	data:JSON.stringify(infos), 
		        	error:function(result){ 
		        		alert('更新失败');     	                      
		        	},
		        	success:function(result){ 
		        		alert('更新成功');     	                      
		        	}
				}); 
			}
		});	
});
</script>
</body>
</html>
