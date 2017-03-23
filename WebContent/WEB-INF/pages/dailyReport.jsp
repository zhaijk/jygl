<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!doctype html>
<html >
<head>
<link href="js/derun/print.css" rel="stylesheet"type="text/css" media="print"/>

</head>
<body>
<div class="container-fluid">
<div class="cl-mcont">
<div class="row">
<div class="block-flat">
	<div class="header ">
		<center><h3>日报表</h3></center>
	</div>	
	<div class="content no-padding">
	<div class="row">
	<div class="col-md-2">
		<input type="button" id="print" class="btn btn-primary btn-block" value="打印预览" />
	</div>
	<div class="col-md-8">	
	<div class="pppp" id="Retain">
	<table  class="table table-hover table-bordered table-condensed display">
		<thead>
		<tr>
			<th>油枪号</th>
			<th>记录条数</th>
			<th>加油量</th>
			<th>油  品</th>										
		</tr>	
		</thead>
		<tbody>
				<tr>
					<td>1</td><td>32</td><td>1123.4L</td><td>93#汽油</td>
				</tr> 
				<tr>
					<td>2</td><td>12</td><td>889.61L</td><td>97#汽油</td>
				</tr> 
				<tr>
					<td>3</td><td>44</td><td>223.45L</td><td>93#汽油</td>
				</tr> 
				<tr>
					<td>4</td><td>7</td><td>142.32L</td><td>0#柴油</td>
				</tr> 
				
				</tbody>		
	</table>
	</div>
	</div>
	</div>
	<div class="row">
	<div class="col-md-2">
		<input type="button" id="print1" class="btn btn-primary btn-block" value="打印预览" />
	</div>
	<div class="col-md-8">	
	<div class="pppp" id="Retain1">
	<table  class="table table-hover table-bordered table-condensed display">
		<thead>
		<tr>
			<th>油枪</th>
			<th>记录条数</th>
			<th>加油量</th>
			<th>油枪号</th>										
		</tr>	
		</thead>
		<tbody>
				<tr>
					<td>93#汽油</td><td>32</td><td>1123.4L</td><td>1,3</td>
				</tr> 
				<tr>
					<td>97#汽油</td><td>12</td><td>889.61L</td><td>3</td>
				</tr> 
				<tr>
					<td>0#柴油</td><td>44</td><td>223.45L</td><td>2</td>
				</tr>							
		</tbody>		
	</table>
	</div>
	</div>
	</div>
	
	
	</div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
$('#print').click(function(){
	$('#Retain').jqprint({
		debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
		importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
		printContainer: false, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
		operaSupport: false//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印
	});
});
$('#print1').click(function(){
	$('#Retain1').jqprint({
		debug: false, 
		importCSS: true,
		printContainer: false,
		operaSupport: false
	});
});
function uploadfile(){
	if($("#uploadfile")[0].files[0]==null){
		alert('select file');
		return ;
	}	
	var formdata=new FormData();
	formdata.append("uploadfilename",$("input[name='uploadfilename']")[0].files[0]);
	$.ajax({
		url:"upload/files",
		type:"post",
		data: formdata,
		processData : false,  
		contentType : false, 
		success:function(data){
			alert(data);
		},
		error:function(xhr){
			alert(xhr);
		}
	});
}
function upload(){
	var formdata=new FormData();
	if($("#uploadfile")[0].files[0]==null){
		alert('select file');
		return ;
	}	
	formdata.append("uploadfilename",$("#uploadfile")[0].files[0]);
	$.ajax({
		url:"upload/files",
		type:"post",
		data: formdata,
		processData : false,  
		contentType : false, 
		success:function(data){
			alert(data);
		},
		error:function(xhr){
			alert(xhr);
		}
	});
}
function downloadfile(){
//	$.ajax({
//		url:"download/cardtrade.xls",
//		type:"get",
//		//data: formdata,
//		processData : false,  
//		contentType : false, 
//		success:function(data){
//			alert(data)
//		},
//		error:function(xhr){
//			alert(xhr);
//		}
//	});

	window.open('download/cardtrade.xls',"_parent","toolbar=no, location=yes, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no");

}
</script>
</body>
</html>
