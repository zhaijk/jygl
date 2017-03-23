package com.derun.authority;

import java.io.IOException;
//import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

//import com.derun.dao.UsersDAO;

@Service("MyFilterSecurityInterceptor")
public class FilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{

	@Autowired
	private InvocationSecurityMetadataSourceService MyInvocationSecurityMetadataSourceService;
	@Autowired
	private AccessDM MyAccessDecisionManager;
	@Autowired
	//@Qualifier("myAuthenticationManager")//value=authenticationManager)
	private AuthenticationManager myAuthenticationManager;
	
	@PostConstruct
	public void init(){
		super.setAuthenticationManager(myAuthenticationManager);
		super.setAccessDecisionManager(MyAccessDecisionManager);
	}
	
//	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
//		return MyInvocationSecurityMetadataSourceService;
//	}
//
//	public void setSecurityMetadataSource(
//			FilterInvocationSecurityMetadataSource securityMetadataSource) {
//		this.MyInvocationSecurityMetadataSourceService = securityMetadataSource;
//	}

	@Override
	public Class<?> getSecureObjectClass() {
	
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
	
		return this.MyInvocationSecurityMetadataSourceService;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) 
			throws IOException, ServletException {
		//object为FilterInvocation对象
        //super.beforeInvocation(fi);源码
		//1.获取请求资源的权限
		//执行
		//Collection<ConfigAttribute> attributes = ((SecurityMetadataSource) myAuthenticationManager).getAttributes(arg0);		
		//2.是否拥有权限
		//MyAccessDecisionManager.decide(, arg0, attributes);
		
		FilterInvocation fi=new FilterInvocation(arg0,arg1,arg2);
		InterceptorStatusToken token=super.beforeInvocation(fi);
		
		try{
			//fi.getChain().doFilter(arg0, arg1);
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		}finally{
			super.afterInvocation(token, null);
		}
				
	}
	
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {		
//		//super.setAuthenticationManager(myauthenticationManager);
//		//super.setAccessDecisionManager(MyAccessDecisionManager);
//	}
	@Override
	public void destroy() {
		
		
	}
}
