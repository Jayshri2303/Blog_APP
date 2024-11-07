package com.shri.blog_app_apis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shri.blog_app_apis.Repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
    @Test
	public void repoTest()
	{
		System.out.println(this.userRepo.getClass().getName());
		System.out.println(this.userRepo.getClass().getPackageName());
	}
}
