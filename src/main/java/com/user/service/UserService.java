package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.repository.UserRepository;
import com.user.utils.ResponseUtils;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserEntity> doGetUserList() 
	{
		List<UserEntity> userList=new ArrayList<>();
		try
		{
			userList=userRepository.doGetUserList();
		}catch(Exception e)
		{
			System.out.println("Error :"+e.getMessage());
			e.printStackTrace();
		}		
		return userList;		
	}

	public ResponseUtils doSaveUser(UserEntity userEntity) 
	{
		ResponseUtils responseUtils=new ResponseUtils();
		try
		{
			userRepository.save(userEntity);
			responseUtils.setFlg(true);
			responseUtils.setMessage("User Data Saved Successfully");
		}catch(Exception e)
		{
			responseUtils.setMessage("Error :"+e.getMessage());
			System.out.println("Error "+e.getMessage());
		}
		return responseUtils;
		
	}

	public ResponseUtils doUpdateUser(UserEntity userEntity) 
	{
		ResponseUtils responseUtils=new ResponseUtils();
		try
		{
			userRepository.doUpdateUser(userEntity);
			responseUtils.setFlg(true);
			responseUtils.setMessage("User Data Updated Successfully");
		}catch(Exception e)
		{
			responseUtils.setMessage("Error :"+e.getMessage());
			System.out.println("Error "+e.getMessage());
		}
		return responseUtils;
		
	}

	public ResponseUtils doDeleteUser(String id) 
	{
		ResponseUtils responseUtils=new ResponseUtils();
		try
		{
			userRepository.doDeleteUser(Long.parseLong(id));
			responseUtils.setFlg(true);
			responseUtils.setMessage("User Data Deleted Successfully");
		}catch(Exception e)
		{
			responseUtils.setMessage("Error :"+e.getMessage());
			System.out.println("Error "+e.getMessage());
		}
		return responseUtils;
		
	}
}
