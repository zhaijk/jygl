package com.derun.authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.derun.dao.UsersDAO;

@Service("MyUserDetailService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		Collection<GrantedAuthority>  objLst=new ArrayList<GrantedAuthority>();		
		//取得用户密码
		String strPassword=dao.findByName(arg0);
		//System.out.println("MyUserDetailService: "+arg0+"-"+strPassword);
		//取得用户权限
		objLst=obtionGrantedAuthorities(arg0);
		
		return new User(arg0,strPassword,true,true,true,true,objLst);
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(String arg0){
		
		Set<GrantedAuthority> authSet=new HashSet<GrantedAuthority>();
		List<String> objLst=dao.findRoleByName(arg0);
		for(String obj:objLst){
			//authSet.add(new SimpleGrantedAuthority("ROLE_"+obj));
			//System.out.println(arg0+" "+obj); 
			authSet.add(new SimpleGrantedAuthority(obj));
		}
		return authSet;
		
	}
}
