/**
 * 
 */
package com.newretail.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.newretail.common.utils.HttpClientUtil;
import com.newretail.common.utils.IdGenerator;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.common.utils.TextUtils;
import com.newretail.mapper.AddressTableMapper;
import com.newretail.mapper.UserAdminTableMapper;
import com.newretail.mapper.UserAuthenticationTableMapper;
import com.newretail.mapper.UserDeliveryTableMapper;
import com.newretail.mapper.UserSellerTableMapper;
import com.newretail.mapper.UserTableMapper;
import com.newretail.pojo.AddressTable;
import com.newretail.pojo.AddressTableExample;
import com.newretail.pojo.UserAdminTable;
import com.newretail.pojo.UserAdminTableExample;
import com.newretail.pojo.UserAuthenticationTable;
import com.newretail.pojo.UserAuthenticationTableExample;
import com.newretail.pojo.UserAuthenticationTableExample.Criteria;
import com.newretail.pojo.UserDeliveryTable;
import com.newretail.pojo.UserDeliveryTableExample;
import com.newretail.pojo.UserSellerTable;
import com.newretail.pojo.UserSellerTableExample;
import com.newretail.pojo.UserTable;
import com.newretail.pojo.UserTableExample;
import com.newretail.service.AddressService;
import com.newretail.service.UserService;

