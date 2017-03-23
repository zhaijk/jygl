var  i=0;
function set(){
	i=i+1;		
	var con=printf('%06d',i);
	//document.getElementById("jyl1").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
	//for(var i=1;i<17;i++){
		//var idname=printf('jyl%d',i);
		//$(idname).text(con.substring(0,4)+'.'+con.substring(4,6)); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
	//}
	//$("#jyl1").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl2").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl3").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl4").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl5").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl6").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl7").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl8").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl9").text(con.substring(0,4)+'.'+con.substring(4,6));
	$("#jyl10").text(con.substring(0,4)+'.'+con.substring(4,6));
	
	//document.getElementById("jyl2").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
	//document.getElementById("jyl3").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
	//document.getElementById("jyl4").innerHTML= con.substring(0,4)+'.'+con.substring(4,6); //con.  cocon.subString(0,3)+'.'+con.subString(4,5);
};
function printf(){
var as=[].slice.call(arguments),fmt=as.shift(),i=0;
	return     fmt.replace(/%(\w)?(\d)?([dfsx])/ig,function(_,a,b,c){
      var s=b?new Array(b-0+1).join(a||''):'';
      if(c=='d') s+=parseInt(as[i++]);
      return b?s.slice(b*-1):s;
 });
};
function gettankinfo()
{
	$("#checkPassword").modal('show');
	$("#functionForm").attr("action", "getTanksinfo");
};
function logout()
{
	$("#checkPassword").modal('show');
	$("#functionForm").attr("action", "logout");
};
var config={	
	type: 'GET',
	//data:JSON.stringify({username:'zhaijk',password:'liaojing',rightID:'16776'}),		
	dataType:'JSON',
	contentType:'application/json',
	success:function(result){
	
	//alert();
		for(var i=0,index=0;i<16;i++)
		{	
			index=i+1;
			$("#commstatus"+index).val(result[i]["commStatus"]);
			if(result[i]["status"]=="(开机)")//插卡状态
			{
				//$("#status"+index).
				$("#status"+index).removeClass("disabled");
				//$("#status"+i).addClass("disabled");
				$("#value3"+index).val(result[i]["value3"]);
				$("#jyl"+index).css("color","yellow");
			}
			else if(result[i]["status"]=="加油中 (停止加油)")//加油中...
			{
				$("#status"+index).removeClass("disabled");
				var con=result[i]["value3"];
				con=con.substring(0,4)+'.'+con.substring(4,6);
				$("#jyl"+index).text(con);		
				$("#value4"+index).attr("src",result[i]["value4"]);		
				$("#jyl"+index).css("color","lightgreen");	
			}				
			else//待机状态
			{
				$("#status"+index).addClass("disabled");
				//$("#value3"+index).attr("src",result[i]["value3"]);
				$("#value4"+index).attr("alt",result[i]["value4"]);
				$("#value3"+index).val(result[i]["value3"]);
				$("#jyl"+index).css("color","red");
			}
			$("#status"+index).text(result[i]["status"]);
			
			$("#title1"+index).text(result[i]["item1"]);
			$("#value1"+index).val(result[i]["value1"]);
			$("#title2"+index).text(result[i]["item2"]);
			$("#value2"+index).val(result[i]["value2"]);				
			$("#title3"+index).text(result[i]["item3"]);								
			$("#title4"+index).text(result[i]["item4"]);
			//$("#value4"+index).attr("src",result[i]["value4"]);
			//$("#jyl1").text(result[i]["value1"]);
		}
	}
};	
//var index=0;
function sendInfo(){
	//alert("..");
	//for(var i=0;i<10;i++)
	//{
		config.url="oilgunInfo/0";
		$.ajax(config);
		//index++;
		//if(index>16) index=1;
	//}	
};
var onoffconfig={
	
	type: 'GET',
	//data:JSON.stringify({username:'zhaijk',password:'liaojing',rightID:'16776'}),		
	dataType:'JSON',
	contentType:'application/json',
	success:function(result){
		alert(result);
	}
};
function setonoff(gunid)
{
	onoffconfig.url="setonoff/"+gunid;
	$.ajax(onoffconfig);
};
var getTimer;//=window.setInterval("sendInfo()",10000);
function getinfo(strurl){
	$('#page_content').html("<image src='images/loading.gif'/>");
	$.ajax({
		url:strurl,//"queryCardTrade.htm",
		type:"GET",
		//dataType:'json',
		//data:"page=0&counter=4",  						
		success:function(result){
			//alert(result);
			window.clearInterval(getTimer);
			$('#page_content').html(result);
		},
		error:function(xhr){
			//alert(xhr.status+" "+xhr.statusText);
			alert("没有访问权限");
		}
	});
};
