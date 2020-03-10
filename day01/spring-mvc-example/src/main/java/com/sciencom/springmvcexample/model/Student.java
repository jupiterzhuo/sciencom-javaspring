package com.sciencom.springmvcexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class Student {
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String countryCode;

	
}
