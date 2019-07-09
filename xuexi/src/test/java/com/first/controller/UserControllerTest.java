package com.first.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.first.bean.User;
import com.first.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest extends UserController {

	@Autowired
	private UserService userService;
	@Test
	public void testSelectAllUserTable() {
		List<User> userList=userService.selectAllUser();
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}

}
