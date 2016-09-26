package com.fsm.app.service;

import org.springframework.stereotype.Service;

@Service
public class JmsMessageListener {
	public String handleMessage(String text) {
		System.out.println("Received: " + text);
		return "ACK from handleMessage";
	}
}
