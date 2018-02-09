package com.newretail.controller.app.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.common.utils.DateUtil;
import com.newretail.common.utils.HttpClientUtil;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.common.utils.TextUtils;
import com.newretail.controller.app.AddressController;
import com.newretail.pojo.AddressTable;
import com.newretail.pojo.AddressTableExample;
import com.newretail.pojo.AddressTableExample.Criteria;
import com.newretail.pojo.UserTable;
import com.newretail.pojo.custom.AddressResponse;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.AppResponseResultList;
import com.newretail.service.AddressService;
import com.newretail.service.CityService;
import com.newretail.service.UserService;

@Controller
@RequestMapping("/interface")
public class AddressControllerImpl implements AddressController {
	@Autowired
	private AddressService addressSerice;

	@Autowired
	private UserService userService;

	@Autowired
	private CityService cityService;

	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;

	@Value("${SSO_USER_TOKEN}")
	public String SSO_USER_TOKEN;

	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;

	@Value("${SSO_USER_LOGIN}")
	public String SSO_USER_LOGIN;
	
	@RequestMapping(value="user/shipping-address/list",method= RequestMethod.GET)
	@ResponseBody
	@Override
	public AppResponseResultList<AddressResponse> getAllShippingAddress(String token) {
		UserTable userByToken = null;
		AppResponseResultList<AddressResponse> appResponseResult = new AppResponseResultList<AddressResponse>();
		try {
			userByToken = userService.getUserByToken(token);
		} catch (Exception e) {
			appResponseResult.setCode(100);
			appResponseResult.setMsg("登陆已过期");
		}
		if (userByToken != null) {
			String userId = userByToken.getId();
			try {
				List<AddressTable> addressByUserId = addressSerice.getAddressByUserId(userId);
				List<AddressResponse> addressResponses = new ArrayList<AddressResponse>();
				for (AddressTable addressTable : addressByUserId) {
					AddressResponse addressResponse = new AddressResponse(addressTable.getAddress(),
							addressTable.getDistrictStr(), addressTable.getCityId(), addressTable.getCityStr(),
							addressTable.getCode(), addressTable.getDateAdd(), addressTable.getDateUpdate(),
							addressTable.getDistrictId(), addressTable.getId(),
							addressTable.getIsDefault() == 0 ? false : true, addressTable.getLinkMan(),
							addressTable.getMobile(), addressTable.getProvinceId(), addressTable.getProvinceStr(),
							addressTable.getStatus(), 0, userId);
					addressResponses.add(addressResponse);
				}
				appResponseResult.setCode(200);
				appResponseResult.setMsg("succeed");
				appResponseResult.setData(addressResponses);
				return appResponseResult;
			} catch (Exception e) {
				appResponseResult.setCode(100);
				appResponseResult.setMsg("登陆已过期");
			}
		}

		return null;
	}

	@RequestMapping("/user/shipping-address/default")
	@ResponseBody
	@Override
	public AppResponseResult<AddressResponse> getAllShippingDefaultAddress(HttpServletRequest req) {
		UserTable userByToken = null;
		String token = req.getParameter("token");

		AppResponseResult<AddressResponse> appResponseResult = new AppResponseResult<AddressResponse>();
		try {
			userByToken = userService.getUserByToken(token);
			// 调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			// 把json转换成TaotaoREsult
			NewRetailResult result = NewRetailResult.formatToPojo(json, UserTable.class);
			if (result.getStatus() == 200) {
				userByToken = (UserTable) result.getData();
			}
			if (userByToken != null) {
				String userId = userByToken.getId();
				AddressTable addressTable = addressSerice.getAddressDefaultByUserId(userId);
				AddressResponse addressResponse = new AddressResponse(addressTable.getAddress(),
						addressTable.getDistrictStr(), addressTable.getCityId(), addressTable.getCityStr(),
						addressTable.getCode(), addressTable.getDateAdd(), addressTable.getDateUpdate(),
						addressTable.getDistrictId(), addressTable.getId(),
						addressTable.getIsDefault() == 0 ? false : true, addressTable.getLinkMan(),
						addressTable.getMobile(), addressTable.getProvinceId(), addressTable.getProvinceStr(),
						addressTable.getStatus(), 0, userId);
				appResponseResult.setCode(200);
				appResponseResult.setMsg("succeed");
				appResponseResult.setData(addressResponse);
				return appResponseResult;
			} else {
				appResponseResult.setCode(100);
				appResponseResult.setMsg("Token已过期，找不到用户信息");
			}

		} catch (Exception e) {
			appResponseResult.setCode(100);
			appResponseResult.setMsg("登陆已过期" + e.getMessage());
		}

		return appResponseResult;
	}

