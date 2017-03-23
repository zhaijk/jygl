<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div class="cl-sidebar " >
<div class="cl-navblock ">
<div class="menu-space ">
<div class="content ">
	<ul class="cl-vnavigation ">
		<li><a href="monitor.htm" ><i class="fa fa-sitemap"></i><span>加油监控模式</span></a></li>
		<!--  <li><a href="monitor.htm" ><i class="fa fa-sitemap"></i><span>加油主控模式</span></a></li>-->
		<li><a href="#"><i class="fa fa-search"></i><span>消费记录操作</span></a>
			<ul class="sub-menu">
				<li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询消费记录</a></li>
				<li><a href="#" onclick="getinfo('queryQuotaRecord.htm')">查询发放记录</a></li>				
				<li><a href="#" onclick="getinfo('queryOilRecord.htm')">查询油位记录</a></li>
				<!-- <li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询卸油记录</a></li> -->
				<li><a href="#" onclick="getinfo('queryOperatorLog.htm')">查询操作日志</a></li>
				<!-- <li><a href="#" onclick="getinfo('queryCardTrade.htm')">查询黑名单</a></li> -->
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-gear"></i><span>设备参数管理</span></a>
			<ul class="sub-menu">
				<li><a href="#" onclick="getinfo('deviceInfoManager.htm')">设备参数</a></li>
				<li><a href="#" onclick="getinfo('systemParaManager.htm')">加油站单位信息</a></li>
				<li><a href="#" onclick="getinfo('userManager.htm')">用户管理</a></li>					
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-gears"></i><span>系统信息管理</span></a>
			<ul class="sub-menu">
				<li><a href= "#" onclick="getinfo('downloadDevicePara.htm')">下传设备参数</a></li>
				<li><a href= "#" onclick="getinfo('blackList.htm')">下传黑名单</a></li>
				<li><a href= "#" onclick="getinfo('quotaList.htm')">下传指标</a></li>				
				<li><a href="#" onclick="getinfo('uploadOffline.htm')">上传脱机记录</a></li>
				<li><a href="#" onclick="getinfo('uploadTrades.htm')">上传卡机记录</a></li>								
			</ul>
		</li>
		<!-- <li><a href="#"><i class="fa fa-exchange"></i><span>设备参数设置</span></a>
			<ul class="sub-menu">
								
			</ul>
		</li>
		 -->
		<li><a href="#"><i class="fa fa-tags"></i><span>卡操作</span></a>
			<ul class="sub-menu">
				<li><a href= "#" onclick="getinfo('cardOperator.htm')">读卡</a></li>				
			</ul>
		</li>		
		<li><a href="#"><i class="fa fa-print"></i><span>报表管理</span></a>
			<ul class="sub-menu">
				<li><a href= "#" onclick="getinfo('dailyReport.htm')">日报</a></li>
				<li><a href= "#" onclick="getinfo('monthlyReport.htm')">月报</a></li>				
				<li><a href= "#" onclick="getinfo('yearlyReport.htm')">年报</a></li>
				<li><a href= "#" onclick="getinfo('report/user.htm')">自定义报</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fa fa-refresh"></i><span>数据同步管理</span></a>
			<ul class="sub-menu">
				<li><a href= "#" onclick="getinfo('syncData.htm')">数据同步</a></li>				
			</ul>
		</li>		
	</ul>
	</div>
	</div>
	<div class="text-right collapse-button" >
		<button id="sidebar-collapse" class="btn btn-default" >
			<i style="color: #fff;" class="fa fa-angle-right"></i>
		</button>
	</div>
</div>
</div>
</body>
</html>