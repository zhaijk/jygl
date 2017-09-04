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
	<button id="btn_add" type="button" class="btn   btn-default">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	</button>
	<button id="btn_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	</button>
	<button id="btn_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	</button>	
	<button id="btn_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-ok" aria-hidden="false"></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:90px">用户信息</span>
	</div>
</div>    
<div class="content">
<table class="table table-hover  table-bordered  table-condensed display" data-toggle="table"  id="userinfo">
<thead>
  <tr>
	<th data-field="state" data-checkbox="true"></th>
	<th data-field="user_id">编号</th>
	<th id="1" data-field="user_account" data-editable="false">账号</th>
	<th id="2" data-field="user_name" data-editable="true">用户名</th>
	<th id="3" data-field="user_password" data-editable="true">密码</th>
	<th id="4" data-field="enable" data-editable="false">enable</th>
	<th id="5" data-field="is_system" data-editable="false">系统账户</th>
	<th id="6" data-field="user_description" data-editable="true">备注</th>					
</thead>
<tbody> 
<c:forEach items="${users}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.user_id}</td>
	<td>${value.user_account}</td>
	<td>${value.user_name}</td>
	<td>${value.user_password}</td>
	<td>${value.enable}</td>
	<td>${value.is_system_user}</td>
	<td>${value.user_description}</td>
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
	<button id="role_add" type="button" class="btn   btn-default">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	</button>
	<button id="role_edit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	</button>
	<button id="role_remove" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	</button>		
	<button id="role_submit" type="button" class="btn  btn-default">
		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>确定
	</button>
		<span style="font-size:24px;position:relative;top:6px;left:30%">权限信息</span>
	</div>	
</div>    
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" data-toggle="table"  id="roles">
<thead>
  <tr>
  	<th id="1" data-field="rolestate" data-checkbox="false"></th>
	<th id="2" data-field="id">编号</th>
	<th id="3" data-field="rolename" data-editable="false">名称</th>
	<th id="4" data-field="roleenable" data-editable="false">enable</th>
	<th id="5" data-field="roleis_system" data-editable="false">系统账户</th>
	<th id="6" data-field="roledesc" data-editable="false">备注</th>					
</thead>
<tbody> 
<c:forEach items="${roles}" var="value" varStatus="counter">
<tr>
	<td></td>
	<td>${value.role_id}</td>	
	<td>${value.role_name}</td>	
	<td>${value.enable}</td>
	<td>${value.is_system_role}</td>
	<td>${value.role_description}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
</div>
<!-- 
<div class="row">
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">
	<h3>权限表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >名称</th>
	<th >enable</th>
	<th >系统账户</th>
	<th >备注</th>					
</thead>
<tbody> 
<c:forEach items="${authorities}" var="value" varStatus="counter">
<tr>
	<td>${value.authority_id}</td>
	<td>${value.authority_name}</td>
	<td>${value.enable}</td>
	<td>${value.is_system_user}</td>
	<td>${value.authority_description}</td>
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
	<h3>资源表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >名称</th>
	<th >类型</th>
	<th >权限</th>
	<th >uri</th>
	<th >使能</th>
	<th >是否系统</th>						
	<th >备注</th>
</thead>
<tbody> 
<c:forEach items="${resource}" var="value" varStatus="counter">
<tr>
	<td>${value.resource_id}</td>	
	<td>${value.resource_name}</td>	
	<td>${value.resource_type}</td>
	<td>${value.priority}</td>
	<td>${value.resource_uri}</td>
	<td>${value.enable}</td>
	<td>${value.is_system}</td>
	<td>${value.resource_description}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4 col-md-4">
<div class="block-flat">
<div class="header">
	<h3>用户角色表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >用户序号</th>
	<th >角色序号</th>	
	<th >enable</th>				
</thead>
<tbody> 
<c:forEach items="${user_role}" var="value" varStatus="counter">
<tr>
	<td>${value.ur_id}</td>
	<td>${value.user_id}</td>
	<td>${value.role_id}</td>	
	<td>${value.enable}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
<div class="col-sm-4 col-md-4">
<div class="block-flat">
<div class="header">
	<h3>角色权限表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >角色序号</th>
	<th >权限序号</th>
	<th >使能</th>						
