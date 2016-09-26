package com.fsm.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.Chat;
import com.fsm.app.entity.Item;
import com.fsm.app.entity.Role;
import com.fsm.app.entity.User;
import com.fsm.app.repository.BlogRepository;
import com.fsm.app.repository.ChatRepository;
import com.fsm.app.repository.ItemRepository;
import com.fsm.app.repository.RoleRepository;
import com.fsm.app.repository.UserRepository;

@Transactional
@Service
public class InItDbService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ChatRepository chatRepository;
	
	@Autowired
	MessagingServices messagingServices;
	
	@PostConstruct
	public void init(){
		
		Role adminRole=new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		Role userRole=new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
		
		User adminUser=new User();
		
		User normalUser=new User();
		
		List<Role> adminRoles=new ArrayList<Role>();
		adminRoles.add(adminRole);
		adminRoles.add(userRole);
		
		List<Role> normalUserRole=new ArrayList<Role>();
		normalUserRole.add(userRole);
		
		adminUser.setName("admin");
		adminUser.setRoles(adminRoles);
		adminUser.setEnabled(true);
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
		
		userRepository.save(adminUser);
		
		normalUser.setName("normal");
		normalUser.setRoles(normalUserRole);
		normalUser.setEnabled(true);
		BCryptPasswordEncoder bCryptPasswordEncoderNormal=new BCryptPasswordEncoder();
		normalUser.setPassword(bCryptPasswordEncoderNormal.encode("normal"));
		
		userRepository.save(normalUser);
		
		Blog blog=new Blog();
		blog.setName("JavaVids");
		blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog.setUser(adminUser);
		blogRepository.save(blog);
		
		Item item1 = new Item();
		item1.setBlog(blog);
		item1.setTitle("first");
		item1.setLink("http://javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("second");
		item2.setLink("http://javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		Chat chat1=new Chat();
		chat1.setMessage("Hi there I'm Using Whats app");
		chat1.setTime(new Date());
		chat1.setUserRecieved(normalUser);
		chat1.setUserSend(adminUser);
		
		messagingServices.send(chat1.getMessage());
		
		chatRepository.save(chat1);

		Chat chat2=new Chat();
		chat2.setMessage("Too much of any thing is good for nothing");
		chat2.setTime(new Date());
		chat2.setUserRecieved(adminUser);
		chat2.setUserSend(normalUser);
		
		chatRepository.save(chat2);
		
		Chat chat2a=new Chat();
		chat2a.setMessage("Too much of any thing is good for nothing");
		chat2a.setTime(new Date());
		chat2a.setUserRecieved(adminUser);
		chat2a.setUserSend(normalUser);
		
		chatRepository.save(chat2a);
	
		Chat chat2b=new Chat();
		chat2b.setMessage("Too much of any thing is good for nothing");
		chat2b.setTime(new Date());
		chat2b.setUserRecieved(adminUser);
		chat2b.setUserSend(normalUser);
		
		chatRepository.save(chat2b);
	
		Chat chat2c=new Chat();
		chat2c.setMessage("Too much of any thing is good for nothing");
		chat2c.setTime(new Date());
		chat2c.setUserRecieved(adminUser);
		chat2c.setUserSend(normalUser);
		
		chatRepository.save(chat2c);
	
		Chat chat2d=new Chat();
		chat2d.setMessage("Too much of any thing is good for nothing");
		chat2d.setTime(new Date());
		chat2d.setUserRecieved(adminUser);
		chat2d.setUserSend(normalUser);
		
		chatRepository.save(chat2d);
	
		Chat chat2e=new Chat();
		chat2e.setMessage("Too much of any thing is good for nothing");
		chat2e.setTime(new Date());
		chat2e.setUserRecieved(adminUser);
		chat2e.setUserSend(normalUser);
		
		chatRepository.save(chat2e);
	
		Chat chat2f=new Chat();
		chat2f.setMessage("Too much of any thing is good for nothing");
		chat2f.setTime(new Date());
		chat2f.setUserRecieved(adminUser);
		chat2f.setUserSend(normalUser);
		
		chatRepository.save(chat2f);
	
	
		
		
		Chat chat3=new Chat();
		chat3.setMessage("Peace be opon");
		chat3.setTime(new Date());
		chat3.setUserRecieved(normalUser);
		chat3.setUserSend(adminUser);
		
		chatRepository.save(chat3);
		
		Chat chat4=new Chat();
		chat4.setMessage("Kiddding");
		chat4.setTime(new Date());
		chat4.setUserRecieved(adminUser);
		chat4.setUserSend(normalUser);
		
		chatRepository.save(chat4);
		
		Chat chat5=new Chat();
		chat5.setMessage("Funk you.....");
		chat5.setTime(new Date());
		chat5.setUserRecieved(adminUser);
		chat5.setUserSend(adminUser);
		
		chatRepository.save(chat5);
		
		messagingServices.send(chat2.getMessage());
		
		messagingServices.send(chat3.getMessage());
		
		messagingServices.send(chat4.getMessage());
		
		messagingServices.send(chat5.getMessage());
		



	}
	
}
