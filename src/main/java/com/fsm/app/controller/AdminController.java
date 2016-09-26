package com.fsm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsm.app.service.BlogService;
import com.fsm.app.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping
	public String getUsers(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/{id}")
	public String getUser(Model model, @PathVariable int id){
		model.addAttribute(userService.findOneWithAttributes(id));
		return "account";
	}
	@RequestMapping(value="/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users.html";
	}
}
