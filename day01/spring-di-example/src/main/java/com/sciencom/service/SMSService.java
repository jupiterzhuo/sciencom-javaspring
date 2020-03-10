package com.sciencom.service;

import org.springframework.stereotype.Service;

@Service
public class SMSService implements MessageService {

	@Override
	public void sendMessage(String message, String rec) {
		System.out.println("SMS sent to :" + 
					rec + " With message :" + message);
		
	}

	

}
