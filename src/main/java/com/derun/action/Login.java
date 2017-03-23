package com.derun.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.derun.entity.userinfo;

@Controller
public class Login {

//	@Autowired
//	private com.derun.dao.userDAO userDAO; 

	@RequestMapping(value="log_in",method=RequestMethod.POST)
	public String log_in(String j_username,String j_password,HttpServletRequest request){
		System.out.println("username: "+j_username+" password"+j_password);
//		System.out.println(arg.getOperatorcode()+"-"+arg.getOperatorpassword());
//		if(arg.getOperatorcode()==null)
//			return "failure";		
//		userinfo user=userDAO.findByName(arg.getOperatorcode());
//		if(user==null)
//			return "failure";
//		else{
//			if(arg.getOperatorpassword().equals(user.getOperatorpassword()))
//			{	
//				HttpSession sess=request.getSession();
//				sess.setAttribute("user",user.getOperatorcode());
//				sess.setAttribute("password",user.getOperatorpassword());
//				return "monitor.htm";
//			}
//			return "failure";
//		}
		return "forward:monitor.htm";
	}
	@RequestMapping(value="log_in",method=RequestMethod.GET)
	public String login(){
		//System.out.println("username: "+j_username+" password"+j_password);
//		System.out.println(arg.getOperatorcode()+"-"+arg.getOperatorpassword());
//		if(arg.getOperatorcode()==null)
//			return "failure";		
//		userinfo user=userDAO.findByName(arg.getOperatorcode());
//		if(user==null)
//			return "failure";
//		else{
//			if(arg.getOperatorpassword().equals(user.getOperatorpassword()))
//			{	
//				HttpSession sess=request.getSession();
//				sess.setAttribute("user",user.getOperatorcode());
//				sess.setAttribute("password",user.getOperatorpassword());
//				return "monitor.htm";
//			}
//			return "failure";
//		}
		//return "monitor.htm";
		return "/";
	}
	@RequestMapping("logout")
	public String log_out(userinfo arg,HttpServletRequest request){
		
		HttpSession sess=request.getSession();
		sess.removeAttribute("user");
		sess.removeAttribute("password");
		
		return "redirect:/";
	}
	
	@RequestMapping("failure")
	public String log_failure(){
		return "failure";
	}
	//@Secured("ROLE_USER")
	//public String log(String name){
	//	System.out.println(name);
	//	return "monitor.htm";
	//}
} 
