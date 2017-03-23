package com.derun.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.CheerinfoDAO;
import com.derun.dao.SysTemParameterDAO;
import com.derun.entity.SysPara;
import com.derun.entity.cheerMachine;

@Controller
public class DeviceParameterEditor {
	
	@Autowired
	private CheerinfoDAO cheerDAO;
	@Autowired
	private SysTemParameterDAO sysParaDAO; 
	
	@RequestMapping(value="downloadDevicePara.htm",method=RequestMethod.GET)
	public String loadParameter(ModelMap loadConfig){
		List<SysPara> sysPara=sysParaDAO.findALL();
		List<cheerMachine> cheers=cheerDAO.findALL();
		loadConfig.put("paras", sysPara.get(0));
		loadConfig.put("cheers", cheers);
		return "downloadParas";
	}
	@RequestMapping(value="setCheers/all",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setCheers(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}		
		//�´�������
		//�´�ʱ��
		//�´���Ʒ����
		return "1 2 3 4 5 6 7 8 �ſ��� "
				+ "�´�������ɹ��´�ʱ���´���Ʒ����";
	}
	@RequestMapping(value="setCheers/code",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setCode(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}		
		//�´�������		
		return "1 2 3 4 5 6 7 8 �ſ��� "
				+ "�´�������ɹ�";
	}
	@RequestMapping(value="setCheers/clock",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setClock(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		//�´�ϵͳʱ��
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}
	@RequestMapping(value="setCheers/price",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setPrice(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		//�´���Ʒ����
		return "1 2 3 4 5 6 7 8 �ſ��� "
				+ "�´���Ʒ���۳ɹ�";
	}	
	@RequestMapping(value="getCheerClock/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getClock(@PathVariable int id){
		//int id = 0;
		//��ȡ�豸ʱ��
		return id+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	} 
	@RequestMapping(value="getCheerPrice/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getPrice(@PathVariable int id){	
		//int id = 100;
		//��ȡ�豸��Ʒ������
		return id+" 93#����"+"��1.00";
	}
}
