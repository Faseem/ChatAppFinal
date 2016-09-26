package com.fsm.app.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ListningService {
	  @JmsListener(destination="Recv2Send")
	  //@SendTo("RecvToSend")
	  public String processMessage(String text) {
	    System.out.println("Received: " + text);
	    System.out.println("aaaaaaaaaa");
	    return "ACK from handleMessage";
	  }
	  
	  @JmsListener(destination="SendToRecv")
	  @SendTo("RecvToSend")
	  public String processMessages(String text) {
	    System.out.println("Received: " + text);
	    System.out.println("aaaaaaaaaa");
	    return "ACK from handleMessage";
	  }
}
