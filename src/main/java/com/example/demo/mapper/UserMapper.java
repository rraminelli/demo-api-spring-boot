package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto toDto(User user);
	
	User toEntity(UserDto userDto);

	List<UserDto> toListDto(List<User> list);
}
