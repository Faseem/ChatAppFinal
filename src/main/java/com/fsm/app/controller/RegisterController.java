package com.fsm.app.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsm.app.entity.User;
import com.fsm.app.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@ModelAttribute
	public User constructUser(){
		return new User();
	}
	
	@RequestMapping
	public String registerUser(){
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return "register";
		}else{

			userService.save(user); 
			//return "redirect:/register.html?success=true";
			Authentication auth=new UsernamePasswordAuthenticationToken(user, null, getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			return "redirect:/index.html?success=true";
		}
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
        //make everyone ROLE_USER
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            //anonymous inner type
            public String getAuthority() {
                return "ROLE_USER";
            }
        }; 
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username){
		Boolean availableBool = userService.findOne(username)==null;
		return availableBool.toString();
	}
}
