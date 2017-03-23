package com.derun.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.derun.dao.AuthoritiesDAO;
import com.derun.dao.AuthorityResourceDAO;
import com.derun.dao.ResourceDAO;
import com.derun.dao.RoleAuthorityDAO;
import com.derun.dao.RolesDAO;
import com.derun.dao.User_RoleDAO;
import com.derun.dao.UsersDAO;
import com.derun.entity.Authority;
import com.derun.entity.AuthorityResource;
import com.derun.entity.Resource;
import com.derun.entity.Role_authority;
import com.derun.entity.Roles;
import com.derun.entity.User_Role;
import com.derun.entity.Users;

@Controller
public class UserManager {

	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private RolesDAO rolesDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private ResourceDAO resourceDAO;
	@Autowired
	private User_RoleDAO user_roleDAO;
	@Autowired
	private RoleAuthorityDAO role_authorityDAO;
	@Autowired
	private AuthorityResourceDAO authority_resourceDAO;
	
	@RequestMapping(value="/userManager.htm",method=RequestMethod.GET)
	public String init(ModelMap map){
		List<Users>  users=usersDAO.findAll();
		List<Roles>  roles=rolesDAO.findALL();
		List<Authority>  authorities=authoritiesDAO.findAll();
		List<Resource>  resources=resourceDAO.findAll();
		List<User_Role>  user_role=user_roleDAO.findAll();
		List<Role_authority>  role_authorities=role_authorityDAO.findAll();
		List<AuthorityResource>  auhtority_resourecs=authority_resourceDAO.findAll();
		map.put("users", users);
		map.put("roles", roles);
		map.put("authorities", authorities);
		map.put("resource", resources);
		map.put("user_role", user_role);
		map.put("role_authorities", role_authorities);
		map.put("auhtority_resourecs", auhtority_resourecs);
		return "userManager";
	}	
	
	@RequestMapping(value="/editUserInfo",method=RequestMethod.POST)		
	@ResponseBody 
	public String insertOrUpdateUserInfo(@RequestBody Users[] objs){
//		System.out.println(objs.length);
//		for(Users obj:objs){
//			System.out.println(obj.getUser_name()+" "+obj.getUser_password());
//		}
		
		if(objs.length==0){
			return "failure";
		}else{
			for(Users obj:objs){
				int result=usersDAO.updateOne(obj);
				if(result==0){
					usersDAO.InsertOne(obj);
				}
			}
		}
		return "success";
	}
	@RequestMapping(value="/editUserInfo/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteUserInfo(@RequestBody Users[] objs ){
		if(objs.length==0){
			return "failure";
		}else{
			for(Users obj:objs){
				usersDAO.deleteONE(obj);
			}
		}
		return "success";		
	}
}
