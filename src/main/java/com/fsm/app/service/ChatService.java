package com.fsm.app.service;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.app.entity.Chat;
import com.fsm.app.entity.User;
import com.fsm.app.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	public List<Chat> getChatsSendByUser(User user){
		return chatRepository.findByUserSend(user);
	}
	
	public List<Chat> getChatsRecievedByUser(User user){
		return chatRepository.findByUserRecieved(user);
	}
}
