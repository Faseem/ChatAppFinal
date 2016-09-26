package com.fsm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Blog;
import com.fsm.app.entity.User;
import com.fsm.app.repository.BlogRepository;
import com.fsm.app.repository.UserRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Blog save(String name, Blog blog){
		User user=userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		return blog;
	}
	
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	} 
}
