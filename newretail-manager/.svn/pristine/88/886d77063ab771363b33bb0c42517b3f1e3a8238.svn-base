/**
 * Project Name:newretail-manager-service
 * File Name:UserAuthenticationServiceImpl.java
 * Package Name:com.newretail.service.impl
 * Date:2017年10月18日下午10:59:57
 * Copyright (c) 2017, campuspp.com All Rights Reserved.
 *
*/

package com.newretail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.mapper.UserAuthenticationTableMapper;
import com.newretail.pojo.UserAuthenticationTable;
import com.newretail.pojo.UserAuthenticationTableExample;
import com.newretail.pojo.UserAuthenticationTableExample.Criteria;
import com.newretail.service.UserAuthenticationService;

/**
 * ClassName:UserAuthenticationServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年10月18日 下午10:59:57 <br/>
 * 
 * @author Yongjie
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("userAuthenticationService")
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	public UserAuthenticationTableMapper userAuthenticationTableMapper;

	/**
	 * 
	 * TODO 返回-1 则出现异常
	 * 
	 * @see com.newretail.service.UserAuthenticationService#getUserAuthenticationStaus(java.lang.String)
	 */
	@Override
	public int getUserAuthenticationStaus(String userID) throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
		Criteria createCriteria = userAuthenticationTableExample.createCriteria();
		createCriteria.andUserIdEqualTo(userID);
		List<UserAuthenticationTable> selectByExample = userAuthenticationTableMapper
				.selectByExample(userAuthenticationTableExample);
		if (selectByExample != null && selectByExample.size() > 0) {
			return selectByExample.get(0).getAuthenticationStatus();
		} else {
			return -1;
		}
	}

	@Override
	public boolean findUserIsAuthentication(String userID) throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
		Criteria createCriteria = userAuthenticationTableExample.createCriteria();
		createCriteria.andUserIdEqualTo(userID);
		List<UserAuthenticationTable> selectByExample = userAuthenticationTableMapper
				.selectByExample(userAuthenticationTableExample);
		if (selectByExample != null && selectByExample.size() > 0)
			if (selectByExample.get(0).getAuthenticationStatus() == 1)
				return true;
		return false;
	}

}
