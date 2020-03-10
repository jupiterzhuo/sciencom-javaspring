package com.sciencom.springmvcexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sciencom.springmvcexample.model.Student;
import com.sciencom.springmvcexample.repositories.StudentRepository;

@Controller
public class HomeController {

	@Value("${welcome.message}")
	private String greetingValue;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value ={"/","/home","/index"}, 
			method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Student> listStudent = studentRepository.getAllStudent();
		model.addAttribute("greeting", greetingValue);
		model.addAttribute("listStudent", listStudent);
		return "home";
	}
}
