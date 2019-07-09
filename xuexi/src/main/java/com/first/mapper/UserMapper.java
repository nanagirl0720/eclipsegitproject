package com.first.mapper;


import java.util.List;

import com.first.bean.User;

public interface UserMapper {

	/*查询用户*/
	public List<User> selectAllUser();

	/*增加用户*/
	public void insertUser(User user);
	
	/*更新用户：查询该用户*/
	public User selectById(Integer id);
	/*更新用户：查询后更新*/
	public void updateUserById(User user);
	
	/*删除用户*/
	public void deleteUserById(Integer id);
}
