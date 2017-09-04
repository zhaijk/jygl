<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--[if lt IE 9]>
		<script src="js/html5shiv.js" 	type="text/JavaScript"></script>
		<script src="js/respond.js" 	type="text/JavaScript" ></script>
	<![endif]-->
	<link href="js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link href="js/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
	<!-- <link rel="stylesheet" type="text/css" href="js/bootstrap.switch/bootstrap-switch.css" /> -->
	<!--<link rel="stylesheet" type="text/css" href="js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" /> -->
	<link rel="stylesheet" type="text/css" href="js/jquery.datatables/css/jquery.dataTables.css" />
	<!--<link href="js/jquery.icheck/skins/square/blue.css" rel="stylesheet"> -->
	<link href="css/style.css" rel="stylesheet" />
</head>
<body>    
<div class="container-fluid">
<div class="cl-mcont">
<div class="row">
<div class="col-md-12">
<div class="block-flat">
	<div class="header">							
    	<center><h3>卡信息</h3></center>
  	</div>
    <div class="content">
    <table class="table">   	
	<tr>
		<td>卡号</td>		<td><input type="text" name="cardcode" readonly/></td>		
		<td>车号</td>		<td><input type="text" name="carcode" readonly/></td>			
		<td>卡类型</td>		<td><input type="text" name="cardtype" readonly/></td>		
		<td>油品类型</td>	<td><input type="text" name="oiltype" readonly/></td>			
	</tr>
	<tr>
		<td>卡有效标志</td> <td  align="center"><input type="text" name="validflag" readonly/></td>		
		<td>卡有效期</td>   <td  align="center"><input type="text" name="validdate" readonly/></td>			
		<td>入款次数</td>   <td  align="center"><input type="text" name="sendflag" readonly/></td>		
		<td>消费次数</td>   <td  align="center"><input type="text" name="counter" readonly/></td>			
	</tr>
	<tr>
		<td>记灰标志</td><td  align="center"><input type="text" name="grayflag" readonly/></td>		
		<td>记灰日期</td><td  align="center"><input type="text" name="graydate" readonly/></td>			
		<td>卡上余额</td><td  align="center"><input type="text" name="balance" readonly/></td>		
		<td>加油量</td><td  align="center"><input type="text" name="volumn" value='0.00'/></td>			
	</tr>	
	<tr>
		<td>总部联勤码</td><td colspan="3" align="center"><input type="text" style="width:100%"   name="codehead" readonly/></td>		
		<td>总队联勤码</td><td colspan="3"  align="center"><input type="text"  style="width:100%" name="codeteam" readonly/></td>	
	</tr>	
	<tr>
		<td colspan="2"><button class="btn btn-info btn-block"  onclick="readCardInfo();">读卡</button></td>
		<td colspan="3"><button class="btn btn-info  btn-block" onclick="disablegray()" >解灰</button></td>		
		<td colspan="3"><button class="btn btn-info btn-block"  onclick="makerecord()">断电处理</button></td>
	</tr>
	<tr>
		<td colspan="8">
		<OBJECT ID="card" CLASSID="CLSID:89EF5171-7687-434D-B0C9-BF740146E2A9" CODEBASE="iccard.ocx">		
		</OBJECT></td>
	</tr>	
	</table> 
		
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
    	<center><h3>记灰记录</h3></center>
  	</div>
    <div class="content">
    <table class="table table_hover" id="grayrecord">    	
	<tr>
		<td>日期</td>
		<td>时间</td>
		<td>卡号</td>
		<td>枪号</td>
		<td>油品</td>
		<td>类型</td>
		<td>加油量</td>
		<td>消费次数</td>
		<td>入款次数</td>
		<td>卡上余额</td>
	</tr>				
	</table>
