package com.derun.action;

import java.util.List;
import com.derun.entity.SysPara;
import org.springframework.ui.ModelMap;
import com.derun.dao.SysTemParameterDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SystemConfigEditor {	
	@Autowired
	private SysTemParameterDAO sysParaDAO; 
	
	@RequestMapping(value="/systemParaManager.htm",method=RequestMethod.GET)
	public String loadConfig(ModelMap config){
		List<SysPara> sysPara=sysParaDAO.findALL();		
		config.put("paras", sysPara.get(0));		
		return "systemParaManager";
	}
	
	@RequestMapping(value="/systemParaManager/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateConfig(SysPara obj){
//		System.out.println("通讯端口"+obj.getMachinePort());
//		System.out.println("受控枪数"+obj.getMachineCount());
//		System.out.println("油罐数:"+obj.getJarCount());
//		System.out.println("时间间隔:"+obj.getTimerInterval());
//		System.out.println("车类型:"+obj.getUseCarType());
//		System.out.println("机动卡:"+obj.getUseEspecialCard());
//		System.out.println("监控模式:"+obj.getInspectModel());
//		System.out.println("上传脱机数据:"+obj.getUseAutoOffLine());
//		System.out.println("下传指标数据:"+obj.getUseAutoGuideLine());
		int result=sysParaDAO.updateOne(obj);
		if(result==1)
			return "success";
		return "failure";	
	}
}
