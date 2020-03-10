package com.sciencom.springrestfulexample.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sciencom.springrestfulexample.request.UserRequest;
import com.sciencom.springrestfulexample.response.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	//localhost:8080?page=1&limit=50&sort=desc
	@GetMapping
	public String getAllUser(@RequestParam(value = "page",defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", 
			required = false,defaultValue = "desc") String sort) {
		return "Get All User Page " + page + 
				" and with limit:" + limit + 
				" ,sort type :" + sort;
	}
	
	//localhost:8080/user/2
	//localhost:8080/user/1
	//localhost:8080/user/A0001
	@GetMapping(value = "/{userId}",
			produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName("Jupiter");
		userResponse.setLastName("Zhuo");
		userResponse.setEmail("jupiterc@gmail.com");
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK) ;
	}
	
	
	@PostMapping
	public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest ) {
		
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setEmail(userRequest.getEmail());
		String userId =UUID.randomUUID().toString();
		userResponse.setUserId(userId);
	
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.CREATED);
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user";
	}
}
