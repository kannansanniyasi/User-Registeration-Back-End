package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserEntity;
import com.user.service.UserService;
import com.user.utils.ResponseUtils;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/doGetUser",method=RequestMethod.GET)
	public List<UserEntity> doGetUserList()
	{
		System.out.println("doGetUserList Start");
		return userService.doGetUserList();
	}
	
	@RequestMapping(value="/doSaveUser",method=RequestMethod.POST)
	public ResponseUtils doSaveUser(@RequestBody UserEntity userEntity)
	{
		return userService.doSaveUser(userEntity);
	}
	
	@RequestMapping(value="/doUpdateUser",method=RequestMethod.PUT)
	public ResponseUtils doUpdateUser(@RequestBody UserEntity userEntity)
	{
		return userService.doUpdateUser(userEntity);
	}
	
	@RequestMapping(value="/doDeleteUser",method=RequestMethod.PUT)
	public ResponseUtils doDeleteUser(@RequestParam String id)
	{
		return userService.doDeleteUser(id);
	}
	
	
}
