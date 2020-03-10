package com.sciencom.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

	@Override
	public void sendMessage(String message, String rec) {
		System.out.println("Email sent to :" + 
				rec + " With message :" + message);
		
	}

}
