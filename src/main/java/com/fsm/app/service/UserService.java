package com.fsm.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.Item;
import com.fsm.app.entity.Role;
import com.fsm.app.entity.User;
import com.fsm.app.repository.BlogRepository;
import com.fsm.app.repository.ItemRepository;
import com.fsm.app.repository.RoleRepository;
import com.fsm.app.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithAttributes(int id) {
		User user=findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		/*List<Role> roles=roleRepository.findByUser(user);
		user.setRoles(roles);*/
		for (Blog blog : blogs) {
			List<Item> items=itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public User save(User user) {
		
		user.setEnabled(true);
		
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		List<Role>roles=new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
		return user;
	}

	public User findOneWithAttributes(String name) {

		System.out.println("Getting the user");
		User user = userRepository.findByName(name);
		if(user==null){
			return new User();
		}
		return findOneWithAttributes(user.getId());
		
	}

	public void delete(int id) {
		userRepository.delete(id);
		
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public User findOne(String name) {
		return userRepository.findByName(name);
	}
}
