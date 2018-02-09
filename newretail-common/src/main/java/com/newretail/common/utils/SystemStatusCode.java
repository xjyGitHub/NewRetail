package com.newretail.common.utils;

/**
 * 定义系统状态，所有系统状态都应该在这里定义
 * 定义枚举
 */
public enum SystemStatusCode {
    //-------------------订单状态-------------------
    /**未付款*/
    ORDER_NO_PAY(1),
    /**已付款*/
    ORDER_IS_PAY(2),
    /**未发货*/
    ORDER_UN_DELIVER(3),
    /**已发货*/
    ORDER_CONFIRM_DELIVER(4),
    /**交易成功*/
    ORDER_SUCCEED(5),
    /**交易关闭*/
    ORDER_CLOASE(6),
    //------------------用户类型-------------
    /**普通用户*/
    USER_ORDINARY(1),
    /**商家*/
    USER_SELLER(2),
    /**配送员*/
    USER_DELIVER(3),
    /**配送员*/
    USER_ADMIN(4);

    private Integer code;
    /**
     * 获取状态码
     * @return
     */
    public Integer getCode() {
        return this.code;
    }

    private SystemStatusCode(Integer code) {
        this.code = code;
    }
}
