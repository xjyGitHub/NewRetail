package com.newretail.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.*;
import com.newretail.mapper.*;
import com.newretail.pojo.*;
import com.newretail.pojo.OrderItemTableExample.Criteria;
import com.newretail.pojo.wechatapp.*;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.service.AddressService;
import com.newretail.service.InterfaceOrderService;
import com.newretail.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 订单相关接口
 */
@Service("interfaceOrderService")
public class InterfaceOrderServiceImpl implements InterfaceOrderService {
    @Autowired
    private OrderTableMapper orderMapper;

    @Autowired
    private OrderItemTableMapper orderItemMapper;

    @Autowired
    private OrderLogisticsTableMapper orderLogisticsMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsTableMapper goodsTableMapper;

    @Autowired
    private OrderReputationsTableMapper orderReputationsTableMapper;

    @Override
    public OrderTable getOrderListByOrderId(String orderId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 获取订单列表信息
     *
     * @param orderId
     * @param userId
     * @return
     */
    @Override
    public AppResponseResult<OrderResponse> getOrderList(String orderId, String userId) {
        //订单
        OrderTable order = orderMapper.selectByPrimaryKey(orderId);
        OrderItemTableExample itemExample = new OrderItemTableExample();
        Criteria criteria = itemExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        //订单明细
        List<OrderItemTable> orderItemList = orderItemMapper.selectByExample(itemExample);
        //物流信息
        OrderLogisticsTable orderLogistics = orderLogisticsMapper.selectByPrimaryKey(orderId);
        //订单明细
        ArrayList<OrderListItem> orderItems = new ArrayList<OrderListItem>();
        //商品Map
        List<GoodsMapItem> GoodsMapItems = new ArrayList<GoodsMapItem>();
        Map<String, List<GoodsMapItem>> goodsMapItemMap = new HashMap<String, List<GoodsMapItem>>();

        AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
        //设置订单
        for (OrderItemTable orderItem : orderItemList) {
            //订单明细信息
            OrderListItem orderListItem = new OrderListItem();
            orderListItem.setPrice(orderItem.getPrice());
            orderListItem.setPriceLogistics(orderItem.getPrice());
            orderListItem.setPriceReal(orderItem.getPrice());
            String dateTime = DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", order.getCreateTime());
            orderListItem.setDateAdd(dateTime);
            orderListItem.setId(order.getOrderId());
            orderListItem.setOrderNumber("TS"+order.getOrderId());
            orderListItem.setRemark("暂无备注信息");
            orderListItem.setStatus(order.getStatus());
            orderListItem.setStatusStr(order.getStatus() == 1 ? "未付款" : order.getStatus() == 2 ? "已付款" : order.getStatus() == 3 ? "未发货" : order.getStatus() == 4 ? "已发货" : order.getStatus() == 5 ? "交易成功" : "交易关闭");
            orderListItem.setType("获取订单");
            orderListItem.setUid(1);
            orderListItem.setUserId(userId);
            orderItems.add(orderListItem);

            //商品信息
            GoodsTable goods = goodsTableMapper.selectByPrimaryKey(orderItem.getGoodsId());
            String imageSignUrl = aliyunOssUtils.getImageSignUrl(goods.getGoodsPhoto());
            GoodsMapItem goodsMapItem = new GoodsMapItem();
            goodsMapItem.setGoodsId(orderItem.getGoodsId());
            goodsMapItem.setGoodsName(orderItem.getGoodsName());
            goodsMapItem.setId(orderItem.getId());
            goodsMapItem.setPrice(orderItem.getPrice());
            goodsMapItem.setOrderId(orderId);
            goodsMapItem.setPic(imageSignUrl);
            GoodsMapItems.add(goodsMapItem);


        }
        goodsMapItemMap.put(orderId, GoodsMapItems);
        AddressTable addressTable;
        Map<String, List<LogisticsMapItem>> logisticsMap = new HashMap<String, List<LogisticsMapItem>>();
        List<LogisticsMapItem> logistics = new ArrayList<LogisticsMapItem>();
        try {
            addressTable = addressService.getAddressDefaultByUserId(userId);
            LogisticsMapItem logisticsMapItem = new LogisticsMapItem();
            logisticsMapItem.setAddress(orderLogistics.getReceiverAddress());
            logisticsMapItem.setCityId(addressTable.getCityId());
            logisticsMapItem.setCode(orderLogistics.getReceiverZip());
            logisticsMapItem.setDateUpdate(orderLogistics.getUpdated());
            logisticsMapItem.setDistrictId(addressTable.getDistrictId());
            logisticsMapItem.setLinkMan(orderLogistics.getReceiverName());
            logisticsMapItem.setMobile(orderLogistics.getReceiverMobile());
            logisticsMapItem.setProvinceId(addressTable.getProvinceId());
            logisticsMapItem.setStatus(Integer.parseInt(orderLogistics.getReceiverState()));
            logistics.add(logisticsMapItem);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logisticsMap.put(orderId, logistics);

        OrderResponse orderListResponse = new OrderResponse();
        orderListResponse.setGoodsMap(goodsMapItemMap);
        orderListResponse.setLogisticsMap(logisticsMap);
        orderListResponse.setOrderList(orderItems);

        return new AppResponseResult<OrderResponse>(200, orderListResponse, "succeed");
    }

    @Override
    public GoodsTableCustom getGoodsCustomById(String goodsId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 关闭订单
     *
     * @param token
     * @param orderId
     * @return
     */
    @Override
    public AppResponseResult closeOrderByOrderId(String token, String orderId) {
        try {
            UserTable user = userService.getUserByToken(token);
            String userId = user.getId();
            if (TextUtils.isEmpty(userId)) {
                return AppResponseResult.fail("登陆过期");
            }
            OrderTable orderTable = new OrderTable();
            orderTable.setOrderId(orderId);
            orderTable.setStatus(SystemStatusCode.ORDER_CLOASE.getCode());
            int status = orderMapper.updateByPrimaryKey(orderTable);
            if (status == 1) {
                return AppResponseResult.succeed();
            } else {
                return AppResponseResult.fail();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppResponseResult.fail();
    }

    /**
     * 确认收货接口
     *
     * @param token
     * @param orderId
     * @return
     */
    @Override
    public AppResponseResult confirmOrderDelivery(String token, String orderId) {
        OrderTable orderTable = new OrderTable();
        orderTable.setStatus(SystemStatusCode.ORDER_CONFIRM_DELIVER.getCode());
        int status = orderMapper.updateByPrimaryKey(orderTable);
        if (status < 1) {
            return AppResponseResult.fail();
        }
        return AppResponseResult.succeed();
    }

    /**
     * 订单评论接口
     *
     * @param reputationsRoot 传入实体类
     * @return
     */
    @Override
    public AppResponseResult orderReputation(ReputationsRoot reputationsRoot) {
        try {
            String orderId = reputationsRoot.getOrderId();
            List<Reputations> reputations = reputationsRoot.getReputations();
            String token = reputationsRoot.getToken();
            UserTable user = userService.getUserByToken(token);
            for (Reputations r : reputations) {
                OrderReputationsTable orderReputationsTable = new OrderReputationsTable();
                orderReputationsTable.setId(IdGenerator.getId());
                orderReputationsTable.setOrderId(orderId);
                orderReputationsTable.setRemark(r.getRemark());
                orderReputationsTable.setUserId(user.getId());
                orderReputationsTable.setReputation(r.getReputation() + "");
                orderReputationsTableMapper.insertSelective(orderReputationsTable);
            }
            return AppResponseResult.succeed();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(InterfaceOrderServiceImpl.class);
            logger.info("----------添加评论失败------------" + e.getMessage());
        }
        return AppResponseResult.fail();
    }

    /**
     * 订单状态统计
     *
     * @param token
     * @return
     */
    @Override
    public AppResponseResult orderStatistics(String token) {
        try {
            UserTable user = userService.getUserByToken(token);
            OrderTableExample orderTableExample = new OrderTableExample();
            OrderTableExample.Criteria criteria = orderTableExample.createCriteria();
            criteria.andUserIdEqualTo(user.getId());
            List<OrderTable> orderTables = orderMapper.selectByExample(orderTableExample);
            int noPays = 0;
            int noTransfer = 0;
            int isConfirm = 0;
            int success = 0;
            int close = 0;
            for (OrderTable order : orderTables) {
                Integer status = order.getStatus();
                //1 没有支付
                if (SystemStatusCode.ORDER_NO_PAY.getCode().equals(status)) {
                    noPays++;
                    // 3 没有配送
                } else if (SystemStatusCode.ORDER_UN_DELIVER.getCode().equals(status)) {
                    noTransfer++;
                    //4 已发货
                } else if (SystemStatusCode.ORDER_CONFIRM_DELIVER.getCode().equals(status)) {
                    isConfirm++;
                    //已付款
                } else if (SystemStatusCode.ORDER_IS_PAY.getCode().equals(status)) {
                    isConfirm++;
                } else if (SystemStatusCode.ORDER_SUCCEED.getCode().equals(status)) {
                    success++;
                } else {
                    close++;
                }
            }
            OrderStatistics orderStatistics = new OrderStatistics();
            orderStatistics.setCount_id_close(close);
            orderStatistics.setCount_id_success(success);
            orderStatistics.setCount_id_no_reputation(0);
            orderStatistics.setCount_id_no_confirm(isConfirm);
            orderStatistics.setCount_id_no_transfer(noTransfer);
            orderStatistics.setCount_id_no_pay(noPays);
            return new AppResponseResult(200, orderStatistics, "succeed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppResponseResult.fail();
    }

    /**
     * 订单退款信息
     *
     * @param token
     * @param orderId
     * @return
     */
    @Override
    public AppResponseResult orderRefund(String token, String orderId) {
        return null;
    }

    /**
     * 订单支付
     *
     * @param token
     * @param orderId
     * @return
     */
    @Override
    public AppResponseResult orderPay(String token, String orderId) {
        return null;
    }

    /**
     * 查询订单明细
     *
     * @param token
     * @param orderId
     * @return
     * @throws Exception
     */
    @Override
    public AppResponseResult<OrderDetailResponse> querOrderDetail(String token, String orderId) throws Exception {
        double goodPriceTotal = 0;
        double priceTotal = 0;
        double logisticsTotal = 0;
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        //获取用户ID
        String userId = userService.getUserByToken(token).getId();
        //获取订单OrderDetailInfo
        OrderTable order = orderMapper.selectByPrimaryKey(orderId);
        //获取订单明细
        OrderItemTableExample itemExample = new OrderItemTableExample();
        Criteria criteria = itemExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItemTable> orderItemList = orderItemMapper.selectByExample(itemExample);
        //获取订单评论
        OrderReputationsTableExample reputationsTableExample = new OrderReputationsTableExample();
        OrderReputationsTableExample.Criteria criteria1 = reputationsTableExample.createCriteria();
        criteria1.andOrderIdEqualTo(orderId);
        List<OrderReputationsTable> reputations = orderReputationsTableMapper.selectByExample(reputationsTableExample);
        if(reputations!=null&&reputations.size()>1){
            OrderReputationsTable reputation = reputations.get(0);
        }


        //获取物流信息
        OrderLogisticsTable orderLogistics = orderLogisticsMapper.selectByPrimaryKey(orderId);

        //订单商品明细
        List<OrderDetailGoods> goodsList = new ArrayList<OrderDetailGoods>();

        AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();

        //获取订单下商品信息
        for (OrderItemTable orderItem : orderItemList) {

            //获取商品
            GoodsTable goods = goodsTableMapper.selectByPrimaryKey(orderItem.getGoodsId());
            double  goodsPrice= Double.parseDouble((goods.getGoodsPrice()==null?"0":goods.getGoodsPrice()));
            double priceLogistics =  Double.parseDouble((goods.getGoodsPrice()==null?"0":goods.getGoodsPrice()));
            priceTotal = priceTotal + priceLogistics;
            Integer number = orderItem.getNumber();
            String imageSignUrl = aliyunOssUtils.getImageSignUrl(goods.getGoodsPhoto());
            OrderDetailGoods orderDetailGoods = new OrderDetailGoods();
            orderDetailGoods.setGoodsId(orderItem.getGoodsId());
            orderDetailGoods.setGoodsName(orderItem.getTitle());
            orderDetailGoods.setId(orderItem.getId());
            //设置商品单价
            orderDetailGoods.setPrice(goodsPrice);
            //商品总价
            goodPriceTotal = goodPriceTotal+goodsPrice*number;
            //物流总价
            logisticsTotal = logisticsTotal+ priceLogistics;
            orderDetailGoods.setOrderId(orderId);
            orderDetailGoods.setPic(imageSignUrl);
            //商品数量
            orderDetailGoods.setNumber(number);
            goodsList.add(orderDetailGoods);
        }
        Double payment = Double.parseDouble(order.getPayment()==null?"0":order.getPayment());
        //设置订单信息
        //商品总价
        orderDetailInfo.setPrice(goodPriceTotal);
        //运费
        orderDetailInfo.setPriceLogistics(logisticsTotal);
        //订单总价
        orderDetailInfo.setPriceReal(payment);
        String dateTime = DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", order.getCreateTime());
        orderDetailInfo.setDateAdd(dateTime);
        orderDetailInfo.setId(order.getOrderId());
        orderDetailInfo.setOrderNumber("TS"+order.getOrderId());
        orderDetailInfo.setRemark("获取订单");
        orderDetailInfo.setStatus(order.getStatus());
        orderDetailInfo.setStatusStr(order.getStatus() == 1 ? "未付款" : order.getStatus() == 2 ? "已付款" : order.getStatus() == 3 ? "未发货" : order.getStatus() == 4 ? "已发货" : order.getStatus() == 5 ? "交易成功" : "交易关闭");
        orderDetailInfo.setType("获取订单");
        orderDetailInfo.setUid("1");
        orderDetailInfo.setUserId(userId);
//        orderDetailInfo.setGoodReputation(Integer.parseInt(reputation.getReputation()));
//        orderDetailInfo.setGoodReputationRemark(reputation.getRemark());
//        orderDetailInfo.setGoodReputationStr(reputation.getReputation().substring(0, reputation.getReputation().length() > 20 ? 10 : reputation.getReputation().length()));


        List<LogisticsMapItem> logistics = new ArrayList<LogisticsMapItem>();
        //更加ID获取订单信息
        AddressTable addressTable = addressService.getAddressDefaultByUserId(userId);
        //获取订单
        LogisticsMapItem logisticsMapItem = new LogisticsMapItem();
        logisticsMapItem.setAddress(orderLogistics.getReceiverAddress());
        logisticsMapItem.setCityId(addressTable.getCityId());
        logisticsMapItem.setCode(orderLogistics.getReceiverZip());
        logisticsMapItem.setDateUpdate(orderLogistics.getUpdated());

        logisticsMapItem.setDistrictId(addressTable.getDistrictId());
        logisticsMapItem.setLinkMan(orderLogistics.getReceiverName());
        logisticsMapItem.setMobile(orderLogistics.getReceiverMobile());
        logisticsMapItem.setProvinceId(addressTable.getProvinceId());
        //物流状态
        logisticsMapItem.setStatus(order.getStatus());
        logistics.add(logisticsMapItem);

        if (goodsList == null) {
            return AppResponseResult.fail("订单为空");
        }
        if (goodsList == null) {
            return AppResponseResult.fail("商品为空");
        }
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setLogistics(logistics);
        orderDetailResponse.setOrderInfo(orderDetailInfo);
        orderDetailResponse.setGoods(goodsList);

        return new AppResponseResult<OrderDetailResponse>(200, orderDetailResponse, "succeed");

    }

    /**
     * 创建订单
     * @param orderCreateRquest 订单信息
     * @return
     * @throws Exception
     */
    @Override
    public AppResponseResult orderCreate(OrderCreateRquest orderCreateRquest) throws Exception {
        /**创建状态*/
        String initOrderId = "-1";
        String orderIdUpdate = orderCreateRquest.getOrderId();
        //订单配送地址
        String address = orderCreateRquest.getAddress();
        //联系人
        String linkMan = orderCreateRquest.getLinkMan();
        //配送类型
        Integer payOnDelivery = Integer.parseInt(orderCreateRquest.getPayOnDelivery() == null ? "1" : orderCreateRquest.getPayOnDelivery());
        //备注
        String remark = orderCreateRquest.getRemark();
        //用户登陆凭证
        String token = orderCreateRquest.getToken();
        //地址ID
        String addressId = orderCreateRquest.getAddressId();
        //获取地址
        AddressTable userAddress = addressService.getAddressById(addressId);

        //获取当前时间
        Date nowDate = DateUtil.getNowDate();

        //获取用户ID
        UserTable user = userService.getUserByToken(token);
        String userId = user.getId();

        //小程序端传入的商品信息
        List<GoodsJsonStr> goodsJsonStr = orderCreateRquest.getGoodsJsonStr();

        List<String> ls = new ArrayList<>();
        //商品信息按商家存起来
        Map<String, List<GoodsJsonStr>>  goodsJsonMap = new HashMap<>();
        //保存商家信息
        for(GoodsJsonStr goodsJsonItem:goodsJsonStr){
            String shopId = goodsJsonItem.getShopId();
            ls.add(shopId);
        }
        //去重排序
        List<String> shopIds = new ArrayList(new TreeSet(ls));
        //创建商家商品列表
        for(String sp:shopIds){
            goodsJsonMap.put(sp,new ArrayList<GoodsJsonStr>());
        }
        //遍历所有商家，把商品按商家来存储
        for(String sp:shopIds){
            //遍历所以商品
            for(GoodsJsonStr goodsJsonItem:goodsJsonStr){
                //把商品添加到指定商家Map中
                if(goodsJsonItem.getShopId().equals(sp)){
                    //获取原有List
                    List<GoodsJsonStr> goodsJsonStrs = goodsJsonMap.get(sp);
                    //添加新数
                    goodsJsonStrs.add(goodsJsonItem);
                    //重新设值
                    goodsJsonMap.put(sp,goodsJsonStrs);
                }
            }
        }
        //判断订单状态，initOrderID = - 1 则为创建状态，否则为更新状态
        if (TextUtils.isEmpty(orderIdUpdate)||initOrderId.equals(orderIdUpdate)) {
            StringBuffer buffer = new StringBuffer();
            //商品总价
            double totalPrice = 0.0;
            //商品总数量
            double totalNumber = 0;
            //根据不同商家创建订单
            for(String shopId:shopIds){
                //保存在数据库中的订单明细
                List<OrderItemTable> orderItemTables = new ArrayList<OrderItemTable>();
                String orderId = IdGenerator.getId();
                List<GoodsJsonStr> goodsJsonStrList = goodsJsonMap.get(shopId);
                buffer.append(orderId+",");
                //商品总价
                double totalPriceTemp = 0.0;
                //商品总数量
                double totalNumberTemp = 0;
                //获取订单商品详情,设置商品Item
                for (GoodsJsonStr goods : goodsJsonStrList) {
                    String goodsId = goods.getGoodsId();
                    //查询商品信息
                    GoodsTable goodsTable = goodsTableMapper.selectByPrimaryKey(goodsId);
                    //商家ID
                    String merchantId = goodsTable.getMerchantId();
                    //查询商品价格
                    double goodsPrice = Double.parseDouble(goodsTable.getGoodsPrice() == null ? "0" : goodsTable.getGoodsPrice());
                    //购买数量
                    int number = goods.getNumber();
                    totalNumber = totalNumber + number;
                    totalNumberTemp = totalNumberTemp+number;
                    //总价
                    totalPrice = totalPrice+ number * goodsPrice;
                    totalPriceTemp  = totalPriceTemp+number * goodsPrice;
                    //邀请用户ID
                    int inviterId = goods.getInviterId();
                    //物流类型
                    String logisticsType = goods.getLogisticsType();
                    //商品规格参数
                    String propertyChildIds = goods.getPropertyChildIds();

                    //订单商品信息
                    OrderItemTable orderItemTable = new OrderItemTable();
                    orderItemTable.setGoodsId(goodsId);
                    orderItemTable.setGoodsName(goodsTable.getGoodsName());
                    orderItemTable.setId(IdGenerator.getId());
                    orderItemTable.setOrderId(orderId);
                    orderItemTable.setOriginalPrice(goodsPrice);
                    orderItemTable.setPrice(goodsPrice);
                    orderItemTable.setPicPath(goodsTable.getGoodsPhoto());
                    orderItemTable.setTitle(goodsTable.getGoodsName());
                    orderItemTable.setTotalFee(goodsPrice);
                    orderItemTable.setNumber(number);
                    orderItemTables.add(orderItemTable);
                }

                OrderTable orderTable = new OrderTable();
                orderTable.setUserId(userId);

                //订单状态
                orderTable.setStatus(SystemStatusCode.ORDER_NO_PAY.getCode());
                orderTable.setOrderId(orderId);
                //用户信息
                orderTable.setBuyerMessage("暂无消息");
                orderTable.setBuyerNick(user.getUsername());
                orderTable.setBuyerRate(1);
                //实付金额
                orderTable.setPayment(totalPriceTemp + "");
                orderTable.setPaymentType(payOnDelivery);
                orderTable.setPostFee("0");
                //暂无配送信息
                orderTable.setShippingCode("");
                orderTable.setShippingName("");

                orderTable.setPaymentTime(nowDate);
                orderTable.setConsignTime(nowDate);
                orderTable.setCreateTime(nowDate);
                orderTable.setCloseTime(nowDate);
                orderTable.setEndTime(nowDate);
                orderTable.setUpdateTime(nowDate);
                orderTable.setRemark(TextUtils.isEmpty(remark)?"":remark);
                //订单物流信息
                OrderLogisticsTable orderLogisticsTable = new OrderLogisticsTable();
                orderLogisticsTable.setCreated(nowDate);
                orderLogisticsTable.setOrderId(orderId);
                orderLogisticsTable.setReceiverAddress(address);
                orderLogisticsTable.setReceiverCity(userAddress.getCityStr());
                orderLogisticsTable.setReceiverDistrict(userAddress.getDistrictStr());
                orderLogisticsTable.setReceiverName(userAddress.getLinkMan());
                orderLogisticsTable.setReceiverState(userAddress.getProvinceStr());
                orderLogisticsTable.setReceiverZip(userAddress.getCode());
                orderLogisticsTable.setUpdated(nowDate);

                orderMapper.insertSelective(orderTable);
                for (OrderItemTable orderItem : orderItemTables) {
                    orderItemMapper.insertSelective(orderItem);
                }
                orderLogisticsMapper.insertSelective(orderLogisticsTable);
            }

            //返回刚给小程序
            Map<String, Object> rep = new HashMap<>();
            //运费
            rep.put("priceLogistics", 0);
            //商品数量
            rep.put("goodsNumber", totalNumber);
            //是否需要物流信息
            rep.put("isNeedLogistics", false);
            //总价
            rep.put("priceTotle", totalPrice);
            rep.put("orderId", buffer.toString());
            return new AppResponseResult(200, rep, "succeed");

        } else {
            //商品总价
            double totalPrice = 0.0;
            //商品总数量
            double totalNumber = 0;
            //更新状态
            //计算价格
            for (GoodsJsonStr goods : goodsJsonStr) {
                String goodsId = goods.getGoodsId();
                //查询商品信息
                GoodsTable goodsTable = goodsTableMapper.selectByPrimaryKey(goodsId);
                //查询商品价格
                double goodsPrice = Double.parseDouble(goodsTable.getGoodsPrice() == null ? "0" : goodsTable.getGoodsPrice());
                //购买数量
                int number = goods.getNumber();
                totalNumber = totalNumber + number;
                //总价
                totalPrice = number * goodsPrice;
            }

            String[] split = orderIdUpdate.split(",");
            for(String id:split){
                //修改订单信息
                OrderTable mOrder =   new OrderTable();
                mOrder.setRemark(TextUtils.isEmpty(remark)?"暂无备注":remark);
                mOrder.setOrderId(id);
                mOrder.setUpdateTime(nowDate);
                orderMapper.updateByPrimaryKeySelective(mOrder);

                //修改订单物流信息
                OrderLogisticsTable orderLogisticsTable = new OrderLogisticsTable();
                orderLogisticsTable.setCreated(nowDate);
                orderLogisticsTable.setOrderId(id);
                orderLogisticsTable.setReceiverAddress(address);
                orderLogisticsTable.setReceiverCity(userAddress.getCityStr());
                orderLogisticsTable.setReceiverDistrict(userAddress.getDistrictStr());
                orderLogisticsTable.setReceiverName(userAddress.getLinkMan());
                orderLogisticsTable.setReceiverState(userAddress.getProvinceStr());
                orderLogisticsTable.setReceiverZip(userAddress.getCode());
                orderLogisticsTable.setUpdated(nowDate);
                orderLogisticsMapper.updateByPrimaryKeySelective(orderLogisticsTable);
            }



            //返回刚给小程序
            Map<String, Object> rep = new HashMap<>();
            //运费
            rep.put("priceLogistics", 0);
            //商品数量
            rep.put("goodsNumber", totalNumber);
            //是否需要物流信息
            rep.put("isNeedLogistics", false);
            //总价
            rep.put("priceTotle", totalPrice);
            rep.put("orderId", orderIdUpdate);
            return new AppResponseResult(200, rep, "succeed");
        }
    }

    /**
     * 获取订单列表
     *
     * @param orderRequest 订单请求参数
     * @param userId       用户ID
     * @return
     * @throws Exception
     */
    @Override
    public AppResponseResult<OrderResponse> getUserOrderListByUserId(OrderRequest orderRequest, String userId) throws Exception {
        Logger log = Logger.getLogger(InterfaceOrderServiceImpl.class);
        //传入的参数
        String orderNumber = orderRequest.getOrderNumber();
        int page = orderRequest.getPage();
        int pageSize = orderRequest.getPageSize();
        int status = orderRequest.getStatus();
        //设置重n,到ml列,分页设置
        PageHelper.startPage(page, pageSize);

        OrderTableExample example = new OrderTableExample();
        com.newretail.pojo.OrderTableExample.Criteria orderCriteria = example.createCriteria();
        orderCriteria.andUserIdEqualTo(userId);
        if (status != 0) {
            orderCriteria.andStatusEqualTo(status);
        }
        List<OrderTable> orders = orderMapper.selectByExample(example);

        PageInfo<OrderTable> pageInfo = new PageInfo<OrderTable>(orders);
        //获取分页后的数据
        List<OrderTable> orderList = pageInfo.getList();


        //订单
        ArrayList<OrderListItem> orderItems = new ArrayList<OrderListItem>();
        //商品信息
        Map<String, List<GoodsMapItem>> goodsMapItemMap = new HashMap<String, List<GoodsMapItem>>();
        //物流信息
        Map<String, List<LogisticsMapItem>> logisticsItemMap = new HashMap<String, List<LogisticsMapItem>>();
        AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
        double totalPrice = 0;
        //循环遍历每条订单
        for (OrderTable order : orderList) {
            String orderId = order.getOrderId();
            //获取订单商品信息
            OrderItemTableExample itemExample = new OrderItemTableExample();
            Criteria criteria = itemExample.createCriteria();
            criteria.andOrderIdEqualTo(orderId);
            //订单明细
            List<OrderItemTable> orderItemList = orderItemMapper.selectByExample(itemExample);
            //物流信息
            OrderLogisticsTable orderLogistics = orderLogisticsMapper.selectByPrimaryKey(orderId);
            //商品Map
            List<GoodsMapItem> GoodsMapItems = new ArrayList<GoodsMapItem>();

            //订单商品信息
            for (OrderItemTable orderItem : orderItemList) {

                GoodsTable goods = goodsTableMapper.selectByPrimaryKey(orderItem.getGoodsId());
                String goodsPhoto = goods.getGoodsPhoto();
                //商品总价
                totalPrice = totalPrice+(Double.parseDouble(goods.getGoodsPrice()==null?"0":goods.getGoodsPrice()))*orderItem.getNumber();
                String imageSignUrl = aliyunOssUtils.getImageSignUrl(goodsPhoto);
                //商品信息
                GoodsMapItem goodsMapItem = new GoodsMapItem();
                goodsMapItem.setPrice(orderItem.getPrice());
                goodsMapItem.setGoodsId(orderItem.getGoodsId());
                goodsMapItem.setGoodsName(orderItem.getGoodsName());
                goodsMapItem.setId(orderItem.getId());
                goodsMapItem.setOrderId(orderId);
                goodsMapItem.setPic(imageSignUrl);
                GoodsMapItems.add(goodsMapItem);

            }

            //订单信息
            OrderListItem orderListItem = new OrderListItem();
            orderListItem.setPrice(totalPrice);
            orderListItem.setPriceLogistics(totalPrice);
            orderListItem.setPriceReal(totalPrice);
            String dateTime = DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", order.getCreateTime());
            orderListItem.setDateAdd(dateTime);
            orderListItem.setId(order.getOrderId());
            orderListItem.setOrderNumber("TSO"+order.getOrderId());
            orderListItem.setRemark("获取订单");
            orderListItem.setStatus(order.getStatus());
            orderListItem.setStatusStr(order.getStatus() == 1 ? "未付款" : order.getStatus() == 2 ? "已付款" : order.getStatus() == 3 ? "未发货" : order.getStatus() == 4 ? "已发货" : order.getStatus() == 5 ? "交易成功" : "交易关闭");
            orderListItem.setType("获取订单");
            orderListItem.setUid(1);
            orderListItem.setUserId(userId);
            orderItems.add(orderListItem);

            //----------------------------------
            goodsMapItemMap.put(orderId, GoodsMapItems);
            AddressTable addressTable = null;
            List<LogisticsMapItem> logistics = new ArrayList<LogisticsMapItem>();
            try {
                addressTable = addressService.getAddressDefaultByUserId(userId);

                LogisticsMapItem logisticsMapItem = new LogisticsMapItem();
                logisticsMapItem.setAddress(orderLogistics.getReceiverAddress());
                logisticsMapItem.setCityId(addressTable.getCityId());
                try {
                    logisticsMapItem.setCode(orderLogistics.getReceiverZip() == null ? "" : orderLogistics.getReceiverZip());
                    logisticsMapItem.setDateUpdate(orderLogistics.getUpdated());
                    logisticsMapItem.setDistrictId(addressTable.getDistrictId());
                    logisticsMapItem.setLinkMan(orderLogistics.getReceiverName());
                    logisticsMapItem.setMobile(orderLogistics.getReceiverMobile());
                    logisticsMapItem.setProvinceId(addressTable.getProvinceId());
                    logisticsMapItem.setStatus(1);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                logistics.add(logisticsMapItem);
            } catch (Exception e) {
                log.error("==========出错==========" + e.getMessage());
            }
            logisticsItemMap.put(orderId, logistics);
        }
        aliyunOssUtils.destory();
        OrderResponse orderListResponse = new OrderResponse();
        orderListResponse.setGoodsMap(goodsMapItemMap);
        orderListResponse.setLogisticsMap(logisticsItemMap);
        orderListResponse.setOrderList(orderItems);
        AppResponseResult<OrderResponse> appResponseResult = new AppResponseResult<OrderResponse>();
        appResponseResult.setCode(200);
        appResponseResult.setData(orderListResponse);
        appResponseResult.setMsg("succeed");
        return appResponseResult;
    }

}
