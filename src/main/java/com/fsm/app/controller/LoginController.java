package com.fsm.app.controller;

import javax.annotation.Resource.AuthenticationType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String getLogin(){
		System.out.println("Returning Login from Controller");
		return "login";
	}
	/*@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (auth != null){    
	    	//SecurityContextHolder.getContext().setAuthentication(null);
	    	auth.setAuthenticated(false);
	    	
	    	if(!auth.isAuthenticated()){
	    		 System.out.println(!auth.isAuthenticated());
	 	        
	    		new SecurityContextLogoutHandler().logout(request, response, auth);
	    	}
	        
	        System.out.println("auth !=null");
	        
	    }else{
	    	
	    	 System.out.println("auth ==null");
	    }
	    
	    return "login";
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}*/
}
