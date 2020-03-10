package com.sciencom.injector;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.sciencom.service.EmailService;
import com.sciencom.service.MessageService;
import com.sciencom.service.SMSService;

@Configuration
@ComponentScan(value = "com.sciencom.consumer")
public class MessageInjector {

	@Bean(name = "email")
	
	public MessageService getEmailService() {
		return new EmailService();
	}
	
	@Bean(name = "sms")
	
	public SMSService getSMSService() {
		return new SMSService();
	}
}
