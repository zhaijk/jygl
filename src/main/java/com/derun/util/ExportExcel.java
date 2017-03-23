package com.derun.util;

import java.io.File;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import freemarker.template.Template;
//import com.derun.entity.cardtrade;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class ExportExcel {
	//
	private Configuration config;
	//
	public void init(String path) throws IOException{
		config=new Configuration();
		config.setDefaultEncoding("UTF-8");
		config.setDirectoryForTemplateLoading(new File(path));
	}
	//
	public <E> void process(String filename,List<E> objs,String path,String templateFileName,String outputFileName) throws IOException, TemplateException{

		Map<String,List<E>> map=new HashMap<String,List<E>>();
		map.put("trades", objs);
		Template temp=config.getTemplate(templateFileName);		
		temp.process(map,new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+outputFileName),"utf-8")));
		
	}
	//
//	public static void main(String[] args) throws IOException, TemplateException{
//		
//		//Template template=new Template(null,new StringReader("username:${username}; password:${password}"
//		//		+ " url:${url}"),null);
////		Map map=new HashMap();
////		map.put("username","µÔ½£ï¿" );
////		map.put("password","liaojing" );
////		map.put("url","www.qiandu.com" );
//		//template.process(map, new OutputStreamWriter(System.out));
////		SqlSession session=sqlhelper.getSession();
//////		
////		tradeinfoMapper mapper=session.getMapper(tradeinfoMapper.class);
//////		
////		List<cardtrade> lstObjs=mapper.findALL();
//////		
////		ExportExcel e=new ExportExcel();
////		e.init("");
////		e.process("",lstObjs);
//		
//	}
}
