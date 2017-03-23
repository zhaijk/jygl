<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>	
</head>

<body>
<div class="container-fluid" >
<div class="page-head">
		
</div>		
<div class="cl-mcont"> 
<div class="row">
<div class="col-sm-6 col-md-6">
<div class="block-flat">
<div class="header">
	<h3>用户表</h3>
</div>
<div class="content">
<table class="table table-hover  table-bordered table-condensed display" id="trades">
<thead>
  <tr>
	<th >编号</th>
	<th >账号</th>
	<th >用户名</th>
	<th >密码</th>
	<th >enable</th>
	<th >系统账户</th>
	<th >备注</th>					
</thead>
<tbody> 
<c:forEach items="${users}" var="value" varStatus="counter">
<tr>
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
	<h3>角色表</h3>
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
<c:forEach items="${roles}" var="value" varStatus="counter">
<tr>
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
</body>
</html>
