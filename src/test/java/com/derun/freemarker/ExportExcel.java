package com.derun.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.OutputStream;
import java.io.OutputStreamWriter;
//import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.derun.dao.sqlhelper;
import com.derun.entity.CardtradeinfoMapper;
import com.derun.entity.cardtrade;
import com.derun.entity.tradeinfoMapper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ExportExcel {
	//
	private Configuration config;
	//
	public void init(String path) throws IOException{
		config=new Configuration();
		config.setDefaultEncoding("UTF-8");
		config.setDirectoryForTemplateLoading(new File("WebContent/WEB-INF/ftl/"));
		
	}
	//
	public <E> void process(String filename,List<cardtrade> objs) throws IOException, TemplateException{

		Map<String,List<cardtrade>> map=new HashMap<String,List<cardtrade>>();
		map.put("trades", objs);
		//map.put("username","002ºÅ³µ" );
		//map.put("password","-10#²ñÓÍ" );
		//map.put("url","100" );
		//Template temp=config.getTemplate("payoutlist.ftl");³ö¿âµ¥2003.xml
		Template temp=config.getTemplate("c.ftl");//³ö¿âµ¥2003.xml
		//OutputStream OutputStream = null;
		temp.process(map,new BufferedWriter(new OutputStreamWriter(new FileOutputStream("WebContent/download/cardtrade.xls"),"utf-8")));
		
	}
	//
	public static void main(String[] args) throws IOException, TemplateException{
		
		//Template template=new Template(null,new StringReader("username:${username}; password:${password}"
		//		+ " url:${url}"),null);
//		Map map=new HashMap();
//		map.put("username","µÔ½£ï¿" );
//		map.put("password","liaojing" );
//		map.put("url","www.qiandu.com" );
		//template.process(map, new OutputStreamWriter(System.out));
		SqlSession session=sqlhelper.getSession();
//		
		tradeinfoMapper mapper=session.getMapper(tradeinfoMapper.class);
//		
		List<cardtrade> lstObjs=mapper.findALL();
//		
		ExportExcel e=new ExportExcel();
		e.init("");
		e.process("",lstObjs);
		
	}
}
