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
		<center><h3>油位记录表</h3></center>
	</div>	
	<div class="content no-padding">
	<div class="row">
		<div class="col-md-3">
			<input class="switch " type="checkbox" id="check_all" checked data-on-color="success" data-off-color="primary" > 
			罐号: <select name="tankcode" style="width:80px; height:30px;" disabled="disabled" >
					<option value="null">
					<c:forEach items="${tanks}" var="value">
						<option value="${value.jarCode}">${value.jarCode}号罐</option>
					</c:forEach>
					<!-- 
					<option value="23">93号汽油</option>
					<option value="25">94号汽油</option>
					<option value="26">95号汽油</option>
					 -->
				</select>
		</div>		
		<div class="col-md-2">
			<label  class="checkbox-inline " > <input  type="checkbox" id="check_date" class="icheck" disabled>选择日期</label>
		</div>
		<div class="col-md-2">	
        	<div class=" input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control " size="8" type="text" name="date_from" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>从
				<span  class="glyphicon glyphicon-th" >
				</span></span>
			</div>
		</div>
		<div class="col-md-2">
			<div class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control" size="8" type="text" name="to_date" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>至
				<span  class="glyphicon glyphicon-th" >
				</span></span>				
			</div>
		</div>
		<div class="col-md-2">
			<input type="button" id="search_submit" class="btn btn-primary btn-block" value="查 询" />
		</div>
		</div>		
		<div class="row">
		<div class="col-md-12">
		<div class="table-responsive">
			<table class="table table-hover  table-bordered table-condensed display" id="trades">
				<thead>
				<tr>
					<th >日期</th>
					<th >时间</th>
					<th >罐号</th>
				 	<th >油高</th>
					<th >水高</th>
					<th >温度</th>
					<th >油品体积</th>
					<th >油品重量</th>
					<th >罐容积</th>					
				</tr>	
				</thead>
				<tbody> 
				
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
</div>

<script type="text/javascript">
var AllFlag=0;
var FindFlag=0;
$(document).ready(function(){        
    $('.icheck').iCheck({
            checkboxClass: 'icheckbox_square-blue checkbox',
            radioClass: 'iradio_square-blue'
          });
    	$('.switch').bootstrapSwitch({
    		onText: "全部记录",//全部记录",
    	    offText: "条件查询",//条件查询",
    	    size:"normal"
    	});
    	$(".datetime").datetimepicker({
    		autoclose: true//,
    		//dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
    		//monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],
    		//monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二']
    	});
    	$("#trades").dataTable({
    		//"bJQueryUI":true,
    		"bAutoWidth": false,
    		"bLengthChange" : false,
    		"bSort" :true,
    		"sSearch":true,
    		"bFilter":false,
    		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,3,4,5,6,7 ] }]  
    	});
    	$('#trades tr').attr('align','center');
      	$('#check_all').on('switchChange.bootstrapSwitch', function (event, data) {
      	    if(data==false)
      	    {
      	    	$("[name='tankcode']").attr('disabled',false);
      	    	//$("[name='carcode']").attr('disabled',false);
      	    	//$("[name='oiltype']").attr('disabled',false);
      	    	//$("[name='guncode']").attr('disabled',false);
      	    	$("#check_date").iCheck('enable');
      	    }else
      	    {
      	    	$("[name='tankcode']").attr('disabled',true);
      	    	//$("[name='carcode']").attr('disabled',true);
      	    	//$("[name='oiltype']").attr('disabled',true);
      	    	//$("[name='guncode']").attr('disabled',true);
      	    	$("#check_date").iCheck('disable');
      	    	$(".input-group-addon").attr('disabled',true);
      	    }
      	});
      	$('#check_date').on('ifChecked',function(event){
      		$(".input-group-addon").attr('disabled',false);
      		FindFlag=0;
      	});
      	$('#check_date').on('ifUnchecked',function(event){
      		$(".input-group-addon").attr('disabled',true);
      		FindFlag=0;
      	});
      	$("[name='tankcode'],[name='date_from'],[name='to_date']").change(function(){
      		FindFlag=0;//alert(1);
      	});
      	
      	$('#search_submit').click(function(){
      		//$('#search_submit').attr('disabled',true);
      		var all=$('#check_all').is(':checked');
      		if(all==true)//全部查询
      		{      		
      			if(AllFlag==1) return;
      			else AllFlag=1;
      			FindFlag=0;
  				//$('#search_submit').attr("disabled",true);
      			$("#trades").dataTable({      				
  					"bLengthChange":false,  					
      	    		"bFilter":false,
  					"bDestroy":true,
  					"bRetrieve":false,
  					"ajax":"queryOilRecord/queryALL",
  	  	    		"columns":[
  	  	    			{ "data": "collectionDate" },
  	  	    			{ "data": "collectionTime" },
  	  	    			{ "data": "jarCode" },
  	  	    		    { "data": "oilHigh" },  	  	    			
  	  	    			{ "data": "waterHigh" },
  	  	    			{ "data": "temperature" },
  	  	    			{ "data": "oilCubage" },
  	  	    			{ "data": "oilWeight" },
  	  	    			{ "data": "cubage" }
  	  	    		],
  	  	    		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,3,4,5,6,7 ] }] ,
  	  	    		"initComplete": function(settings, json) {
  	  	    			//$('#search_submit').attr("disabled",false);
  	  	    			//$('#trades tr').attr('align','center');
  	  	      		}
      			});  				      			
      		}else{//条件查询
      			var tankcode=$("[name='tankcode']").val();
      			//var carcode=$("[name='carcode']").val();
      			//var oiltype=$("[name='oiltype']").val();
      			//var guncode=$("[name='guncode']").val();
      			var from=$("[name='date_from']").val();
      			var to=$("[name='to_date']").val();
      			var dateFlag=$('#check_date').is(':checked');
      			
      			if(FindFlag==1) 
      				return;
      			else 
      				FindFlag=1;
      			AllFlag=0;      			
      			if(dateFlag==false){
      				from="null";
      				to="null";
      			}
      			$("#trades").dataTable({      					
      				"bFilter":false,
      				"bLengthChange" : false,
      				"bDestroy":true,
      				"bRetrieve":false,
      				"processing":true,
      				"serverSide":true,
      				"ajax":{
      					"url":"queryOilRecord/queryBY",
      					"type":"POST",
      					"data":{tankcode:tankcode,from:from,to:to}
      				},
      				"columns": [
      					{ "data": "collectionDate" },
  	  	    			{ "data": "collectionTime" },
  	  	    			{ "data": "jarCode" },
  	  	    		    { "data": "oilHigh" },  	  	    			
  	  	    			{ "data": "waterHigh" },
  	  	    			{ "data": "temperature" },
  	  	    			{ "data": "oilCubage" },
  	  	    			{ "data": "oilWeight" },
  	  	    			{ "data": "cubage" }
      	  	  	    ],
      	  	  		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 1,3,4,5,6,7 ] }] ,
      	  	  	    "initComplete": function(settings, json) {
      	  	  	    	//$('#search_submit').attr("disabled",false);
      	  	  	  		//$('#trades tr').attr('align','center');
      	  	  	    }
      	     	});
      			//alert(cardcode+'-'+carcode+'-'+oiltype+'-'+guncode);
      			//if(dateFlag==true)
      			//{
      			//	var from=$("[name='date_from']").val();
          		//	var to=$("[name='to_date']").val();
          			//alert(from+'-'+to);
      			//}
      		}      		
      	});
    }); 	
    </script>
    <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
