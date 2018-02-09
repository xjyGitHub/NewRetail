package com.newretail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.mapper.UserPowerTableMapper;
import com.newretail.pojo.UserPowerTable;
import com.newretail.service.UserPowerService;

@Service("userPowerService")
public class UserPowerServiceImpl implements UserPowerService {
	@Autowired
    private UserPowerTableMapper userPowerTableMapper;
	
	@Override
	public UserPowerTable findUser(UserPowerTable user) throws Exception {
		
		return userPowerTableMapper.selectByPrimaryKey(user.getId());
		 
	}

	@Override
	public UserPowerTable updateUserPower(UserPowerTable user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
