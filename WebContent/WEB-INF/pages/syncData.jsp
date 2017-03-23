<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>    
<div class="container-fluid">
<div class="cl-mcont">
<div class="row">
<div class="col-md-12">
<div class="block-flat">
	<div class="header">							
    	<center><h3>同步数据</h3></center>
  	</div>
    <div class="content">
    <table class="table table-hover ">   	
	<tr>
		<td>服务器IP</td>		<td  align="center"><input type="text" name="cardcode"/></td>		
		<td>数据库名称</td>		<td  align="center"><input type="text" name="carcode"/></td>			
		<td>用户名</td>		<td  align="center"><input type="text" name="cardtype"/></td>		
		<td>密码</td>	<td  align="center"><input type="text" name="oiltype"/></td>			
	</tr>
	<tr>
		<td>扫描间隔</td> <td  colspan="4" align="center"><input type="text" name="validflag"/></td>
	</tr>		
	<tr>
		<td colspan="2"><button class="btn btn-info btn-block" onclick="readCardInfo();">数据同步下载</button></td>
		<td colspan="3"><button class="btn btn-warning  btn-block" >数据同步上传</button></td>		
		<td colspan="3"><button class="btn btn-danger btn-block">手工同步上传</button></td>
	</tr>
	</table><!-- 
	<OBJECT ID="card" CLASSID="CLSID:89EF5171-7687-434D-B0C9-BF740146E2A9" CODEBASE="iccard.ocx">
	</OBJECT> -->	
</div>
</div>
</div>
</div>
</div>   
<div class="cl-mcont">
<div class="row">
<div class="col-md-12">
<div class="block-flat">
	<div class="header">							
    	<center><h3>同步记录</h3></center>
  	</div>
    <div class="content">
    <table class="table" >
    	<tr>
    		<td>日期</td>
    		<td>时间</td>
    		<td>记录总数</td>
    		<td>同步数</td>    		    		
    	</tr>
	</table>
</div>
</div>
</div>
</div>
</div>  
</div>  
<script>
	$('.icheck').iCheck({
    	checkboxClass: 'icheckbox_square-blue checkbox',
    	radioClass: 'iradio_square-blue'
	});
	$(function(){
			$("#machineport").val('${paras.machinePort}');
			$("#machineCount").val('${paras.machineCount}');
			$("#jarCount").val('${paras.jarCount}');
			//$('#timerInterval').val('${paras.timerInterval}');
	});	
	$('#submit').click(function(){		
		$.ajax({
			url:'systemParaManager/update',
			method:'post',
			data:{	machinePort:$("#machineport").val(),
					machineCount:$("#machineCount").val(),
					jarCount:$("#jarCount").val(),
					timerInterval:($("#timerInterval").val()=="")?'${paras.timerInterval}':$("#timerInterval").val(),
					useCarType:$('#useCarType').is(':checked')==true?1:0,
					useEspecialCard:$('#useEspecialCard').is(':checked')==true?1:0,
					inspectModel:$('#inspectModel').is(':checked')==true?1:0,
					useAutoOffLine:$('#useAutoOffLine').is(':checked')==true?1:0,
					useAutoGuideLine:$('#useAutoGuideLine').is(':checked')==true?1:0
			  	},
			context: document.body,
			success:function(data){
				alert(data);
				//windows.flush();
			},
			error:function(data){
				alert(data);
			}
		});
	});
	function readCardInfo(){
		card.conn();
		$("input[name='cardcode']").val(card.ReadCardInfo(6));
		$("input[name='carcode']").val(card.ReadCardInfo(9));
		$("input[name='cardtype']").val(card.ReadCardInfo(2));
		$("input[name='oiltype']").val(card.ReadCardInfo(11));
		$("input[name='validflag']").val(card.ReadCardInfo(4));
		$("input[name='validdate']").val(card.ReadCardInfo(3));
		$("input[name='sendflag']").val(card.ReadCardInfo(8));
		$("input[name='counter']").val(card.ReadCardInfo(23));
		$("input[name='grayflag']").val(card.ReadCardInfo(5));
		$("input[name='graydate']").val(card.ReadCardInfo(22));
		$("input[name='balance']").val(card.ReadCardInfo(23));
		$("input[name='volumn']").val(card.ReadCardInfo(20));
		$("input[name='codehead']").val(card.ReadCardInfo(26));
		$("input[name='codeteam']").val(card.ReadCardInfo(27));	
		card.Disconn();
	}	
</script>        
</body>
</html>
