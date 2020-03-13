package com.sciencom.springrestfulexample.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sciencom.springrestfulexample.request.UserRequest;
import com.sciencom.springrestfulexample.response.UserResponse;
import com.sciencom.springrestfulexample.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	Map<String, UserResponse> users;
	
	@Override
	public UserResponse saveUser(UserRequest userRequest) {
		
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
	
		return userResponse;
	}

	@Override
	public List<UserResponse> getAllUser() {
		List<UserResponse> lstUser = new ArrayList<>();
		if (users!=null) {
			lstUser.addAll(users.values());
		}
		return lstUser;
			
	}

}
