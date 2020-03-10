package com.sciencom.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sciencom.service.MessageService;

@Component
public class Consumer {
	//DI
	//1. Property /Interface
	//2. Constructor
	//3. Setter
	
	@Autowired //Depedency Injection tipe 1
	@Qualifier(value = "sms") //Annotation untuk pilih bean mana yang kita gunakan
	private MessageService messageService;
	
	public void processMessage(String message, String rec) {
		this.messageService.sendMessage(message, rec);
	}
	
}
