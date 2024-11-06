package com.shri.blog_app_apis.services;

import java.util.List;

import com.shri.blog_app_apis.payloads.UserDTO;

public interface UserService {
UserDTO createUser(UserDTO user);
UserDTO updateUser(UserDTO user,Integer userid);
UserDTO getUserById(Integer userid);
List<UserDTO> getAllUser();
void deleteUserById(Integer userid);
}
