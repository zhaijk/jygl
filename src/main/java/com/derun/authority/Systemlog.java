package com.derun.authority;

import java.util.Date;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import com.derun.commnuication.logger;
import com.derun.dao.DailyRecordDAO;
//import com.derun.dao.ResourceDAO;
import com.derun.entity.DailyRecord;

//import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.ServletWebRequest;


@Aspect
@Component
public class Systemlog {	
//	@Autowired
//	private  HttpSession session;
	@Autowired
	private  HttpServletRequest request;
//	@Autowired
//	private  HttpServletResponse response;
	
	//@Autowired
	//private  HttpServletResponse response;
	
	@Autowired 
	private DailyRecordDAO logDAO;
//	@Autowired
//	private  ResourceDAO resourceDAO;
	
	private DailyRecord obj=new DailyRecord();;
	private SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat time=new SimpleDateFormat("HH:mm:ss");	
	
	@Pointcut("execution(* com.derun.action.*.*(..))")
	public void pointcut(){}
/*	<!-- <bean id="SytemLogger" class="com.derun.action.Systemlog"/> -->
    <!--   
    <aop:config>  
    	<!--������־��-->
    	<aop:aspect id="logger" ref="Systemlog">
    	<!--������log�������е����ڵ���֮ǰ���ᱻ����-->  
  		<aop:pointcut id="log" expression="execution(* com.derun.action.*.*(..))"/>
        <!--��log���������е�������з���������֮ǰ������MyLog�е�before����-->  
        <aop:before pointcut-ref="log" method="before"/>
        <!--��log���������е�������з���������֮ǰ������MyLog�е�after����-->  
        <aop:after pointcut-ref="log" method="after"/>  
     	</aop:aspect>  
 	 </aop:config>
*/
	@After("pointcut()")
	public void before() throws Throwable {
		
		try{
			obj.setDate(date.format(new Date()));
			obj.setTime(time.format(new Date()));			
			obj.setType(request.getRequestURI());
			//SecurityContextHolder.getContext().getAuthentication().getName();
			obj.setName(request.getUserPrincipal().getName());
			//System.out.println(request.getUserPrincipal().getName());
//			Enumeration<String> objs=session.getAttributeNames();
//			while(objs.hasMoreElements()){
//				String name=objs.nextElement();
//				System.out.println(name+":============="+request.getSession().getAttribute(name));
//			}
			//UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//obj.setName(request.getUserPrincipal().getName());
			//obj.setName(((SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getName());
			obj.setTmemo(request.getRemoteHost());
			//System.out.println(obj.getName()+obj.getType()+obj.getDate()+obj.getTime());
			//String str=obj.getType();
			//logger.debugLog("context:"+str+" result:"+str.contains("htm"));
			if(obj.getType().contains("htm"))
				logDAO.insertOne(obj);
			//System.out.println("request: "+result);
		}catch(Exception e){
			//if(request.getRequestURI()!="")
			//throw new AccessDeniedException("timeout");	
			logger.debugLog("δ��¼");
			//new ServletWebRequest(request).getResponse().sendRedirect("/");
			//;response.sendRedirect("/");
			
		}	
		//pjp.proceed();
	}
}
