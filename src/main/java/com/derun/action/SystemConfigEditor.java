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
//		System.out.println("ͨѶ�˿�"+obj.getMachinePort());
//		System.out.println("�ܿ�ǹ��"+obj.getMachineCount());
//		System.out.println("�͹���:"+obj.getJarCount());
//		System.out.println("ʱ����:"+obj.getTimerInterval());
//		System.out.println("������:"+obj.getUseCarType());
//		System.out.println("������:"+obj.getUseEspecialCard());
//		System.out.println("���ģʽ:"+obj.getInspectModel());
//		System.out.println("�ϴ��ѻ�����:"+obj.getUseAutoOffLine());
//		System.out.println("�´�ָ������:"+obj.getUseAutoGuideLine());
		int result=sysParaDAO.updateOne(obj);
		if(result==1)
			return "success";
		return "failure";	
	}
}
