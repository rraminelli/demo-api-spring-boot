package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.Response;
import com.example.demo.mapper.UserMapper;
import com.example.demo.security.utils.PasswordUtils;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping("/create")
	public ResponseEntity<Response<UserDto>> add(@Valid @RequestBody UserDto userDto, BindingResult result) {
		Response<UserDto> response = new Response<UserDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		userDto.setPassword(PasswordUtils.gerarBCrypt(userDto.getPassword()));
		
		response.setData(
				userMapper.toDto(
						userService.save(userMapper.toEntity(userDto)))
				);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<UserDto>>> listAll() {
		Response<List<UserDto>> response = new Response<List<UserDto>>();

		response.setData(
				userMapper.toListDto(
						userService.listAll()
				));
		return ResponseEntity.ok(response);
	}
	
	
}
