package com.shri.blog_app_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shri.blog_app_apis.payloads.UserDTO;
import com.shri.blog_app_apis.services.UserService;

@RestController
@RequestMapping("/apis/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto)
	{
		UserDTO createUserdto=this.userService.createUser(userdto);
		return new ResponseEntity<>(createUserdto,HttpStatus.CREATED);
		
		
	}
	

}
