package com.sciencom.springrestfulexample.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//validation gunakan bean validation 2.0 (jsr380)
public class UserRequest {
	@NotNull(message = "FirstName tidak boleh kosong")
	private String firstName;
	@NotNull(message = "LastName tidak boleh kosong")
	private String lastName;
	@NotNull(message = "Email tidak boleh kosong")
	@Email(message = "Format email harus sesuai")
	private String email;
	@NotNull(message = "password tidak boleh kosong")
	@Size(min = 4,max = 10,message = "Password char harus antara 4 sampai dengan 10")
	private String password;
}