	@RequestMapping(value="/user/shipping-address/detail",method=RequestMethod.GET)
	@ResponseBody
	@Override
	public AppResponseResult<AddressResponse> getAllShippingDetailAddress(String token, String id) {
		UserTable userByToken = null;

		if(TextUtils.isEmpty(id)) {
			AppResponseResult appResponseResultObj = new AppResponseResult();
			appResponseResultObj.setCode(100);
			appResponseResultObj.setMsg("用户ID不存在");
			return appResponseResultObj;
		}
		AppResponseResult<AddressResponse> appResponseResult = new AppResponseResult<AddressResponse>();
		try {
			userByToken = userService.getUserByToken(token);
			// 调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
			// 把json转换成TaotaoREsult
			NewRetailResult result = NewRetailResult.formatToPojo(json, UserTable.class);
			if (result.getStatus() == 200) {
				userByToken = (UserTable) result.getData();
			}
			if (userByToken != null) {
				String userId = userByToken.getId();
				
				//AddressTable addressTable = addressSerice.getAddressDefaultByUserId(userId);
				AddressTable addressTable = addressSerice.getAddressById(id);
				
				AddressResponse addressResponse = new AddressResponse(addressTable.getAddress(),
						addressTable.getDistrictStr(), addressTable.getCityId(), addressTable.getCityStr(),
						addressTable.getCode(), addressTable.getDateAdd(), addressTable.getDateUpdate(),
						addressTable.getDistrictId(), addressTable.getId(),
						addressTable.getIsDefault() == 0 ? false : true, addressTable.getLinkMan(),
						addressTable.getMobile(), addressTable.getProvinceId(), addressTable.getProvinceStr(),
						addressTable.getStatus(), 0, userId);
				appResponseResult.setCode(200);
				appResponseResult.setMsg("succeed");
				appResponseResult.setData(addressResponse);
				return appResponseResult;
			} else {
				appResponseResult.setCode(100);
				appResponseResult.setMsg("Token已过期，找不到用户信息");
			}

		} catch (Exception e) {
			appResponseResult.setCode(100);
			appResponseResult.setMsg("登陆已过期" + e.getMessage());
		}

		return appResponseResult;
	}

	@RequestMapping("/user/shipping-address/add")
	@ResponseBody
	@Override
	public AppResponseResult<String> addShippingAddress(HttpServletRequest req) {
		AppResponseResult<String> appResponseResultObj = new AppResponseResult<String>();
		// 添加用户地址
		AddressTable addressTable = new AddressTable();
		String token = req.getParameter("token");
		int provinceId = Integer.parseInt(req.getParameter("provinceId"));
		int cityId = Integer.parseInt(req.getParameter("cityId"));
		int districtId = Integer.parseInt(req.getParameter("districtId"));
		String linkMan = req.getParameter("linkMan");
		String address = req.getParameter("address");
		String mobile = req.getParameter("mobile");
		int code = Integer.parseInt(req.getParameter("code"));
		String userId = null;
		boolean isDefault = Boolean.parseBoolean(req.getParameter("isDefault"));
		if (!TextUtils.isEmpty(req.getParameter("token"))) {
			UserTable userByToken;
			try {
				userByToken = userService.getUserByToken(token);
				userId = userByToken.getId();
			} catch (Exception e) {
				appResponseResultObj.setCode(100);
				appResponseResultObj.setMsg("登陆过期，修改地址是吧");
				return appResponseResultObj;
			}

		}
		if (!TextUtils.isEmpty(req.getParameter("provinceId"))) {
			addressTable.setProvinceId(provinceId);
		}
		if (!TextUtils.isEmpty(req.getParameter("cityId"))) {
			addressTable.setCityId(cityId);
		}
		if (!TextUtils.isEmpty(req.getParameter("districtId"))) {
			addressTable.setDistrictId(districtId);
		}
		if (!TextUtils.isEmpty(req.getParameter("linkMan"))) {
			addressTable.setLinkMan(linkMan);
		}
		if (!TextUtils.isEmpty(req.getParameter("address"))) {
			addressTable.setAddress(address);
		}
		if (!TextUtils.isEmpty(req.getParameter("mobile"))) {
			addressTable.setMobile(mobile);
		}
		if (!TextUtils.isEmpty(req.getParameter("code"))) {
			addressTable.setCode(code + "");
		}

		if (!TextUtils.isEmpty(req.getParameter("isDefault"))) {
			addressTable.setIsDefault(isDefault == true ? 1 : 0);
		}
		if (!TextUtils.isEmpty(userId)) {
			addressTable.setUserId(userId);
		}
		addressTable.setProvinceStr(cityService.getCityByCode(provinceId + "").getName());
		addressTable.setCityStr(cityService.getCityByCode(cityId + "").getName());
		addressTable.setDistrictStr(cityService.getCityByCode(districtId + "").getName());
		addressTable.setDateAdd(DateUtil.getNowDateTime());
		addressTable.setDateUpdate(DateUtil.getNowDateTime());
		addressTable.setStatus(0);
		try {
			addressSerice.setNewAddress(addressTable);
		} catch (Exception e) {
			appResponseResultObj.setCode(100);
			appResponseResultObj.setMsg("请检测地址信息是否正确");
			return appResponseResultObj;
		}
		appResponseResultObj.setCode(200);
		appResponseResultObj.setMsg("添加地址成功");
		return appResponseResultObj;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/user/shipping-address/delete",method=RequestMethod.GET)
	@ResponseBody
	@Override
	public AppResponseResult<String> delShippingAddress(String token, String id) {

		try {
			UserTable user = userService.getUserByToken(token);
			addressSerice.deleteAddressById(id);
			return AppResponseResult.succeed();
		} catch (Exception e) {
			return AppResponseResult.build(100, "失败"+e.getMessage());
		
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="user/shipping-address/update",method=RequestMethod.GET)
	@ResponseBody
	@Override
	public AppResponseResult<String> updateShippingAddress(String token, String id, Boolean isDefault) {
		AddressTableExample addressTableExample = new AddressTableExample();
		Criteria createCriteria = addressTableExample.createCriteria();
		try {
			UserTable user = userService.getUserByToken(token);
			AddressTable addressTable = new AddressTable();
			if(isDefault) { //全部设置为false
				createCriteria.andUserIdEqualTo(user.getId());
				addressTable.setIsDefault(0);
				addressSerice.updateAddressIsDefault(addressTable, addressTableExample);
			}
			//把新地址设置成默认收货地址
			addressTable.setIsDefault(1);
			createCriteria.andIdEqualTo(id);
			addressSerice.updateAddressIsDefault(addressTable, addressTableExample);
			return AppResponseResult.succeed();
		} catch (Exception e) {
			return AppResponseResult.build(100, "失败"+e.getMessage());
		
		}
	}

}
