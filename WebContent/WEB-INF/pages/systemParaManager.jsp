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
<div class="cl-mcont">
<div class="row">
	<div class="col-sm-12 col-md-12">
    <div class="block-flat">
    	<div class="header">							
            <center><h3>系统参数</h3></center>
        </div>
        <div class="content">
        	<form class="form-horizontal" >
              <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">供应单位全称:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  placeholder="${paras.stationBenelux}" readonly>
              	</div>
              </div>
              <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">供应单位编码:</label>
              	<div class="col-sm-7">
                	<input class="form-control"  placeholder="${paras.stationCode}" readonly>
              	</div>
              </div>
              <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">加油站名称:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  placeholder="${paras.stationName}" readonly>
              	</div>
              </div>
              <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">总队控制码:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  placeholder="${paras.amountCortrolCode}" readonly>
              	</div>
              </div>
              <div class="form-group">
              	<label for="inputEmail3" class="col-sm-3 control-label">总部控制码:</label>
              	<div class="col-sm-7">
                	<input  class="form-control"  placeholder="${paras.headQuartersCortrolCode}" readonly>
              	</div>
              </div>
            </form>
        </div>				
      </div>
    </div>
    </div>
    <div class="row">
    <div class="col-sm-6 col-md-6">
    <div class="block-flat">
    	<div class="content">
        	<form class="form-horizontal" >
              	<div class="form-group">
              	<label class="col-md-3 control-label">通讯端口:</label>
              	<div class="col-md-3">
                	<select name="machineport" id="machineport" class="form-control" >
                    	<c:forEach begin="1" end="6" step="1" varStatus="counter">
                    		<option value="${counter.count}">COM${counter.count}</option>
                    	</c:forEach>
                  	</select>
              	</div>
              	</div>
              	<div class="form-group">
              	<label class="col-md-3 control-label">受控枪数:</label>
              	<div class="col-md-3">
                	<select name="machineCount" id="machineCount" class="form-control" >
                    <c:forEach begin="1" end="16" step="1" varStatus="counter">
                    	<option value="${counter.count}">${counter.count}</option>
                    </c:forEach>
                  	</select>
              	</div>
              </div>
              <div class="form-group">
              	<label class="col-md-3 control-label">油罐数:</label>
              	<div class="col-md-3">
                	<select name="jarCount" id="jarCount" class="form-control" >
                    <c:forEach begin="1" end="20" step="1" varStatus="counter">
                    	<option value="${counter.count}">${counter.count}</option>
                    </c:forEach>
                  	</select>
              	</div>
              </div>
              <div class="form-group">
                <label class="col-md-3 control-label">监控间隔:</label>
                <div class="col-md-6">
                  <input type="text" id="timerInterval" class="form-control" placeholder=" 当前值:${paras.timerInterval}         请输入(10-100)秒">                  
                </div>
                <div class="col-md-3">
                	<button type="button" id="submit" style="width:100px" class="btn btn-info ">保存修改</button>
              	</div>
              </div>      
            </form>
        </div>				
      </div>
      </div>
      <div class="col-sm-6 col-md-6" >
    	<div class="block-flat">
    	<div class="content" >
        	<form class="form-horizontal" >
            	<div class="form-group">
                	<label class="col-md-3 control-label">加油监控选项</label>
                <div class="col-md-6">
                  <div class="radio"> 
                    <label> <input type="checkbox"  name="useCarType" id="useCarType" class="icheck" <c:if test="${paras.useCarType==1}">checked</c:if>>使用车型信息</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox"  name="useEspecialCard" id="useEspecialCard" <c:if test="${paras.useEspecialCard==1}">checked</c:if> class="icheck">使用机动卡</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox"  name="inspectModel" id="inspectModel" <c:if test="${paras.inspectModel==1}">checked</c:if> class="icheck">允许监控</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox"  name="useAutoOffLine" id="useAutoOffLine" <c:if test="${paras.useAutoOffLine==1}">checked</c:if> class="icheck">自动上传脱机记录</label> 
                  </div>
                  <div class="radio"> 
                    <label> <input type="checkbox"  name="useAutoGuideLine" id="useAutoGuideLine" <c:if test="${paras.useAutoGuideLine==1}">checked</c:if> class="icheck">自动下传指标记录</label> 
                  </div>                  
                </div>     
              </div>
            </form>
         </div>
         </div>
    </div>          	
    </div>  
    </div>   
	<script type="text/javascript" 	src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.icheck/icheck.min.js"></script>
	<script type="text/javascript"	src="js/bootstrap/dist/js/bootstrap.min.js"></script>	
	<script type="text/javascript"  src="js/bootstrap-table/bootstrap-table.js"></script>
	<script type="text/javascript"	src="js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" 	src="js/behaviour/general.js"></script>
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
	//$("body").css({opacity:0.1,'margin-left':0});
    </script>
        
</body>
</html>
