<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!doctype html>
<html >
<head>	
</head>
<body>
<div class="container-fluid">
<div class="cl-mcont">
<div class="row">
<div class="block-flat">
	<div class="header ">
		<center><h3>指标发放表</h3></center>
	</div>	
	<div class="content no-padding">
	<div class="row">
		<div class="col-md-8">
			<input class="switch " type="checkbox" id="check_all" checked data-on-color="success" data-off-color="primary" > 
			卡号: <input type="text" name="cardcode" style="width: 120px; height: 30px; padding: 10px; font-weight: bold" placeholder="请输入卡号" disabled> 
			<!--车号: <input type="text" name="carcode" 	 style="width: 160px; height: 30px; padding: 10px; font-weight: bold" placeholder="请输入车号" disabled> -->
			
			油品: <select name="oiltype" style="width:80px; height:30px;" disabled="disabled" >
					<option value="null">
					<c:forEach items="${oiltype}" var="value">
						<option value="${value.code}">${value.name}</option>
					</c:forEach>
					<!-- 
					<option value="23">93号汽油</option>
					<option value="25">94号汽油</option>
					<option value="26">95号汽油</option>
					 -->
				</select> 
			枪号: <select name="guncode" style="width:80px; height:30px;" disabled="disabled" >
					<option value="255">
					<c:forEach items="${cheers}" var="value">
						<option value="${value.gunCode}">${value.gunCode}号枪</option>
					</c:forEach>
					<!-- 
					<option value="1">1号枪</option>
					<option value="2">2号枪</option>
					<option value="3">3号枪</option>
					<option value="4">4号枪</option>
					 -->
				</select>			
		</div>
		<div class="col-md-2">
			<a href="download/quotatrade.xls" hidden>下载文件</a>
		</div>
		<div class="col-md-2">
			<a href="download/quotatrade.xls"><button class="btn btn-primary btn-block" >导出</button></a>
		</div>
		</div>
		<div class="row">
		<div class="col-md-8 col-md-push-3">
			<div class="col-md-3">
				<label  class="checkbox-inline " > <input  type="checkbox" id="check_date" class="icheck" disabled>选择日期</label>
			</div>
			<div class="col-md-4 col-md-pull-1">	
        	<div class=" input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control " size="8" type="text" name="date_from" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>从
				<span  class="glyphicon glyphicon-th" >
				</span></span>
			</div>
			</div>
			<div class="col-md-4 col-md-pull-1" >
			<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control" size="8" type="text" name="to_date" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>至
				<span  class="glyphicon glyphicon-th" >
				</span></span>				
			</div>
			</div>			
		</div>
		<div class="col-md-2 col-md-push-2">
			<input type="button" id="search_submit" class="btn btn-primary btn-block" value="查 询" />
		</div>		
		<div class="col-md-12">
		<div class="table-responsive">
			<table class="table table-hover  table-bordered table-condensed display" id="quotas">
				<thead>
				<tr>
					<th >日期</th>
					<th >时间</th>
					<th >卡号</th>
					<th>油品</th>
				 	<th >发放次数</th>
					<th >发放量</th>					
				</tr>	
				</thead>
				<tbody> 
				 
				<c:forEach items="${quotas}" var="value" varStatus="counter">
					<tr>
						<td>${value.providedate}</td>
						<td>${value.providetime}</td>
						<td>${value.cardcode}</td>						
						<td>${value.oiltype}</td>
						<td>${value.sendflag}</td>
						<td>${value.guidelinecount }</td>
																								
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
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){        
    $('.icheck').iCheck({
        checkboxClass: 'icheckbox_square-blue checkbox',
    	radioClass: 'iradio_square-blue'
    });
    $('.switch').bootstrapSwitch({
    	onText: "全部记录",
        offText: "条件查询"
    });
    $(".datetime").datetimepicker({
    	autoclose: true//,
    	//dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
    	//monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
    	//monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二']
    });
    $("#quotas").dataTable({
    	//"bJQueryUI":true,
    	"bAutoWidth": false,
    	"bLengthChange" : false,
    	"bSort" :true,
    	"sSearch":true,
    	"bFilter":false,
    	"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,2,3,5 ] }]  
    });
    $('#quotas tr').attr('align','center');
    $('#check_all').on('switchChange.bootstrapSwitch', function (event, data) {
    	if(data==false)
     	{
     		$("[name='cardcode']").attr('disabled',false);
      	    //$("[name='carcode']").attr('disabled',false);
      	    $("[name='oiltype']").attr('disabled',false);
      	    //$("[name='guncode']").attr('disabled',false);
      	    $("#check_date").iCheck('enable');
      	 }else{
      	   	$("[name='cardcode']").attr('disabled',true);
      	    //$("[name='carcode']").attr('disabled',true);
      	    $("[name='oiltype']").attr('disabled',true);
      	    //$("[name='guncode']").attr('disabled',true);
      	    $("#check_date").iCheck('disable');
      	    $(".input-group-addon").attr('disabled',true);
     	}
	});
    $('#check_date').on('ifChecked',function(event){
    	$(".input-group-addon").attr('disabled',false);
      	FINDflag=0;
  	});
    $('#check_date').on('ifUnchecked',function(event){
    	$(".input-group-addon").attr('disabled',true);
    	FINDflag=0;
  	});
    var ALLflag=0;
    var FINDflag=0;
    $("[name='cardcode'],[name='oiltype'],[name='date_from'],[name='to_date']").change(function(){
    	FINDflag=0;//alert(1);
    });
    $('#search_submit').click(function(){
    	//$('#search_submit').attr('disabled',true);
      	var all=$('#check_all').is(':checked');
      	if(all==true){//全部查询
			if(ALLflag==1) return;
      		else ALLflag=1;
      		FINDflag=0;
  			//$('#search_submit').attr("disabled",true);
      		$("#quotas").dataTable({      				
  				"bLengthChange":false,  					
      	    	"bFilter":false,
  				"bDestroy":true,
  				"bRetrieve":false,
  				"ajax":"quota/queryALL",
  	  	    	"columns":[
  	  	    		{ "data": "providedate" },
  	  	    		{ "data": "providetime" },
  	  	    		{ "data": "cardcode" },
  	  	    	    //{ "data": "gunCode" },  	  	    			
  	  	    		{ "data": "oiltype" },
  	  	    		//{ "data": "tradeType" },
  	  	    		
  	  	    		{ "data": "sendflag" },
  	  	    		{ "data": "guidelinecount" }
  	  	    		
  	  	    		//{ "data": "sendFlag" },
  	  	    		//{ "data": "cardMoney" }
  	  	    	],
  	  	    	"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,2,3,5 ] }] ,
  	  	    	"initComplete": function(settings, json) {
  	  	    		//$('#search_submit').attr("disabled",false);
  	  	    		//$('#trades tr').attr('align','center');
  	  	    	}
      		});  				      			
      	}else{//条件查询
      		var cardcode=$("[name='cardcode']").val();
      		//var carcode=$("[name='carcode']").val();
      		var oiltype=$("[name='oiltype']").val();
      		//var guncode=$("[name='guncode']").val();
      		var from=$("[name='date_from']").val();
      		var to=$("[name='to_date']").val();
      		var dateFlag=$('#check_date').is(':checked');
      		
      		if(FINDflag==1) 
      			return;
      		else 
      			FINDflag=1;
      		ALLflag=0;
      		if(dateFlag==false){
      			from="null";
      			to="null";
      		}
      		$("#quotas").dataTable({   
      			"bFilter":false,
      			"bLengthChange" : false,
      			"bDestroy":true,
      			"bRetrieve":false,
      			"processing":true,
      			"serverSide":true,
      			"ajax":{
      				"url":"quota/queryBY",
      				"type":"POST",
      				"data":{cardcode:cardcode,oiltype:oiltype,from:from,to:to}
      			},
      			"columns":[
  	  	    		{ "data": "providedate" },
  	  	    		{ "data": "providetime" },
  	  	    		{ "data": "cardcode" },
  	  	    	    //{ "data": "gunCode" },  	  	    			
  	  	    		{ "data": "oiltype" },
  	  	    			//{ "data": "tradeType" },
  	  	    		{ "data": "sendflag" },
  	  	    		{ "data": "guidelinecount" }
  	  	    		//{ "data": "sendFlag" },
  	  	    		//{ "data": "cardMoney" }
  	  	    	],
      	  		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,2,3,5 ] }] ,
      	  	 	"initComplete": function(settings, json) {
      	  	 	//$('#search_submit').attr("disabled",false);
      	  	  	//$('#trades tr').attr('align','center');
      	  	  	}
			});
      	}      		
	});    
}); 	
function previewANDprint(){
	var cardcode=$("[name='cardcode']").val();
    //var carcode=$("[name='carcode']").val();
    var oiltype=$("[name='oiltype']").val();
    //var guncode=$("[name='guncode']").val();
    var from=$("[name='date_from']").val();
    var to=$("[name='to_date']").val();
    var dateFlag=$('#check_date').is(':checked');
	$.ajax({
		url:"queryQuota/exportBY",
		type:"POST",
		data:{cardcode:cardcode,oiltype:oiltype,from:from,to:to},
		success:function(data){
			alert(data);
		},
		error:function(xhr){
			alert(xhr);
		}	
	});
}
</script>
</body>
</html>
