package com.fsm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.app.entity.Chat;
import com.fsm.app.entity.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
	List<Chat> findByUserRecieved(User user);
	List<Chat> findByUserSend(User user);
}
