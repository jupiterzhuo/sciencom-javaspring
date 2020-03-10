package com.sciencom.springmvcexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sciencom.springmvcexample.model.Country;
import com.sciencom.springmvcexample.model.Student;
import com.sciencom.springmvcexample.repositories.CountryRepository;
import com.sciencom.springmvcexample.repositories.StudentRepository;

@Controller
public class HomeController {

	@Value("${welcome.message}")
	private String greetingValue;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CountryRepository CountryRepository;
	
	@RequestMapping(value ={"/","/home","/index"}, 
			method = RequestMethod.GET)
	
	public String home(Model model) {
		
		List<Student> listStudent = studentRepository.getAllStudent();
		model.addAttribute("greeting", greetingValue);
		model.addAttribute("listStudent", listStudent);
		return "home";
	}
	
	@RequestMapping(value = "/add-student",
			method =RequestMethod.GET)
	public String addStudent(Model model, Student student) {
		List<Country> listCountries = CountryRepository.getAllCountry();
		model.addAttribute("listCountries", listCountries);
		return "add-student";
	}
	
	@RequestMapping(value = "/add-student",
			method =RequestMethod.POST)
	public String saveStudent(Model model,
			@ModelAttribute("student")Student student) {
		
		Student newStudent =null;
		newStudent=studentRepository.addStudent(student);
		return "redirect:/";
	}
}
