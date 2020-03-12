package com.sciencom.springrestfulexample.service;

import com.sciencom.springrestfulexample.request.UserRequest;
import com.sciencom.springrestfulexample.response.UserResponse;

public interface UserService {
	//Save
	UserResponse saveUser(UserRequest userRequest);
	//ListAll
}
