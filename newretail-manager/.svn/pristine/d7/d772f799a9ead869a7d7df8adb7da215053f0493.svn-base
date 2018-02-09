package com.newretail.service;

import java.util.List;
import java.util.Map;

import com.newretail.pojo.CityTable;
import com.newretail.pojo.custom.CityInfoCustom;
import com.newretail.pojo.custom.UserAddressPojo;

/**
 * 地址管理类
 * @author Yongjie
 *
 */
public interface CityService {
	 /**
	   * 根据城市代码数据
	   * @return
	   */
	  public CityTable getCityByCode(String code);
	  /**
	   * 根据城市名获取城市相关信息
	   * @param name
	   * @return
	   */
	  public CityTable getCityByName(String name);
	  
	  /**
	   * 
	   * 根据parentId获取城市信息
	   * @param id
	   * @return
	   */
	  public CityTable getCityByParentId(Integer parentId);
	  
	  
	  /**
	   * 
	   * 根据Id获取城市信息
	   * @param id
	   * @return
	   */
	  public CityTable getCityById(Integer id);
	  
	  /**
	   * 传入省、市、区县  
	   * @param province
	   * @param city
	   * @param district
	   * @return 返回 区县信息
	   */
	  public CityTable getCityMinInfo(String province,String city,String district);
	  
	  /**
	   * 根据城市编码获取城市的上上级城市信息
	   * @param province
	   * @param city
	   * @param district
	   * @return 返回省、市、区县的城市编码及城市名
	   */
	  public CityInfoCustom getCityInfoByCode(String code) throws Exception;
	  
	  /**
	   * 传入省、市、区县  
	   * @param province
	   * @param city
	   * @param district
	   * @return 返回 区县信息
	   */
	  public CityInfoCustom getCityInfoCustom(String province,String city,String district);
	  
	  
}
