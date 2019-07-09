package com.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.first.bean.User;
import com.first.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> selectAllUser(){
		List<User> userList=userMapper.selectAllUser();
		return userList;
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	@Cacheable(value="",key="#id")
	public User selectById(Integer id) {
		User user=userMapper.selectById(id);
		return user;
	}

	@Override
	public void updateUserById(User user) {
		userMapper.updateUserById(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteUserById(id);		
	}

	
	@Override
	public Page<User> findUserByPage(Pageable pageable) {
		return null;
	}
	
	
	
}
