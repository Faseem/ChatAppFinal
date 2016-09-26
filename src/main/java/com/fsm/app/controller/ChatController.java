package com.fsm.app.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.plaf.ListUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsm.app.entity.Chat;
import com.fsm.app.entity.User;
import com.fsm.app.service.ChatService;
import com.fsm.app.service.MessagingServices;
import com.fsm.app.service.UserService;


@Controller
public class ChatController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	MessagingServices messagingServices;
	
	@RequestMapping("/chat")
	public String returnChatPage(Model model,Principal principal){
		System.out.println("Getting User");
		List<User> users = userService.findAll();
		System.out.println("geting Current UIser");
		
		String coming=principal.getName();
		User currentUser;
		if(coming.contains("com.fsm.app.entity.User")){
			System.out.println("User Found insdted of name");
			
			UsernamePasswordAuthenticationToken token=(UsernamePasswordAuthenticationToken) principal;
			currentUser=(User)token.getPrincipal();
			
		}else{
			currentUser=userService.findByName(coming);
		}
		
		System.out.println("declear variable");
		List<User> availableUsers=new ArrayList<User>();
		System.out.println("looping");
		for(User user:users){
			System.out.println("inside loop");
			System.out.println(user.getId());
			if(!(user.getId().toString()).equals(currentUser.getId().toString())){
				System.out.println("adding....");
				availableUsers.add(user);
			}
		}
		System.out.println("setting model");
		model.addAttribute("users",availableUsers);
		System.out.println("returning Chat from Controller");
		return "chat";
	}
	
	@RequestMapping("/chat/{id}")
	public String getChatPage(Model model,@PathVariable int id, Principal principal){

		String coming=principal.getName();
		User currentUser;
		if(coming.contains("com.fsm.app.entity.User")){
			UsernamePasswordAuthenticationToken token=(UsernamePasswordAuthenticationToken) principal;
			currentUser=(User)token.getPrincipal();
		}else{
			currentUser=userService.findByName(coming);
		}
		  User userToChatWith=userService.findOne(id);
		  List<Chat> chatsSend=chatService.getChatsSendByUser(userToChatWith);
		  List<Chat> chatsReceived=chatService.getChatsRecievedByUser(userToChatWith);
		  List<Chat> chatNeeded=new ArrayList<Chat>();
		  for(Chat chat: chatsSend){
			  if(chat.getUserRecieved().getId()==(currentUser.getId())){
				  chatNeeded.add(chat);
			  }
		  }
		  for(Chat chat: chatsReceived){
			  if(chat.getUserSend().getId()==(currentUser.getId())){
				  chatNeeded.add(chat);
			  }
		  }
		  
		  Collections.sort(chatNeeded, new Comparator<Chat>() {
			  public int compare(Chat o1, Chat o2) {
			      if (o1.getTime() == null || o2.getTime() == null)
			        return 0;
			      return o1.getTime().compareTo(o2.getTime());
			  }
			});
	
	      model.addAttribute("chatHeading",currentUser.getName()+" Chats with "+userToChatWith.getName());
	      model.addAttribute("chats", chatNeeded);
	      model.addAttribute("userToChatWith",userToChatWith);
	      return "chatPage";
	}
}
