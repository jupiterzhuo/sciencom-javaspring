package com.sciencom.springrestfulexample.request;

import javax.validation.constraints.NotEmpty;
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
public class UpdatedUserRequest {
	@NotNull(message = "FirstName tidak boleh null")
	@NotEmpty(message = "FirstName tidak boleh kosong")
	@Size(min = 2,message = "nama tidak boleh kurang dari 2 char")
	private String firstName;
	@NotNull(message = "LastName tidak boleh kosong")
	private String lastName;
}
