<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->  
<!doctype html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="js/derun/print.css" rel="stylesheet"type="text/css" media="print"/>

</head>
<body>
<div class="container-fluid">
<div class="cl-mcont">
<div class="row">
<div class="block-flat">
	<div class="header ">
		<center><h3>用户自定义报表</h3></center>
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
<!--		<div class="row">
		<div class="col-md-3">
		<input type="file" name="uploadfilename" value="选择文件"/>
		<input type="button" value="上传文件" onclick="uploadfile();"/>								
		
		<form action="aaa/bbb" method="post" 
         enctype="multipart/form-data">
         <div>file<input name="filname" type="file"/></div>
         <div> <input type="submit" value="提交"/></div>
     </form>
		</div>
	</div>
-->	
	</div>	
</div>
</div>
</div>
</div>
</div>

<script type="text/javascript">
$('#print').click(function(){
	$('#Retain').jqprint({
		debug: false, 
		importCSS: true, 
		printContainer: false, 
		operaSupport: false
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
	$.ajax({
		url:"aaa/bbb",
		type:"post",
		data: new FormData().append("uploadfilename",$("input[name='uploadfilename']")[0].files[0]),
		// 告诉jQuery不要去处理发送的数据 
		processData : false,  
		// 告诉jQuery不要去设置Content-Type请求头 
		contentType : false, 
		success:function(data){
			alert(data);
		},
		error:function(){
			alert("failure");
		}
	});
}
</script>
</body>
</html>