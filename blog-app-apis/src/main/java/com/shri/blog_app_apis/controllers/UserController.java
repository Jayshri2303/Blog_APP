package com.shri.blog_app_apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shri.blog_app_apis.payloads.ApiResponse;
import com.shri.blog_app_apis.payloads.UserDTO;
import com.shri.blog_app_apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userdto)
	{
		UserDTO createUserdto=this.userService.createUser(userdto);
		return new ResponseEntity<>(createUserdto,HttpStatus.CREATED);
		
		
	}
	@PutMapping("/{UserId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userdto ,@PathVariable("UserId") Integer UserId)
	{
		UserDTO updatedUser=this.userService.updateUser(userdto, UserId);
		return ResponseEntity.ok(updatedUser);
		
	}
	@DeleteMapping("/{UserId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("UserId") Integer UserId)
	{
		this.userService.deleteUserById(UserId);
		return  new ResponseEntity<ApiResponse>(new ApiResponse("User deleted sucessfully","true"),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUser()
	{
		return new ResponseEntity<List<UserDTO>>(this.userService.getAllUser(),HttpStatus.OK);
	}
	@GetMapping("/{UserId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("UserId") Integer uid)
	{
		return new ResponseEntity<UserDTO>(this.userService.getUserById(uid),HttpStatus.OK);
	}
	

}
