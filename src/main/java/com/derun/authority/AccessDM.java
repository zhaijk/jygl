package com.derun.authority;

import java.util.Collection;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.InsufficientAuthenticationException;

@Service("MyAccessDecisionManager")
public class AccessDM implements AccessDecisionManager {

	@Override
	public void decide(Authentication arg0, Object arg1,Collection<ConfigAttribute> arg2) throws AccessDeniedException,
			InsufficientAuthenticationException {
		//System.out.println("MyAccessDecisionManager: \n1: "+ arg1+" \n2:"+arg2);
		if(arg2==null) {
			//System.out.println("MyAccessDecisionManager: arg2=null "+ arg0);
			//throw new AccessDeniedException("no right");
			return;
		}
		//System.out.println("MyAccessDecisionManager: \n1: "+ arg0+" \n2:"+arg2.size());
		for(ConfigAttribute obj1:arg2){
		for(GrantedAuthority obj2:arg0.getAuthorities()){
			//System.out.println("AccessDM: "+obj1.getAttribute()+"-"+obj2.getAuthority());
			if(obj1.getAttribute().equals(obj2.getAuthority())) return; 	
		}}
		throw new AccessDeniedException("no right");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {		
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {		
		return true;
	}

}
