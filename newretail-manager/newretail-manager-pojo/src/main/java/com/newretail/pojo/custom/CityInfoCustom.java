package com.newretail.pojo.custom;

/**
 * 城市名及城市编码
 * @author Yongjie
 *
 */
public class CityInfoCustom {
	private Integer provinceId;
	private String provinceName;
	private Integer cityId;
	private String cityName;
	private Integer districtceId;
	private String districtName;
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getDistrictceId() {
		return districtceId;
	}
	public void setDistrictceId(Integer districtceId) {
		this.districtceId = districtceId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	@Override
	public String toString() {
		return "CityInfoCustom [provinceId=" + provinceId + ", provinceName=" + provinceName + ", cityId=" + cityId
				+ ", cityName=" + cityName + ", districtceId=" + districtceId + ", districtName=" + districtName + "]";
	}
	public CityInfoCustom(Integer provinceId, String provinceName, Integer cityId, String cityName,
			Integer districtceId, String districtName) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.cityId = cityId;
		this.cityName = cityName;
		this.districtceId = districtceId;
		this.districtName = districtName;
	}
	public CityInfoCustom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
