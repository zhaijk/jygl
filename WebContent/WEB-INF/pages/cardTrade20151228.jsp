<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" />
	<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container-fliud" >`
	<div class="cl-mcont">
	<div class="block-flat">
		<div class="header">
			<center><h3>消费记录查询</h3></center>
		</div>
		<div class="content">
		<div class="row">
		<div class="col-md-11 col-md-offset-1">
		<input style="width:50px" class="switch " type="checkbox" id="check_all" checked data-on-color="success" data-off-color="primary" > 
			卡号: <input type="text" name="cardcode" style="width: 160px; height: 30px; padding: 10px; font-weight: bold" placeholder="请输入卡号" disabled> 
			车号: <input type="text" name="carcode" 	 style="width: 160px; height: 30px; padding: 10px; font-weight: bold" placeholder="请输入车号" disabled> 
			油品: <select name="oiltype" style="width:100px; height:30px;" disabled="disabled" >
					<option value="null">
					<option value="23">93号汽油</option>
					<option value="25">94号汽油</option>
					<option value="26">95号汽油</option>
				</select> 
			枪号: <select name="guncode" style="width:100px; height:30px;" disabled="disabled" >
					<option value="null">
					<option value="1">1号枪</option>
					<option value="2">2号枪</option>
					<option value="3">3号枪</option>
					<option value="4">4号枪</option>
				</select>
		</div>
		</div>
		<div class="row">
		<div class="col-md-12 ">
			<div class="col-md-2 col-md-offset-2">						
			<label  class="checkbox-inline " > <input  type="checkbox" id="check_date" class="icheck" disabled> 日期范围 </label>
			</div>
			<div class="col-md-3 "><div class="col-md-10 col-md-pull-3">
        	<div sstyle="position:absolute;top:5%;left:16%" class=" input-group date datetime " data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control " size="8" type="text" name="date_from" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>从
				<span  class="glyphicon glyphicon-th" >
				</span></span>
			</div>
			</div></div>
			<div class="col-md-3 "><div class="col-md-10 col-md-pull-5">
			<div sstyle="position:absolute;top:5%;left:36%"class="input-group date datetime" data-min-view="2" data-date-format="yyyy-mm-dd">
				<input class="form-control" size="8" type="text" name="to_date" readonly style="text-align:center;font-weight: bold">
				<span  class="input-group-addon btn btn-primary" disabled>至
				<span  class="glyphicon glyphicon-th" >
				</span></span>
			</div>
			</div></div>
			<div  class="col-md-2 col-md-pull-1" sstyle="position:relative;top:5%;left:56%;">
				<input type="button" id="search_submit" class="btn btn-primary  btn-block " value="查 询" />
			</div>
		</div>
		</div>
		<div class="row">
		<div class="table-responsive">
			<table class="table table-hover  table-bordered table-condensed display" id="trades">
				<thead>
				<tr>
					<th >日期 时间</th>
					<th >卡号</th>				 	
				 	<th >记录类型</th>
					<th >油品</th>
					<th >加油量</th>
					<th >消费次数</th>
					<th >入款次数</th>
					<th >卡上余额</th>
				</thead>
				<tbody> 
				<c:forEach items="${trades}" var="value" varStatus="counter">
					<tr>
						<!-- <td>${counter.count}</td> -->
						<td>${value.tradeDate}&nbsp;&nbsp;&nbsp;${value.tradeTime}</td>
						<td>${value.cardCode}</td>
						<td>${value.tradeType}</td>
						<td>${value.oilType}</td>
						<td>${value.volumn}</td>
						<td>${value.mileage}</td>
						<td>${value.sendFlag}</td>
						<td>${value.cardMoney}</td>
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
	<script src="js/jquery.js"></script>	
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.switch/bootstrap-switch.js"></script>
	<!-- <script type="text/javascript" src="js/jquery.datatables/jquery.datatables.min.js"></script> -->
	<script type="text/javascript" src="js/jquery.datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>	
  	<script type="text/javascript">
      	//Add dataTable Functions
      	//toggleSideBar();
      	$(document).ready(function(){
        //initialize the javascript
        //App.init();
        //toggleSideBar();
        //$('#check_allll').bootstrapSwitch();
    	$("#trades").dataTable({
    		//"bJQueryUI":true,
    		"bAutoWidth": false,
    		"bLengthChange" : false,
    		"bSort" :true,
    		"sSearch":true,
    		"bFilter":false,
    		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 2,3,4,7 ] }]  
    	});
    	$('#trades tr').attr('align','center');
    	//$("#trades").dataTable({
    			/* "bLengthChange":false,
    			//"bRetrieve":true,
    			"ajax":"queryCardTrades",
  	    		"columns": [
  	    					{ "data": "tradeDate"},
  	    					{ "data": "tradeTime" },
  	    					{ "data": "cardCode" },
  	    					{ "data": "tradeType" },
  	    					{ "data": "oilType" },
  	    					{ "data": "volumn" },
  	    					{ "data": "mileage" },
  	    					{ "data": "sendFlag" },
  	    					{ "data": "cardMoney" }
  	    				],
  	    		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 0 ] }] 		 */
    		//"bDestroy":true,
			//"bRetrieve":false,
		//	"sSearch":"过滤器",
		//	"ajax":"queryCardTrades",
			//"ajax":"queryALL",
    	/*	"columns": [
    					{ "data": "tradeDate" },
    					{ "data": "tradeTime" },
    					{ "data": "balance" },
    					{ "data": "cardMoney" },
    					{ "data": "tflag" },
    					{ "data": "volumn" },
    					{ "data": "cardCode" },
    					{ "data": "cardType" },
    					{ "data": "mileage" }
    				]
			
    	});*/
    	//$('.dataTables_filter input').addClass('form-control').attr('placeholder','过滤条件');
    	//$('#trades').addClass('table-condensed');
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
    
      	//$('#checkFlag').iCheck('check')=false;
      	//$("#submit").click(function(){
      		//$('#check_date').iCheck('toggle');
      		//$('#check_date:checked').val();
      		//alert($('#check_date:unchecked').val());
      		//var status=$('#check_all').is(":checked");
      		
      		//var status =$('#check-all').is(':checked');
      	//	var status=$('#check_all').is(':checked');//;//;//.bootstrapSwitch(':checked'); //('animate');
      	//	if(status==true)
      	//		alert(status+' hello');
      	//	else
      	//		alert('hello 又过了一年！！！'+status);
      		//alert(status);
      	//	for(var pros in status)
      	//	{
      	//		alert(pros+"="+obj[pros]);	
      	//	}
      	//	
      		//alert($('#check_date').attr('checked','checked'));
      	//});
      	$('#check_all').on('switchChange.bootstrapSwitch', function (event, data) {
      	    if(data==false)
      	    {
      	    	$("[name='cardcode']").attr('disabled',false);
      	    	$("[name='carcode']").attr('disabled',false);
      	    	$("[name='oiltype']").attr('disabled',false);
      	    	$("[name='guncode']").attr('disabled',false);
      	    	$("#check_date").iCheck('enable');
      	    }else{
      	    	$("[name='cardcode']").attr('disabled',true);
      	    	$("[name='carcode']").attr('disabled',true);
      	    	$("[name='oiltype']").attr('disabled',true);
      	    	$("[name='guncode']").attr('disabled',true);
      	    	$("#check_date").iCheck('disable');
      	    	$(".input-group-addon").attr('disabled',true);
      	    }
      	});
      	$('#check_date').on('ifChecked',function(event){
      		$(".input-group-addon").attr('disabled',false);
      	});
      	$('#check_date').on('ifUnchecked',function(event){
      		$(".input-group-addon").attr('disabled',true);
      	});
      	$('#search_submit').click(function(){
      		$('#search_submit').attr('disabled',true);
      		var all=$('#check_all').is(':checked');
      		if(all==true)//全部查询
      		{
      			//alert(1);
      			//$ajax({
      			//	url:"monitor.htm",	
      			//	type: "GET",
      				//dataType:'JSON',
      				//contentType:'application/json',
      			//	success:function(result){
      			//		alert(result);
      					//alert(2);
      			//	}
      			//});
      			//$getJSON("123123123.txt",function(data){
      				//alert(data);
      			//});
      			
      			//$("#trades").load("queryCardTradesBy.txt");
      			//$.get("queryCardTradesBy.txt",function(data){
      			//	$("#trades tbody").html("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      			//});
      			//$ajax({
      			//	url:"querCardTradesBy.txt",
      			//	type:"get",
      			//	dataType:"json",
      			//	success:function(data){
      			//		alert(2);
      			//	},
      			//	error:function(){
      			//		alert(4);
      			//	}
      			//});
      			//$.get("222queryCardTradesBy.txt",function(data){
      				//$("#trades tbody").html("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      			//	alert('s');
      			//});
      			//alert(3);
      			//$getJSON("queryCardTradesBy.txt",function(data){
      			//	alert(4);
      			//});
      			//$.ajax({
            	//	type:'get',
				//	url:'222queryCardTradesBy',
				//	dataType:'jsonp',
            	//	sccuess:function(data){
            	//		alert('good');},
      			//	});	
      			//$("#trades").dataTable().fnDraw(false);		
      			//$.ajax({
      			//	type:"get",
      			////	url:"queryCardTradesBy.txt",      				
      			////	dataType:'json',
      			//	success:function(data){
      					
      					//var table="";
      					//$("#trades tbody").remove();
      					//for(var i=0;i<data.length;i++)      						
      					//{
      					//	table+="<tr>";
      					//	table+="<td>"+(i+1)+"</td>";
      					//	table+="<td>"+data[i]["tradeDate"]+"  "+data[i]["tradeTime"]+"</td>";
      					//	table+="<td>"+data[i]["cardCode"]+"</td>";
      					//	table+="<td>"+data[i]["tradeType"]+"</td>";
      					//	table+="<td>"+data[i]["oilType"]+"</td>";
      					//	table+="<td>"+data[i]["volumn"]+"</td>";
      					//	table+="<td>"+data[i]["mileage"]+"</td>";
      					//	table+="<td>"+data[i]["sendFlag"]+"</td>";
      					//	table+="<td>"+data[i]["cardMoney"]+"</td>";
      					//	table+="</tr>";
      					//}	
      					//alert(table);
      					//$("#trades ").append(table);
      					//$("#trades tbody").html("<tr><td>1</td></tr>");   
      					//$("#trades tbody").html("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      					//$("#trades").dataTable();
      					//alert(1);
      			//		$("#trades").dataTable({
     			//			"bServerSide": true,
     		     //           "sAjaxSource": "Home/AjaxHandler",      //mvc后台ajax调用接口。
     			/*            'bPaginate': true,                      //是否分页。
     		                "bProcessing": true,                    //当datatable获取数据时候是否显示正在处理提示信息。
     		                'bFilter': false,                       //是否使用内置的过滤功能。
     		                'bLengthChange': true,                  //是否允许用户自定义每页显示条数。
     		                'sPaginationType': 'full_numbers',      //分页样式
     		                "aoColumns": [
     		                        { "sName": "ID",
     		                            "bSearchable": false,
     		                            "bSortable": false,
     		                            "fnRender": function (oObj) {
     		                                return '<a href=\"Details/' + oObj.aData[0] + '\">View</a>';
     		                            }                           //自定义列的样式
     		                        },
     		                        { "sName": "COMPANY_NAME" },
     		                        { "sName": "ADDRESS" },
     		                        { "sName": "TOWN" }
     		                    ]
     					});
      				}
      			}); */
      			//$("#trades").fnClearTable(0);
      			//$("#trades").fnDraw();
      		 	/*$.ajax({
      				type:"get",
      				url:"queryCardTradesBy.txt",      				
      				dataType:'json',
      				success:function(data){
      					var table="";
      					$("#trades tbody").remove();
      					for(var i=0;i<data.length;i++)      						
      					{
      						table+="<tr>";
      						table+="<td>"+(i+1)+"</td>";
      						table+="<td>"+data[i]["tradeDate"]+"  "+data[i]["tradeTime"]+"</td>";
      						table+="<td>"+data[i]["cardCode"]+"</td>";
      						table+="<td>"+data[i]["tradeType"]+"</td>";
      						table+="<td>"+data[i]["oilType"]+"</td>";
      						table+="<td>"+data[i]["volumn"]+"</td>";
      						table+="<td>"+data[i]["mileage"]+"</td>";
      						table+="<td>"+data[i]["sendFlag"]+"</td>";
      						table+="<td>"+data[i]["cardMoney"]+"</td>";
      						table+="</tr>";
      					}	
      					//alert(table);
      					$("#trades ").append(table);
      					//$("#trades tbody").html("<tr><td>1</td></tr>");   
      					//$("#trades tbody").html("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      					$("#trades").dataTable();
              		}   
    			});*/
    			//alert(2);
    			//tables.fnClearTable(true);
    			/* $.ajax({
  							"dataType":"json",
  							"type":"GET",
  							"url":"queryCardTrades",
  							"success":function(data){
  								var table="";
  								$("#trades tbody").empty();
  		      					for(var i=0;i<data.length;i++)      						
  		      					{
  		      						table+="<tr>";
  		      						table+="<td>"+(i+1)+"</td>";
  		      						table+="<td>"+data[i]["tradeDate"]+"  "+data[i]["tradeTime"]+"</td>";
  		      						table+="<td>"+data[i]["cardCode"]+"</td>";
  		      						table+="<td>"+data[i]["tradeType"]+"</td>";
  		      						table+="<td>"+data[i]["oilType"]+"</td>";
  		      						table+="<td>"+data[i]["volumn"]+"</td>";
  		      						table+="<td>"+data[i]["mileage"]+"</td>";
  		      						table+="<td>"+data[i]["sendFlag"]+"</td>";
  		      						table+="<td>"+data[i]["cardMoney"]+"</td>";
  		      						table+="</tr>";
  		      					}	
  		      					//alert(table);
  		      				$("#trades tbody").html(table);
  							}
  				}); */
  				//alert(1);
  				$('#search_submit').attr("disabled",true);
      			$("#trades").dataTable({
      					//"bRetrieve":true,
      					//"sServerMethod": "GET",
      					//"bDestory":true,
      					//"bServerSide": true,		//指定从服务器端获取数据		
      					//"sAjaxSource": "queryCardTradesBy",
      				//"bDestroy":true,	
      				//"bDestroy":true,
      				//"bRetrieve":false,
      				//"bFilter":true,
      				//"bAutoWidth": true,
  					"bLengthChange":false,
  					//"processing":true,
  					//"sServerMethod": "GET",
  					//"bDestroy":true,
      				//"bDestroy":true,
      				//"bRetrieve":false,
      				//"bAutoWidth": true,
      	    		//"bLengthChange" : true,
      	    		//"/bSort" :true,
      	    		//"sSearch":true,
      	    		"bFilter":false,
      	    		
  					//"bServerSide": true,		//指定从服务器端获取数据		
  					//"sAjaxSource": "queryALL"
  					"bDestroy":true,
  					"bRetrieve":false,
  					"ajax":"queryCardTrades",
  					//"ajax":"queryALL",
  	  	    		"columns":[
  	  	    					{ "data": "tradeDate" },
  	  	    					{ "data": "tradeTime" },
  	  	    					{ "data": "balance" },
  	  	    					{ "data": "cardMoney" },
  	  	    					{ "data": "tflag" },
  	  	    					{ "data": "volumn" },
  	  	    					{ "data": "cardCode" },
  	  	    					{ "data": "cardType" }
  	  	    		],
  	  	    	"initComplete": function(settings, json) {
  	  	    		$('#search_submit').attr("disabled",false);
  	  	      	}
  					
  					/*"fnServerData":function(arg1,arg2,arg3){
  						$.ajax({
  							"dataType":"json",
  							"type":"GET",
  							"url":arg1,
  							"success":function(data){
  								var table="";
  								//$("#trades tbody").remove();
  		      					for(var i=0;i<data.length;i++)      						
  		      					{
  		      						table+="<tr>";
  		      						table+="<td>"+(i+1)+"</td>";
  		      						table+="<td>"+data[i]["tradeDate"]+"  "+data[i]["tradeTime"]+"</td>";
  		      						table+="<td>"+data[i]["cardCode"]+"</td>";
  		      						table+="<td>"+data[i]["tradeType"]+"</td>";
  		      						table+="<td>"+data[i]["oilType"]+"</td>";
  		      						table+="<td>"+data[i]["volumn"]+"</td>";
  		      						table+="<td>"+data[i]["mileage"]+"</td>";
  		      						table+="<td>"+data[i]["sendFlag"]+"</td>";
  		      						table+="<td>"+data[i]["cardMoney"]+"</td>";
  		      						table+="</tr>";
  		      					}	
  		      					//alert(table);
  		      				$("#trades tbody").html(table);
  							}
  						
  						});  						
  					}*/
  					//""
      	     	});
      			//alert(2);
  				//$('#trades tr').attr('align','center'); 
      			//alert(3);
      			//$.get("queryCardTradesBy.txt",function(data){
      				//$("#trades tbody").html("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      			//	alert('s');
      			//});
      			//alert(5);
      			//$("#trades tbody").html("");
      			//$("#trades").append("<tr><td>zhaijk</td><td>liaojing</td></tr>");
      			
      		}else{//条件查询
      			//alert(1);
      			//$("#trades").fnClearTable(true);
      			//$("#trades tbody").remove();
      			//tables.fnClearTable(true);
      			//tables.
      			$("#trades").dataTable({
      					/* "processing":true,
      					"serverSide":true,
      					"bDestroy":true,
      					"bRetrieve":false,
      					"bAutoWidth": false,
      		    		"bLengthChange" : false,
      		    		"bSort" :true,
      		    		"sSearch":true,
      		    		
      					"bFilter":true,
      					"sAjaxSource": "queryCardTradesBy", */
      					//"bFilter":false，
      					"bFilter":false,
      					"bLengthChange" : false,
      					"bDestroy":true,
      					"bRetrieve":false,
      					"processing":true,
      					"serverSide":true,
      					"ajax":{
      						"url":"queryBoth",
      						"type":"POST"	
      					},
      					//"bDestory":true,
      					//"bServerSide": true,		//指定从服务器端获取数据		
      					//"ajax": "queryCardTradesBy",
      					//"aaData": [  //aaData此属性不能改名，DataTable插件使用就是使用这个属性进行数据表的填充，丫这个属性坑了爹好长时间。
      					/*            [            
      					                "Ge111cko",            
      					                "Firefox 1.0",            
      					                "Win 98+ / OSX.2+"           
      					                  
      					            ]
      					]*/
      					//"sServerMethod": "GET",		
      					//"bProcessing": true,       //加载数据时显示正在加载信息   
      	                //"bServerSide": true
      						"columns": [
      	  	  	    					{ "data": "tradeDate" },
      	  	  	    					{ "data": "balance" },
      	  	  	    					{ "data": "cardMoney" },
      	  	  	    					{ "data": "tflag" },
      	  	  	    					{ "data": "volumn" },
      	  	  	    					{ "data": "cardCode" },
      	  	  	    					{ "data": "cardType" },
      	  	  	    					{ "data": "mileage" }
      	  	  	    		],
      	  	  	    	"initComplete": function(settings, json) {
      	  	  	    		$('#search_submit').attr("disabled",false);
      	  	  	    		console.log(settings+json);
      	  	  	      	}
      	     	});	 
      			//$('#trades tr').attr('align','center');
      			//alert(5);
      			var cardcode=$("[name='cardcode']").val();
      			var carcode=$("[name='carcode']").val();
      			var oiltype=$("[name='oiltype']").val();
      			var guncode=$("[name='guncode']").val();
      			//alert(cardcode+'-'+carcode+'-'+oiltype+'-'+guncode);
      			var dateFlag=$('#check_date').is(':checked');
      			if(dateFlag==true)
      			{
      				var from=$("[name='date_from']").val();
          			var to=$("[name='to_date']").val();
          			alert(from+'-'+to);
      			}
      		}
      		//$('#search_submit').attr('disabled',false);
      	});
    }); 	
    </script>
    <script src="js/bootstrap/dist/js/bootstrap.min.js"></script>    
</body>
</html>
