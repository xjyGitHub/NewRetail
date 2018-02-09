package com.newretail.service;

import java.util.List;

import com.newretail.pojo.AddressTable;
import com.newretail.pojo.AddressTableExample;

/**
 * 用户地址管理
 * @author Yongjie
 *
 */
public interface AddressService {
	/**
	 * 根据 ID 获取用户地址地址信息
	 * @param id
	 * @return 返回地址信息
	 */
	public AddressTable getAddressById(String id) throws Exception;
	
	/**
	 * 根据UserId获取用户地址
	 * @param userId
	 * @return 返回地址信息
	 */
	public List<AddressTable> getAddressByUserId(String userId)  throws Exception;
	
	/**
	 * 根据用户名ID,获取用户默认的ID
	 * @param userId
	 * @return 返回地址信息
	 */
	public AddressTable getAddressDefaultByUserId(String userId) throws Exception;
		
	/**
	 * 添加新地址,默认设置成默认地址
	 * @param address
	 * @throws Exception
	 */
	public void setNewAddress(AddressTable address) throws Exception;
	
	/**
	 * 设置默认地址
	 * @param address,必传,userId,Id
	 * @throws Exception
	 */
	public void setAddressDefault(AddressTable address) throws Exception;

	
	/**
	 * 修改地址状态
	 * @param address userId必传,Id必须传
	 * @param example
	 */
	public void updateAddressIsDefault(AddressTable address,AddressTableExample example) throws Exception;
	
	/**
	 * 根据ID删除用户地址
	 * @param id
	 * @throws Exception
	 */
	public void deleteAddressById(String id)  throws Exception;
}
