<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE html>
<html>
<head>
</head>
<body >
	<div class="container-fluid" id="pcont">
	<div class="stats_bar">
		<div class="butpro butstyle" data-step="2"	>
					<div class="sub">
						<h2>日加油次数</h2>
						<span id="total_clientes">183次</span>
					</div>
					<div class="stat">
						<span class="gt">13,5%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>日加油总量</h2>
						<span>1123.6 L</span>
					</div>
					<div class="stat">
						<span class="up">13,5%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>0# 汽油</h2>
						<span>1225.8 L</span>
					</div>
					<div class="stat">
						<span class="down"> 20,7%</span>
					</div>
				</div>
				<div class="butpro butstyle">
					<div class="sub">
						<h2>存油量</h2>
						<span>28765 L</span>
					</div>
					<div class="stat">
						<span class="equal"></span>
					</div>
				</div>
				
			</div>


			<c:forEach items="${cheersInfo}" var="value" varStatus="counter">
				<div class="col-sm-6 col-md-4 col-lg-3" >
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
													1234.56							
												</td>
											</tr>
										</table>
										
									</a>
								</h4>
							</div>
							<div id="collapse${value.gunID}" class="panel-collapse collapse in">
								<div class="panel-body no-padding">
									<table class="table table-hover">
										<tr>
											<td align="center" colspan="2">
											<button onclick="setonoff(${counter.count})" class="btn btn-danger btn-lg btn-block" 
											        id="status${counter.count}">等待插卡....</button>
											</td>
										</tr>
										<tr>
											<td class="title" id="title1${counter.count}">上次加油</td>
											<td align="center" id="value1${counter.count}">12.34</td>
										<tr>
											<td class="title" id="title2${counter.count}">上次日期</td>
											<td align="center" id="value2${counter.count}">2015-01-01</td>
										</tr>
										<tr>
											<td class="title" id="title3${counter.count}">卡号</td>
											<td align="center" id="value3${counter.count}">720000123456</td>
										</tr>
										<tr>
											<td class="title" id="title4${counter.count}">车辆类型</td>
											<td align="center"><image src="images/bigbus.gif" id="value4${counter.count}"></td>
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
