package com.fsm.app.controller;

import java.security.Principal;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.User;
import com.fsm.app.service.BlogService;
import com.fsm.app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	

	@ModelAttribute
	public Blog constructBLog(){
		return new Blog();
	}
	
	@RequestMapping("/account")
	public String showMyDetails(Model model, Principal principal){
		String name=principal.getName();
		System.out.println("Name is :" +name);
		if(name.contains("com.fsm.app.entity.User")){
			System.out.println("User Found insdted of name");
			
			UsernamePasswordAuthenticationToken token=(UsernamePasswordAuthenticationToken) principal;
			User comingUser=(User)token.getPrincipal();
			name=comingUser.getName();
			System.out.println("Got the name By User is "+name);
		}
		User user=userService.findOneWithAttributes(name);
		model.addAttribute("user", user);
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBLog(Model model,@Valid @ModelAttribute("blog") Blog blog, BindingResult result,Principal principal){
		if(result.hasErrors()){
			return showMyDetails(model, principal);
		}else{
			String usreName=principal.getName();
			
			if(usreName.contains("com.fsm.app.entity.User")){
				UsernamePasswordAuthenticationToken token=(UsernamePasswordAuthenticationToken) principal;
				User comingUser=(User)token.getPrincipal();
				usreName=comingUser.getName();
			}
			
			blogService.save(usreName, blog);
			return "redirect:/account.html";
		}
		
	}
	@RequestMapping(value="/blog/remove/{id}")
	public String deleteBlog(@PathVariable int id){
		Blog blog=blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/user-detail.html";
	}
	
}
