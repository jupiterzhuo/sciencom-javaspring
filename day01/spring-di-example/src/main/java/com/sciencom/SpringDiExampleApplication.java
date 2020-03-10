package com.sciencom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sciencom.consumer.Consumer;
import com.sciencom.injector.MessageInjector;

@SpringBootApplication
public class SpringDiExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello From Console");
		String message = "Hello From Message Service";
		String email = "jupiterc@gmail.com";
		String mobile = "+6283898986397";
		//Buat Context Untuk file configuration dengan menyebut nama injectornya
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MessageInjector.class);
		//Tentukan bean dengan membaca consumer class,dimana pada DI 
		//class tersebut menggunakan bean mana pada injector class pada(@Qualifier)
		Consumer app = context.getBean(Consumer.class);
		System.out.println(app.toString());
		//Panggil Method
		app.processMessage(message, email);
		//Selesai panggil jangan lupa di close
		context.close();
	}

}
