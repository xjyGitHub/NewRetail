package com.newretail.controller.app.impl;

import com.newretail.controller.app.AppOrderInterfaceController;
import com.newretail.pojo.app.OrderItem;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.service.app.InterfaceOrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2018-01-05
 * Time: 21:33
 */
@Controller
@RequestMapping("/app")
public class AppOrderInterfaceControllerImpl implements AppOrderInterfaceController {

    @Autowired
    private InterfaceOrderManagerService interfaceOrderManagerService;

    @RequestMapping("/orderlist")
    @ResponseBody
    @Override
    public AppResponseResult<List<OrderItem>> getOrderMerchantList(@RequestParam String token, @RequestParam int page, @RequestParam int pageSize, @RequestParam int status,@RequestParam int merchantStatus, @RequestParam String merchantId) {
        try {
            return interfaceOrderManagerService.getOrderMerchantList(token,page,pageSize,status,merchantStatus,merchantId);
        } catch (Exception e) {
            e.printStackTrace();
            return AppResponseResult.fail(e.getMessage());
        }
    }
    @RequestMapping("/update/order")
    @ResponseBody
    @Override
    public AppResponseResult orderConfirmByMerchant(String token, String orderId, int status) {
        try {
            return  interfaceOrderManagerService.orderConfirmByMerchant(token,orderId,status);
        } catch (Exception e) {
            return AppResponseResult.fail(e.getMessage());
        }
    }
}
