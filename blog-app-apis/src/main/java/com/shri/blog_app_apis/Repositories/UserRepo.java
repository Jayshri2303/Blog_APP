package com.shri.blog_app_apis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shri.blog_app_apis.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
