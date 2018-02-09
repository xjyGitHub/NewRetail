package com.newretail.service.app.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.DateUtil;
import com.newretail.common.utils.TextUtils;
import com.newretail.mapper.DeliverInfoTableMapper;
import com.newretail.mapper.OrderItemTableMapper;
import com.newretail.mapper.OrderLogisticsTableMapper;
import com.newretail.mapper.OrderTableMapper;
import com.newretail.pojo.*;
import com.newretail.pojo.app.OrderGoodsItem;
import com.newretail.pojo.app.OrderItem;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.service.UserService;
import com.newretail.service.app.InterfaceOrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2018-01-05
 * Time: 16:18
 */
@Service("interfaceOrderManagerService")
public class InterfaceOrderManagerServiceImpl implements InterfaceOrderManagerService {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderTableMapper orderMapper;
    @Autowired
    private OrderItemTableMapper orderItemMapper;
    @Autowired
    private OrderLogisticsTableMapper orderLogisticsMapper;

    @Autowired
    private DeliverInfoTableMapper deliverInfoTableMapper;
    /**
     * 查询商家订单信息
     * @param token 用户登陆凭证
     * @param page 从第几条开始
     * @param pageSize 到多少条
     * @param status 状态
     * @return
     * @throws Exception 抛出异常信息
     */
    @Override
    public AppResponseResult<List<OrderItem>> getOrderMerchantList(String token,int page,int pageSize,int status,Integer merchantStatus,String merchantId) throws Exception {
        //        UserTable user = userService.getUserByToken(token);
        //        String id = user.getId();
        // 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、退款中，7、交易关闭
        // 状态：0（买家未付款 1）商家看不到订单，1（买家已付款 2）创建状态，2.已接单[进行中]（买家未发货 3）, 3 已完成（买家交易完成 5），4 已取消（交易关闭 7），5 售后退款（用户状态（退款中）6 ），6.交易关闭（交易关闭7）
        //商家ID
        try {
            PageHelper.startPage(page, pageSize);
            //查询订单信息
            OrderTableExample orderTableExample = new OrderTableExample();
            OrderTableExample.Criteria criteria = orderTableExample.createCriteria();
            if(!TextUtils.isEmpty(merchantStatus)&&merchantStatus!=-1){
                criteria.andMerchantStatusEqualTo(merchantStatus);
            }
            criteria.andMerchantIdEqualTo(merchantId);
            //查询订单信息
            List<OrderTable> orderTablesList = orderMapper.selectByExample(orderTableExample);
            PageInfo<OrderTable> pageInfo = new PageInfo<OrderTable>(orderTablesList);//把结果放在分页里面
            List<OrderTable> orderTables = pageInfo.getList();
            List<OrderItem> orderItems = new ArrayList<>();
            for (OrderTable order : orderTables) {
                //配送地址信息
                OrderLogisticsTable orderLogisticsTable = orderLogisticsMapper.selectByPrimaryKey(order.getOrderId());
                //订单基本信息
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(order.getOrderId());
                orderItem.setCreateTime(DateUtil.getStringDateByDate(order.getCreateTime()));
                orderItem.setUpdateTime(DateUtil.getStringDateByDate(order.getUpdateTime(),"HH:mm"));
                orderItem.setIsUrgent(1);
                orderItem.setStatus(order.getMerchantStatus());
                orderItem.setLinkMan(orderLogisticsTable.getReceiverName());
                orderItem.setReceiverPhone(orderLogisticsTable.getReceiverMobile());
                orderItem.setAddress(orderLogisticsTable.getReceiverAddress());
                orderItem.setIncome(Double.parseDouble(order.getPayment() == null ? "0" : order.getPayment()));
                //在已发货的情况下去查询配送状态
                DeliverInfoTableExample deliverInfoTableExample = new DeliverInfoTableExample();
                DeliverInfoTableExample.Criteria infoTableExampleCriteria = deliverInfoTableExample.createCriteria();
                infoTableExampleCriteria.andOrderIdEqualTo(order.getOrderId());
                List<DeliverInfoTable> deliverInfoTables = deliverInfoTableMapper.selectByExample(deliverInfoTableExample);
                //有物流信息
                if (deliverInfoTables != null && deliverInfoTables.size() > 1) {
                    DeliverInfoTable deliverInfoTable = deliverInfoTables.get(0);
                    orderItem.setDeliverStatus(Integer.parseInt(deliverInfoTable.getDeliverStatus() == null ? "0" : deliverInfoTable.getDeliverStatus()));
                    orderItem.setDeliverStatusStr(deliverInfoTable.getDeliverStatus());
                    orderItem.setDeliverName(deliverInfoTable.getSenderName());
                    orderItem.setDeliverPhone(deliverInfoTable.getSenderPhone());
                } else {
                    //没有物流信息
                    orderItem.setDeliverStatus(-1);
                }
                //获取订单商品列表
                OrderItemTableExample itemTableExample = new OrderItemTableExample();
                OrderItemTableExample.Criteria itemTableExampleCriteria = itemTableExample.createCriteria();
                itemTableExampleCriteria.andOrderIdEqualTo(order.getOrderId());
                List<OrderItemTable> orderItemTables = orderItemMapper.selectByExample(itemTableExample);
                List<OrderGoodsItem> orderGoodsItems = new ArrayList<>();
                for (OrderItemTable orderItemTable : orderItemTables) {
                    OrderGoodsItem orderGoodsItem = new OrderGoodsItem();
                    orderGoodsItem.setGoodsName(orderItemTable.getGoodsName());
                    orderGoodsItem.setGoodsNumber(orderItemTable.getNumber());
                    orderGoodsItem.setPrice(orderItemTable.getPrice());
                    orderGoodsItems.add(orderGoodsItem);
                }
                orderItem.setGoods(orderGoodsItems);
                orderItems.add(orderItem);
            }
            return  new AppResponseResult<List<OrderItem>>(200,orderItems,"succeed");
        } catch (NumberFormatException e) {
            return AppResponseResult.fail(e.getMessage());
        }
    }

    /**
     * 商家做订单操作，接单/拒单
     * @param token 用户登陆凭证
     * @param orderId 订单ID 必传
     * @param status 订单状态必传
     * @return
     * @throws Exception
     */
    @Override
    public AppResponseResult orderConfirmByMerchant(String token, String orderId, int status) throws Exception {
        OrderTable orderTable = new OrderTable();
        orderTable.setOrderId(orderId);
        orderTable.setStatus(status);
        int update = orderMapper.updateByPrimaryKeySelective(orderTable);
        if(update>0){
            return AppResponseResult.succeed();
        }
        return AppResponseResult.fail();
    }
}