</thead>
<tbody> 
<c:forEach items="${role_authorities}" var="value" varStatus="counter">
<tr>
	<td>${value.ra_id}</td>	
	<td>${value.role_id}</td>	
	<td>${value.authority_id}</td>
	<td>${value.enable}</td>	
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
<div class="col-sm-4 col-md-4">
<div class="block-flat">
<div class="header">
	<h3>权限资源表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >权限序号</th>
	<th >资源序号</th>	
	<th >enable</th>				
</thead>
<tbody> 
<c:forEach items="${auhtority_resourecs}" var="value" varStatus="counter">
<tr>
	<td>${value.ar_id}</td>
	<td>${value.authority_id}</td>
	<td>${value.resource_id}</td>	
	<td>${value.enable}</td>
</tr>
</c:forEach>
</tbody>		
</table>
</div>
</div>
</div>
</div>
</div>
</div>
-->
<script type="text/javascript" 	src="js/jquery.js"></script>
<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>

<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript"  src="js/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
<script type="text/javascript"  src="js/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
<script type="text/javascript" 	src="js/behaviour/general.js"></script>
<script>
	$.fn.editable.defaults.mode ='inline';
	//$('#userinfo .editable').editable('toggleDisabled');  
	var	$table = $('#userinfo'),
    	$add = $('#btn_add'),
		$remove = $('#btn_remove'),	
		$edit = $('#btn_edit'),
		$submit=$('#btn_submit'),
		$role_table = $('#roles'),
    	$role_add = $('#role_add'),
		$role_remove = $('#role_remove'),	
		$role_edit = $('#role_edit');
		$role_submit = $('#role_submit');	
		
	var counter=0;	
    $(function () {
    	$('#userinfo .editable').editable('toggleDisabled');
    	$('#role .editable').editable('toggleDisabled');
        $remove.click(function () {
            var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
            	alert(row.user_id);
                return row.user_id;
            });
            var rows=$.map($table.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}
			else{
            	var userinfos = new Array();
				for(var i=0;i<rows.length;i++){
					userinfos.push({user_id:rows[i].user_id,user_name:rows[i].user_name,user_account:rows[i].user_account,user_password:rows[i].user_password,enable:rows[i].enable,is_system_user:rows[i].is_system_user,user_description:rows[i].user_description});
				}
				alert(1);
            	$.ajax({ 
		    		type:"post", 
		        	url:"editUserInfo/delete",		            
		        	contentType:"application/json;charset=UTF-8",               
		        	data:JSON.stringify(userinfos), 
		        	error:function(result){ 
		        		alert('删除出错！！');     	                      
		        	},
		        	success:function(result){ 
		        		$table.bootstrapTable('remove', {
		                	field: 'user_id',
		                	values: ids
		            	});    	     	                      
		        	}
				});
            }
        });		
		$add.click(function(){			
			$table.bootstrapTable('insertRow', {index: 0, row: {                    
					state:null,
					user_id: counter,
					user_account: '6',
					user_name: '5',					
					user_password: '4',
					enable:'3',					
					is_system: '2',
					user_description: '1'					
                }});
			counter++;	
		});
		$edit.click(function(){
			$('#userinfo .editable').editable('toggleDisabled');   
		});		
		$role_remove.click(function () {
            var ids = $.map($role_table.bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
            $role_table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        });		
		$role_add.click(function(){			
			$role_table.bootstrapTable('insertRow', {index: 0, row: {                    
					rolestate:null,
					id: counter,
                    rolename: '',
					roleenable:'',					
					roleis_system: '',
					roledesc: ''
                }});
			counter++;	
		});
		$role_edit.click(function(){
			$('#roles .editable').editable('toggleDisabled');   
		});
		$submit.click(function(){			
			var rows=$.map($table.bootstrapTable('getSelections'), function (row) {
                return row;
            });
			if(rows.length==0){
				alert('没有选项');				
			}
			else{
				var userinfos = new Array();
				for(var i=0;i<rows.length;i++){
					userinfos.push({user_id:rows[i].user_id,user_name:rows[i].user_name,user_account:rows[i].user_account,user_password:rows[i].user_password,enable:rows[i].enable,is_system_user:rows[i].is_system_user,user_description:rows[i].user_description});
				}
				$.ajax({ 
			    	type:"post", 
			        url:"editUserInfo", 
			        //dataType:"json",      
			        contentType:"application/json;charset=UTF-8",               
			        data:JSON.stringify(userinfos), 
			        error:function(result){ 
			        	alert('error: '+result);     	                      
			        },
			        success:function(result){ 
			        	alert('success: '+result);     	                      
			        }
				}); 
			}
		});
    });
</script>
</body>
</html>
