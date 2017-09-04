package com.derun.authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.derun.commnuication.logger;
import com.derun.dao.ResourceDAO;
import com.derun.entity.Resource;

//import sun.text.normalizer.UnicodeMatcher;

@Service("MyInvocationSecurityMetadataSourceService")
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ResourceDAO   dao;
	private static Map<String,Collection<ConfigAttribute>> resourceMap=null;
	//private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	
	//private UnicodeMatcher urlM=new UnicodeMatcher();
	
	@PostConstruct
	private void loadResourceDefine(){		
		if(resourceMap==null){			
			resourceMap=new HashMap<String ,Collection<ConfigAttribute>>();			
			List<Resource> objLst=dao.findAll();
			//System.out.println("MyInvocationSecurityMetadataSourceService: "+objLst);
			for(Resource obj:objLst){
				logger.debugLog("load Resources");
				List<ConfigAttribute> configAs=new ArrayList<ConfigAttribute>();
				//logger.debugLog(dao.findBy(obj.getResource_uri()));
				//ConfigAttribute  configA=new SecurityConfig("ROLE_"+dao.findBy(obj.getResource_uri()));	
				ConfigAttribute  configA=null;
				try{
					logger.debugLog("uri: "+obj.getResource_uri());
					logger.debugLog("result: "+ dao.findBy(obj.getResource_uri()));
					List<String> objs=dao.findBy(obj.getResource_uri());
					for(String roleName:objs){
						configA=new SecurityConfig(roleName);						
						configAs.add(configA);
					}	
					resourceMap.put(obj.getResource_uri(), configAs);
				}catch(Exception e){
					//e.printStackTrace();
					logger.debugLog("º”‘ÿ◊ ‘¥¥ÌŒÛ");
				}
				
				
				//ConfigAttribute  configA=new SecurityConfig("ROLE_USER");
				//resourceMap.put("/monitor.htm", configAs);
			}
		}
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		
		String  url=((FilterInvocation)arg0).getRequestUrl();
		//System.out.println("url:  "+url);
		//logger.debugLog(url);
		if(resourceMap==null){
			loadResourceDefine();
		}		
		int index=url.indexOf("?");
		if(index>-1){
			url=url.substring(0,index);
		}
		Collection<ConfigAttribute> configAttributes=resourceMap.get(url);
		
		return configAttributes;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		
		return true;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {	 
		
//		//String  url=((FilterInvocation)arg0).getRequestUrl();
//		if(resourceMap==null){
//			loadResourceDefine();
//		}		
//		int index=url.indexOf("?");
//		if(index>-1){
//			url=url.substring(0,index);
//		}
//		Collection<ConfigAttribute> configAttributes=resourceMap.get(url);
//		
////		return configAttributes;
//		if(resourceMap==null){
//			loadResourceDefine();
//		}	
//		Collection<ConfigAttribute> cons=null;
//		List<Resource> objLst=dao.findAll();
//		for(Resource obj:objLst){
//			cons.add((ConfigAttribute) resourceMap.get(obj.getResource_uri()));
//		}
		return null;
	}

}
