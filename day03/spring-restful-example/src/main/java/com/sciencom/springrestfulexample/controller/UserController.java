package com.sciencom.springrestfulexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

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

import com.sciencom.springrestfulexample.Exception.UserServiceException;
import com.sciencom.springrestfulexample.request.UpdatedUserRequest;
import com.sciencom.springrestfulexample.request.UserRequest;
import com.sciencom.springrestfulexample.response.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	//Colection untuk menampung user response
	Map<String, UserResponse> users;
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUser() {
		if (users!=null) {
			List<UserResponse> lstUser = new ArrayList<>();
			lstUser.addAll(users.values());
			return new ResponseEntity<>(lstUser,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
	
	//localhost:8080/user/2
	//localhost:8080/user/1
	//localhost:8080/user/A0001
	@GetMapping(value = "/{userId}",
			produces={MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
		
//		String myString = null;
//		int myStringLength = myString.length();
		
		if(true) throw new UserServiceException("Error Euy.....");
			
		if(users.containsKey(userId)) {
			return new ResponseEntity<UserResponse>(users.get(userId), HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity<UserResponse>(HttpStatus.NO_CONTENT) ;
		}
		
	}
	// jangan lupa apabila anda ingin menampilkan dalam format XML,
	//sertakan dependency jackson dataformat XML (Silakan dicek pada pom.xml)
	//1.Consumes digunakan untuk menentukan response body, 
	//yaitu boleh XML / Json ( Dimana pada header diberikan key = content-type)
	//2.produces digunaka  untuk hasil output dari rest tsb 
	//yaitu boleh XML / Json ( Dimana pada header diberikan key = accept)
	@PostMapping(consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					},
				 produces =  {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE} 
				)
	public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest userRequest ) {
		
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setEmail(userRequest.getEmail());
		String userId =UUID.randomUUID().toString();
		userResponse.setUserId(userId);
		
		if(users==null) {
			//Inisialisasi object baru
			users = new HashMap<String, UserResponse>();
		}
		//simpan nilai ke collection
		users.put(userId, userResponse);
		
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping(value ="/{userId}",consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			}
	,produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	
	})
	public ResponseEntity<UserResponse> updateUser(
			@PathVariable String userId,
			@Valid @RequestBody UserRequest updatedUserReq) {

				UserResponse storedUserDetail = users.get(userId);
				storedUserDetail.setFirstName(updatedUserReq.getFirstName());
				storedUserDetail.setLastName(updatedUserReq.getLastName());

				users.put(userId, storedUserDetail);
				return new ResponseEntity<UserResponse>(storedUserDetail,HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
