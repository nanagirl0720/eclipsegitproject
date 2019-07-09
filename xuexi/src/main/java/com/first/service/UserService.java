package com.first.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.first.bean.User;


public interface UserService {

	/*查询用户*/
	public List<User> selectAllUser();
	
	/*更新用户*/
	public void updateUserById(User user);
	
	/*添加用户*/
	public void insertUser(User user);
	
	/*更新用户：先查询*/
	public User selectById(Integer id);
	
	/*删除用户*/
	public void deleteUserById(Integer id);
	
//	分页查询 :使用的是data-jpa机制，查询和分页排序
	public Page<User> findUserByPage(Pageable pageable);
}
