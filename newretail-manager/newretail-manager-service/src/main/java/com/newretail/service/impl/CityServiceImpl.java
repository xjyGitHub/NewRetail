package com.newretail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.common.utils.TextUtils;
import com.newretail.mapper.CityTableMapper;
import com.newretail.pojo.CityTable;
import com.newretail.pojo.CityTableExample;
import com.newretail.pojo.CityTableExample.Criteria;
import com.newretail.pojo.custom.CityInfoCustom;
import com.newretail.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityTableMapper cityTableMapper;
	
	@Override
	public CityTable getCityByCode(String code) {
		CityTableExample cityTableExample = new CityTableExample();
		Criteria cityCriteria = cityTableExample.createCriteria();
		cityCriteria.andCodeEqualTo(code);
		List<CityTable> cityExample = cityTableMapper.selectByExample(cityTableExample);
		if(cityExample!=null&&cityExample.size()>0) {
			return  cityExample.get(0);
		}
		return null;
	}
	
	@Override
	public CityTable getCityByName(String name) {
		CityTableExample cityTableExample = new CityTableExample();
		Criteria cityCriteria = cityTableExample.createCriteria();
		cityCriteria.andNameEqualTo(name);
		List<CityTable> cityExample = cityTableMapper.selectByExample(cityTableExample);
		if(cityExample!=null&&cityExample.size()>0) {
			return  cityExample.get(0);
		}
		return null;
	}

	@Override
	public CityTable getCityByParentId(Integer parentId) {
		CityTableExample cityTableExample = new CityTableExample();
		Criteria cityCriteria = cityTableExample.createCriteria();
		cityCriteria.andParentIdEqualTo(parentId);
		List<CityTable> cityExample = cityTableMapper.selectByExample(cityTableExample);
		if(cityExample!=null&&cityExample.size()>0) {
			return  cityExample.get(0);
		}
		return null;
	}

	@Override
	public CityTable getCityById(Integer id) {
		return cityTableMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取最小级城市信息
	 */
	@Override
	public CityTable getCityMinInfo(String province,String city,String district) {
		CityTableExample provinceExample = new CityTableExample();
		Criteria provinceCriteria = provinceExample.createCriteria();
		CityTableExample cityExample = new CityTableExample();
		Criteria cityCriteria = cityExample.createCriteria();
		//CityTableExample districtExample = new CityTableExample();
		//Criteria districtCriteria = districtExample.createCriteria();
		List<CityTable> provinceList = null;
		List<CityTable> cityList = null;
		List<CityTable> districtList = null;

		if(!TextUtils.isEmpty(province)) {
			provinceCriteria.andNameEqualTo(province);
			provinceList = cityTableMapper.selectByExample(provinceExample);
		}
		if(provinceList!=null&&provinceList.size()>0) {
			CityTable cityTable = provinceList.get(0);
			Integer id = cityTable.getId();
			cityCriteria.andParentIdEqualTo(id);
			cityCriteria.andNameEqualTo(city);
			cityList = cityTableMapper.selectByExample(provinceExample);
		}
		if(cityList!=null&&cityList.size()>0&&!TextUtils.isEmpty(district)) {
			CityTable cityTable = cityList.get(0);
			Integer id = cityTable.getId();
			cityCriteria.andParentIdEqualTo(id);
			cityCriteria.andNameEqualTo(district);
			districtList = cityTableMapper.selectByExample(provinceExample);
		}
		if(!TextUtils.isEmpty(district)) {
			return districtList.get(0);
		}else {
			return cityList.get(0);
		}
	}
    /**
     * 根据城市编码返回它及它的上级及上上级城市代码及城市名称
     */
	@Override
	public CityInfoCustom getCityInfoByCode(String code) throws Exception{
		 CityInfoCustom cityInfoCustom = new CityInfoCustom();
		 CityTableExample cityExample = new CityTableExample();
		 Criteria cityCriteria = cityExample.createCriteria();
		 	      cityCriteria.andCodeEqualTo(code);
		 //区县或者城市
		 CityTable cityTable = cityTableMapper.selectByExample(cityExample).get(0);
		 String nameDistrict = cityTable.getName();
		 Integer level = cityTable.getLevel();
		 Integer parentId = cityTable.getParentId();
		 
		 if(level==1) { //没有区县的
			 cityInfoCustom.setCityId(Integer.parseInt(cityTable.getCode()));
			 cityInfoCustom.setCityName(nameDistrict);
			 CityTableExample e1 = new CityTableExample();
			 Criteria c1 = e1.createCriteria();
			 c1.andIdEqualTo(parentId);
			 //获取省份
			 CityTable province = cityTableMapper.selectByExample(e1).get(0);
			 cityInfoCustom.setProvinceId(Integer.parseInt(province.getCode()));
			 cityInfoCustom.setProvinceName(province.getName());
		 }else if(level==2) { //有区县市
			 cityInfoCustom.setDistrictceId(Integer.parseInt(cityTable.getCode()));
			 cityInfoCustom.setDistrictName(nameDistrict);
			 CityTableExample e1 = new CityTableExample();
			 Criteria c1 = e1.createCriteria();
			 c1.andIdEqualTo(parentId);
			 //获取城市
			 CityTable city = cityTableMapper.selectByExample(e1).get(0);
			 Integer cityParentId = city.getParentId();
			 cityInfoCustom.setCityId(Integer.parseInt(city.getCode()));
			 cityInfoCustom.setCityName(city.getName());
			 //获取省份
			 CityTableExample e2 = new CityTableExample();
			 Criteria c2 = e2.createCriteria();
			 c2.andIdEqualTo(cityParentId);
			 CityTable province = cityTableMapper.selectByExample(e2).get(0);
			 cityInfoCustom.setProvinceId(Integer.parseInt(province.getCode()));
			 cityInfoCustom.setProvinceName(province.getName());
		 }else { //获取省
			 cityInfoCustom.setProvinceId(Integer.parseInt(cityTable.getCode()));
			 cityInfoCustom.setProvinceName(nameDistrict);
		 }

		return cityInfoCustom;
	}

	/**
	 * 返回省市区代码
	 */
	@Override
	public CityInfoCustom getCityInfoCustom(String province, String city, String district) {
		CityInfoCustom cityInfoCustom = new CityInfoCustom();
		CityTableExample provinceExample = new CityTableExample();
		Criteria provinceCriteria = provinceExample.createCriteria();
		CityTableExample cityExample = new CityTableExample();
		Criteria cityCriteria = cityExample.createCriteria();
		//CityTableExample districtExample = new CityTableExample();
		//Criteria districtCriteria = districtExample.createCriteria();
		List<CityTable> provinceList = null;
		List<CityTable> cityList = null;
		List<CityTable> districtList = null;

		if(!TextUtils.isEmpty(province)) {
			provinceCriteria.andNameEqualTo(province);
			provinceList = cityTableMapper.selectByExample(provinceExample);
			
		}
		if(provinceList!=null&&provinceList.size()>0) {
			CityTable cityTable = provinceList.get(0);
			Integer id = cityTable.getId();
			cityCriteria.andParentIdEqualTo(id);
			cityCriteria.andNameEqualTo(city);
			cityList = cityTableMapper.selectByExample(provinceExample);
		}
		if(cityList!=null&&cityList.size()>0&&!TextUtils.isEmpty(district)) {
			CityTable cityTable = cityList.get(0);
			Integer id = cityTable.getId();
			cityCriteria.andParentIdEqualTo(id);
			cityCriteria.andNameEqualTo(district);
			districtList = cityTableMapper.selectByExample(provinceExample);
		}
		if(provinceList!=null&&provinceList.size()>0) {
			cityInfoCustom.setProvinceId(Integer.parseInt(provinceList.get(0).getCode()));
			cityInfoCustom.setProvinceName(provinceList.get(0).getName());
		}
		if(cityList!=null&&cityList.size()>0) {
			cityInfoCustom.setCityId(Integer.parseInt(cityList.get(0).getCode()));
			cityInfoCustom.setCityName(cityList.get(0).getName());
		}
		if(districtList!=null&&districtList.size()>0) {
			cityInfoCustom.setDistrictceId(Integer.parseInt(districtList.get(0).getCode()));
			cityInfoCustom.setDistrictName(districtList.get(0).getName());
		}
		return cityInfoCustom;
	}
}