/**
 * 用户登录注册
 * @author Yongjie
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserTableMapper userTableMapper;
	
	@Autowired
	private UserDeliveryTableMapper userDeliveryTableMapper;
	
	@Autowired
	private UserSellerTableMapper userSellerTableMapper;
	
	@Autowired
	private UserAuthenticationTableMapper userAuthenticationTableMapper;
	
	@Autowired
	private UserAdminTableMapper userAdminTableMapper;

	@Autowired
	private AddressTableMapper addressTableMapper;
	
	@Autowired
	private AddressService addressService;

	@Value("${SSO_BASE_URL}")
	public  String SSO_BASE_URL;

	@Value("${SSO_USER_TOKEN}")
	public  String SSO_USER_TOKEN;

	@Override
	public int addUser(UserTable user) throws Exception {
		user.setId(IdGenerator.getId());
		return userTableMapper.insertSelective(user);
	}

	//出现一个添加失败则所有都失败
	@Override
	public int addUser(UserTable user, UserSellerTable userSeller, UserAuthenticationTable userAuthentication)
			throws Exception {
		user.setId(IdGenerator.getId());
		int status = userTableMapper.insertSelective(user);
		if(status<0) {
			throw new Exception("添加用户失败，用户信息可能有误"); 	
		}
		userSeller.setId(IdGenerator.getId());
		int status2 = userSellerTableMapper.insertSelective(userSeller);
		if(status2<0) {
			throw new Exception("添加用户失败,商户添加失败"); 	
			
		}
		userAuthentication.setId(IdGenerator.getId());
		int status3 = userAuthenticationTableMapper.insertSelective(userAuthentication);
		if(status3<0) {
			throw new Exception("添加用户失败,提交认证失败"); 
		}
		return 1;
	}

	@Override
	public int addUserAuthentication(UserAuthenticationTable userAuthentucation) throws Exception {
		userAuthentucation.setId(IdGenerator.getId());
		int status3 = userAuthenticationTableMapper.insertSelective(userAuthentucation);
		if(status3<0) {
			throw new Exception("添加用户认证失败"); 
		}
		return status3;
	}

	@Override
	public int addUserDelivery(UserDeliveryTable userDelivery) throws Exception {
		userDelivery.setId(IdGenerator.getId());
		int insertSelective = userDeliveryTableMapper.insertSelective(userDelivery);
		if(insertSelective<0) {
			throw new  Exception("添加配员失败");
		}
		return insertSelective;
	}

	@Override
	public int addUserAdmin(UserAdminTable userAdmin) throws Exception {
		userAdmin.setId(IdGenerator.getId());
		int insertSelective = userAdminTableMapper.insertSelective(userAdmin);
		if(insertSelective<0) {
			throw new Exception("添加管理员失败");
		}
		return insertSelective;
	}

	/**
	 * 根据主键去更新，传入userAuthentucation即可
	 */
	@Override
	public int updateUserAuthentication(UserAuthenticationTable userAuthentucation) throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
		Criteria createCriteria = userAuthenticationTableExample.createCriteria();
		//默认根据ID去休息认证信息
		if(userAuthentucation.getId()!=null) {
			createCriteria.andIdEqualTo(userAuthentucation.getId());
		}
		int updateByExample = userAuthenticationTableMapper.updateByExampleSelective(userAuthentucation, userAuthenticationTableExample);
		if(updateByExample<0) {
			throw new Exception("修改认证失败");
		}
		return 0;
	}
	
	//外部传入查询条件更新
	@Override
	public int updateUserAuthentication(UserAuthenticationTable userAuthentucation,UserAuthenticationTableExample example) throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
	
		int updateByExample = userAuthenticationTableMapper.updateByExampleSelective(userAuthentucation, example);
		if(updateByExample<0) {
			throw new Exception("修改认证失败");
		}
		return 1;
	}
	//根据主键ID去更新，传入管理员就行了
	@Override
	public int updateUserAdmin(UserAdminTable userAdmin) throws Exception {
		int updateByPrimaryKeySelective = userAdminTableMapper.updateByPrimaryKeySelective(userAdmin);
		//自定义抛出异常
		if(updateByPrimaryKeySelective<0) {
			throw new Exception("出现异常");
		}
		return updateByPrimaryKeySelective;
	}

	//根据主键去更新
	@Override
	public int updateUser(UserTable user) throws Exception {
		
		return userTableMapper.updateByPrimaryKeySelective(user);
	}

	
	@Override
	public int updateUserDeliver(UserDeliveryTable userDelivery) throws Exception {
		//根据主键去更新
		return userDeliveryTableMapper.updateByPrimaryKeySelective(userDelivery);
	}

	@Override
	public int updateUserSeller(UserSellerTable userSeller) throws Exception {
		//根据主键去更新
		return userSellerTableMapper.updateByPrimaryKeySelective(userSeller);
	}

	@Override
	public int updatUserAuthentication(UserAuthenticationTable userAuthentication,UserAuthenticationTableExample example) throws Exception {
		
		return userAuthenticationTableMapper.updateByExampleSelective(userAuthentication, example);
	}

	//这个表没主键所以要自定义主键
	@Override
	public int updatUserAuthentication(UserAuthenticationTable userAuthentication) throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
		Criteria createCriteria = userAuthenticationTableExample.createCriteria();
		createCriteria.andUserIdEqualTo(userAuthentication.getId());
		return userAuthenticationTableMapper.updateByExampleSelective(userAuthentication,userAuthenticationTableExample);
	}
	/**
	 * 根据ID或者手机号码去查询用户
	 */
	@Override
	public List<UserTable> findUser(UserTable user) throws Exception {
		UserTableExample example = new UserTableExample();
		com.newretail.pojo.UserTableExample.Criteria c = example.createCriteria();
		if(user.getId()!=null) {
			c.andIdentifyEqualTo(user.getId());
		}
		if(user.getPhone()!=null) {
			c.andPhoneEqualTo(user.getPhone());
		}
		if(user.getEmail()!=null) {
			c.andEmailEqualTo(user.getEmail());
		}
		return userTableMapper.selectByExample(example);
	}

	@Override
	public List<UserSellerTable> findUserSeller(UserSellerTable userSeller) throws Exception {
		UserSellerTableExample sellerTableExample = new UserSellerTableExample();
		com.newretail.pojo.UserSellerTableExample.Criteria userSellerCriteria = sellerTableExample.createCriteria();
		if(userSeller.getId()!=null) {
			userSellerCriteria.andIdEqualTo(userSeller.getId());
		}
		
		return 	userSellerTableMapper.selectByExample(sellerTableExample);
	}

	@Override
	public UserSellerTable findUserSeller(String id) throws Exception {
		// TODO Auto-generated method stub
		return userSellerTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserAuthenticationTable> findUserAuthentication(UserAuthenticationTable userAuthentucation)
			throws Exception {
		UserAuthenticationTableExample userAuthenticationTableExample = new UserAuthenticationTableExample();
		Criteria createCriteria = userAuthenticationTableExample.createCriteria();
		if(userAuthentucation.getId()!=null) {
			createCriteria.andIdEqualTo(userAuthentucation.getId());
		}
		if(userAuthentucation.getUserId()!=null) {
			createCriteria.andUserIdEqualTo(userAuthentucation.getUserId());
		}
		return userAuthenticationTableMapper.selectByExample(userAuthenticationTableExample);
	}

	@Override
	public List<UserDeliveryTable> findUserDeliver(UserDeliveryTable userDelivery) throws Exception {
		UserDeliveryTableExample userDeliveryTableExample = new UserDeliveryTableExample();
		com.newretail.pojo.UserDeliveryTableExample.Criteria createCriteria = userDeliveryTableExample.createCriteria();
		String id = userDelivery.getId();
		if(id!=null) {
			createCriteria.andIdEqualTo(id);
		}
		if(userDelivery.getUserId()!=null) {
			createCriteria.andUserIdEqualTo(userDelivery.getUserId());
		}
		return null;
	}

	@Override
	public List<UserAdminTable> findUserAdmin(UserAdminTable userAdmin) throws Exception {
		UserAdminTableExample userAdminTableExample = new UserAdminTableExample();
		com.newretail.pojo.UserAdminTableExample.Criteria createCriteria = userAdminTableExample.createCriteria();
		if(userAdmin.getId()!=null) {
			createCriteria.andIdEqualTo(userAdmin.getId());
		}
		if(userAdmin.getUsername()!=null) {
			createCriteria.andUsernameEqualTo(userAdmin.getUsername());
		}
		return userAdminTableMapper.selectByExample(userAdminTableExample);
	}

	@Override
	public UserAdminTable findUserAdmin(String id) throws Exception {

		return userAdminTableMapper.selectByPrimaryKey(id);
	}
	@Override
	public UserTable findUser(String id) throws Exception {
		
		return userTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public UserTable getUserByToken(String token) {
		try {
			//调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			//把json转换成TaotaoREsult
			NewRetailResult result = NewRetailResult.formatToPojo(json, UserTable.class);
			if (result.getStatus() == 200) {
				UserTable user = (UserTable) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddressTable> findUserAddress(AddressTable addressTable) throws Exception {
		List<AddressTable> ls = new ArrayList<AddressTable>();
		if(!TextUtils.isEmpty(addressTable.getUserId())){
			AddressTable addressItem = addressService.getAddressDefaultByUserId(addressTable.getUserId());
			ls.add(addressItem);
			return ls;
		}
		return ls;

	}

	@Override
	public int updateUserAddress(AddressTable addressTable) {

		try {
			addressService.setAddressDefault(addressTable);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int addUserAddress(AddressTable addressTable) {
		try {
			addressService.setNewAddress(addressTable);
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int deleteUserAddress(AddressTable addressTable) {
		try {
			addressService.deleteAddressById(addressTable.getId());
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