</div>
</div>
</div>
</div>
</div>  
</div>  
	<script type="text/javascript" 	src="js/jquery.js"></script>
	<!-- <script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script> -->
	<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
	<!-- <script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script> -->
	<!-- <script type="text/javascript"	src="js/behaviour/general.js"></script> -->
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
		card.Conn();
		$("input[name='cardcode']").val(card.ReadCardInfo(6));
		value=$("input[name='cardcode']").val();
		if(value=='null'){
			alert('请检查读卡器连接或者卡片');
			return;
		}
		$("input[name='carcode']").val(card.ReadCardInfo(9));
		$("input[name='cardtype']").val(card.ReadCardInfo(2));
		$("input[name='oiltype']").val(card.ReadCardInfo(11));
		$("input[name='validflag']").val(card.ReadCardInfo(4));
		$("input[name='validdate']").val(card.ReadCardInfo(3));
		$("input[name='sendflag']").val(card.ReadCardInfo(8));
		$("input[name='counter']").val(card.ReadCardInfo(23));
		$("input[name='grayflag']").val(card.ReadCardInfo(5));
		$("input[name='graydate']").val(card.ReadCardInfo(22));
		$("input[name='balance']").val(card.ReadCardInfo(21));
		//$("input[name='volumn']").val(card.ReadCardInfo(20));
		$("input[name='volumn']").val('0.0');
		$("input[name='codehead']").val(card.ReadCardInfo(27));
		$("input[name='codeteam']").val(card.ReadCardInfo(26));	
		card.Disconn();		
		var  cardcode=$("input[name='cardcode']").val();
		var  mileage=$("input[name='counter']").val();
		var  grayflag=$("input[name='grayflag']").val();		
		//if((grayflag=='3')||(grayflag=='4')){
		queryGrayTrade(cardcode,mileage);	
		//}else
		//	alert('正常卡');
	}	
	function  readInfo(){
		var  cardcode=$("input[name='cardcode']").val();
		var  mileage=$("input[name='counter']").val();	
		//alert(1);
		queryGrayTrade(cardcode,mileage);
		//alert(2);
	}
	var type=0;
	var balance=0;
	var flag=0; 
	//var cardcode=0;
	var sendflag=0;
	function queryGrayTrade(cardcode,mileage){
		var mileage=String(Number(mileage)+1);
		$.ajax({
			url:'query/graytrade',
			method:'post',
			data:{cardCode:cardcode,mileage:mileage},
			success:function(data){		
				//alert(data);
				$('#grayrecord tr:not(:first)').remove();
				var newRow;
				if(data.tradeDate==null){
					newRow = "<tr style='background:yellow;'><td colspan='10'>没有符合要求的记录</td></tr>";
					flag=0;
				}else{					
					newRow = "<tr style='background:red;'>"+
							  "<td>"+data.tradeDate+"</td>"+
				              "<td>"+data.tradeTime+"</td>"+
				              "<td>"+data.cardCode+"</td>"+
				              "<td>"+data.gunCode+"</td>"+
				              "<td>"+data.oilType+"</td>"+
				              "<td>"+data.tradeType+"</td>"+				             
				              "<td>"+data.volumn+"</td>"+
				              "<td>"+data.mileage+"</td>"+
				              "<td>"+data.sendFlag+"</td>"+				              
				              "<td>"+data.balance+"</td></tr>";				    
				    //cardcode=data.cardCode;
					type=data.tradeType;
					balance=data.balance;
					flag=1;
				}              
				$("#grayrecord tr:last").after(newRow);
			},
			error:function(xhr){
				alert(xhr);
				flag=0;
			}
		});
	}
	function disablegray(){
		//var  st=10;
		var  cardcode=$("input[name='cardcode']").val();
		var  mileage=$("input[name='counter']").val();
		var  sendflag=$("input[name='sendflag']").val();
		var  card_balance=$("input[name='balance']").val();
		var  grayflag=$("input[name='grayflag']").val();
		if(grayflag=='0'){
			alert('不是灰卡');
			return ;
		}
		if(flag==0) {
			alert('没有对应的记灰记录');
			return;
		}
		card.Conn();
		var result=card.ReadCardInfo(6);
		//alert(result+" "+cardcode + " "+mileage+ " "+sendflag+ " "+card_balance);
		if(result!=cardcode){
			alert('请放置要处理的灰卡并读取内容');
			return;
		}		
		if(type=='3'){//入款次数+1
			//sendflag=sendflag+1;
			result=card.WriteCardInfo(8,String(Number(sendflag)+1));
			//alert('入款次数: '+result);
		}
		//消费次数+1
		//mileage=mileage+1;
		result=card.WriteCardInfo(23,String(Number(mileage)+1));
		//alert('消费次数: '+ result)
		//余额计算 减去
		result=card.WriteCardInfo(25,String(Number(parseFloat(balance)*100)));
		//alert('余额：'+ result);
		card.Disconn();
		//修改记录		
		$.ajax({
			url:'disable/gray',
			method:'get',
			data:{cardcode:cardcode,mileage:String(Number(mileage)+1)},
			success:function(data){
				card.Conn();
				//alert(data);
				if(data=='success'){
					//解灰完成					
					result=card.WriteCardInfo(5,'0');
					if(result==1){
						alert('解灰完成');
						readCardInfo();
					}
					
					//st=0;
				}else{//回滚				
					//st=1;
					alert(data+ 'rollback');
					card.WriteCardInfo(8,sendflag);
					card.WriteCardInfo(23,mileage);					
					card.WriteCardInfo(21,card_balance);		
				}
				card.Disconn();
			},
			error:function(xhr){//回滚				
				card.Conn();
				alert(xhr.status+ 'rollback');
				card.WriteCardInfo(8,sendflag);
				card.WriteCardInfo(23,mileage);					
				card.WriteCardInfo(21,card_balance);
				card.Disconn();
			}
		});
		//alert(st);
		//if(st==0){
		//	result=card.WriteCardInfo(5,'0');
		//	alert('解灰: '+result);
		//}else{
		//	alert('rollback '+ status);
		//	card.WriteCardInfo(8,sendflag);
		//	card.WriteCardInfo(23,mileage);					
		//	card.WriteCardInfo(21,card_balance);	
		//}
		
	}
	function makerecord(){		
		var  cardcode=$("input[name='cardcode']").val();
		var  mileage=$("input[name='counter']").val();
		var  sendflag=$("input[name='sendflag']").val();
		var  card_balance=$("input[name='balance']").val();
		var  grayflag=$("input[name='grayflag']").val();
		var  volumn=$("input[name='volumn']").val();
		var  oiltype=$("input[name='oiltype']").val();
		var  tradetype=$("input[name='grayflag']").val();
		var  cardtype=$("input[name='cardtype']").val();		
		if((grayflag=='4')||(grayflag=='3')){
			if(volumn=='0.0'){
				alert('请输入加油量');
				return;
			}
			var v=parseFloat(volumn);
			if(v>900){
				alert('本次加油量:'+v+' 不能大于900');
				return;
			}
			var b=parseFloat(card_balance);			
			if(v>b){
				alert('本次加油量:'+v+' 不能大于卡上余额:'+b);
				return;
			}
			$.ajax({
				url:'query/maketrade',
				method:'post',
				data:{cardCode:cardcode,mileage:String(Number(mileage)+1),balance:card_balance,sendFlag:sendflag,volumn:volumn,oilType:oiltype,tradeType:tradetype,cardType:cardtype},
				success:function(data){				
					$('#grayrecord tr:not(:first)').remove();
					var newRow;
					if(data.tradeDate==null){
						newRow = "<tr style='background:red;'><td colspan='10'>没有符合要求的记录</td></tr>";
						flag=0;
					}else{					
						newRow = "<tr style=\"background:red;\">"+
								  "<td>"+data.tradeDate+"</td>"+
					              "<td>"+data.tradeTime+"</td>"+
					              "<td>"+data.cardCode+"</td>"+
					              "<td>"+data.gunCode+"</td>"+
					              "<td>"+data.oilType+"</td>"+
					              "<td>"+data.tradeType+"</td>"+				             
					              "<td>"+data.volumn+"</td>"+
					              "<td>"+data.mileage+"</td>"+
					              "<td>"+data.sendFlag+"</td>"+				              
					              "<td>"+data.balance+"</td></tr>";				    
					    //cardcode=data.cardCode;
						type=data.tradeType;
						balance=data.balance;
						flag=1;
					}              
					$("#grayrecord tr:last").after(newRow);
				},
				error:function(xhr){
					alert(xhr);
					flag=0;
				}
			});	
		}else{
			alert('不是灰卡');		
		}
	}
</script>        
</body>
</html>
