package com.newretail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.mapper.AddressTableMapper;
import com.newretail.pojo.AddressTable;
import com.newretail.pojo.AddressTableExample;
import com.newretail.pojo.AddressTableExample.Criteria;
import com.newretail.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressTableMapper addressMapper;
	
	
	@Override
	public AddressTable getAddressById(String id) throws Exception {
		return addressMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AddressTable> getAddressByUserId(String userId) throws Exception {
		AddressTableExample addressTableExample = new AddressTableExample();
		Criteria createCriteria = addressTableExample.createCriteria();
		createCriteria.andUserIdEqualTo(userId);
		return addressMapper.selectByExample(addressTableExample);
	}

	@Override
	public AddressTable getAddressDefaultByUserId(String userId) throws Exception {
		AddressTableExample addressTableExample = new AddressTableExample();
		Criteria createCriteria = addressTableExample.createCriteria();
		createCriteria.andUserIdEqualTo(userId);
		createCriteria.andIsDefaultEqualTo(1);
		return addressMapper.selectByExample(addressTableExample).get(0);
	}

	@Override
	public void setNewAddress(AddressTable address) throws Exception {
		String userId = address.getUserId();
		List<AddressTable> addressByUserIds = this.getAddressByUserId(userId);
		AddressTableExample addressTableExample = new AddressTableExample();
		Criteria createCriteria = addressTableExample.createCriteria();
		createCriteria.andIsDefaultEqualTo(0);
		//先设置成飞默认
		for(AddressTable addressTable:addressByUserIds) {
			createCriteria.andIdEqualTo(addressTable.getId());
			addressMapper.updateByExample(addressTable,addressTableExample);
		}
		addressMapper.insertSelective(address);
	}

	@Override
	public void setAddressDefault(AddressTable address) throws Exception {
		String userId = address.getUserId();
		List<AddressTable> addressByUserIds = this.getAddressByUserId(userId);
		AddressTableExample addressTableExample = new AddressTableExample();
		Criteria createCriteria = addressTableExample.createCriteria();
		createCriteria.andIsDefaultEqualTo(0);
		//先设置成飞默认
		for(AddressTable addressTable:addressByUserIds) {
			createCriteria.andIdEqualTo(addressTable.getId());
			addressMapper.updateByExample(addressTable,addressTableExample);
		}
		createCriteria.andIsDefaultEqualTo(1);
		createCriteria.andIdEqualTo(address.getId());
		addressMapper.updateByExample(address,addressTableExample);
	}

	@Override
	public void updateAddressIsDefault(AddressTable address, AddressTableExample example) throws Exception {
		addressMapper.updateByExampleSelective(address, example);
	}

	@Override
	public void deleteAddressById(String id) throws Exception {
		addressMapper.deleteByPrimaryKey(id);

	}

}
