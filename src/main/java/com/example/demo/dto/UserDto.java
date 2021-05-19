package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Long id;
	
	private String name;
	
	@NotEmpty(message = "Email cannot be null")
	@Email(message = "Email is invalid")
	private String email;
	
	@NotEmpty(message = "Password cannot be null")
	private String password;
	
	
}
