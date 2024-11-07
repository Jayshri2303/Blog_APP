package com.shri.blog_app_apis.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.blog_app_apis.Repositories.UserRepo;
import com.shri.blog_app_apis.entities.User;
import com.shri.blog_app_apis.exceptions.ResourceNotFoundException;
import com.shri.blog_app_apis.payloads.UserDTO;
import com.shri.blog_app_apis.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public UserDTO createUser(UserDTO user) {
		User savedUser=this.userRepo.save(this.userDtoToUser(user));
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer userid) {
		User user=this.userRepo.findById(userid).
				orElseThrow(()-> new ResourceNotFoundException("User","Id",userid));
				user.setName(userdto.getName());
				user.setPassword(userdto.getPassword());
				user.setEmail(userdto.getEmail());
				user.setAbout(userdto.getAbout());
				User updatedUser= this.userRepo.save(user);
		return this.userToUserDto(updatedUser);
	}

	@Override
	public UserDTO getUserById(Integer userid) {
		User user=this.userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id", userid));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users=this.userRepo.findAll();
		List<UserDTO> userdtos=users.stream()
				.map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void deleteUserById(Integer userid) {
		User user=this.userRepo.findById(userid).
				orElseThrow(()-> new ResourceNotFoundException("User","Id",userid));
		this.userRepo.delete(user);
		
	}
	
	private User userDtoToUser(UserDTO userdto)
	{
		User user=new User();
		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		return user;
	}
	private UserDTO userToUserDto(User user)
	{
		UserDTO userdto=new UserDTO();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setPassword(user.getPassword());
		userdto.setEmail(user.getEmail());
		userdto.setAbout(user.getAbout());
		return userdto;
	}

}
