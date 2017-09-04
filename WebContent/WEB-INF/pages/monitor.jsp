<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE html>
<html>
<head>
</head> 
<body>
	<div class="container-fluid" >
			<c:forEach items="${cheersInfo}" var="value" varStatus="counter" >
				<div class="col-md-3 ">
					<div class="panel-group accordion" id="accordion2${value.gunID}"> 
						<div class="panel panel-default" >
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion2${value.gunID}" href="#collapse${value.gunID}">										
										<table>
											<tr style="background-color:black">
												<td align="left" style="font-weight:bold;font-size:25px;color:white"><i class="fa fa-angle-right"></i>${value.gunID}号枪</td>
												<td align="right" style="font-weight:bold;font-size:20px;color:yellow">${value.oilType}</td>
											</tr>
											<tr >
												<td id="jyl${counter.count}" colspan="2" align="center"
													style="background-color: black; font-family: Pixel LCD7; font-size: 250%; color: red">
													0000.00							
												</td>
											</tr>											
										</table>										
									</a>
								</h4>
							</div>
							<div id="collapse${value.gunID}" class="panel-collapse collapse in">
								<div class="panel-body no-padding">
									<table>										
										<tr>
											<td colspan="2" ><!-- setonoff(${counter.count}); -->
											<button style="position:relative;left:-5px"onclick="setonoff(${counter.count});" class="btn btn-danger btn-block btn-lg" 
											        id="status${counter.count}">等待插卡....</button>
											</td>
										</tr>
										<tr>
											<td class="title" id="title1${counter.count}">上次加油</td>
											<td align="center" id="value1${counter.count}">00.00</td>
										<tr>
											<td class="title" id="title2${counter.count}">上次日期</td>
											<td align="center" id="value2${counter.count}">0000-00-00</td>
										</tr>
										<tr>
											<td class="title" id="title3${counter.count}">卡号</td>
											<td align="center" id="value3${counter.count}"></td>
										</tr>
										<tr>
											<td class="title"  id="title4${counter.count}">车辆类型</td>
											<td align="center" id="value4${counter.count}"><image src="images/car.gif"></td>
										</tr>
										<tr>
											<td style="font-size:16px;font-weight:bold"align="center" colspan="2" id="commstatus${counter.count}">通讯失败</td>
										</tr>										
										<!-- 
										<tr>
											<td align="center" colspan="2"><image src="images/comm.jpg" style="width:100%;"></td>
										</tr>
										-->
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>
