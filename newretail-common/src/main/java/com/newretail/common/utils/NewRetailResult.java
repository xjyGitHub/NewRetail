package com.newretail.common.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义响应结构
 */
public class NewRetailResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    /** AJAX操作响应：操作成功 */
    public static final Integer RESULT_SUCCESS = 200;

    /** AJAX操作响应：操作失败 */
    public static final Integer RESULT_FAILED = 300;

    /** AJAX操作响应：超时 */
    public static final Integer RESULT_TIMEOUT = 301;
    
    /** AJAX操作响应：操作成功 */
    public static final String MESSAGE_SUCCESS = "操作成功";

    /** AJAX操作响应：操作失败 */
    public static final String MESSAGE_FAILED = "操作失败";

    // 响应业务状态
    private Integer status;
    //
    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static NewRetailResult build(Integer status, String msg, Object data) {
        return new NewRetailResult(status, msg, data);
    }

    public static NewRetailResult ok(Object data) {
        return new NewRetailResult(data);
    }

    public static NewRetailResult ok() {
        return new NewRetailResult(null);
    }

    public NewRetailResult() {
    	this.status = RESULT_SUCCESS;
    }

    public static NewRetailResult build(Integer status, String msg) {
        return new NewRetailResult(status, msg, null);
    }

    public NewRetailResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public NewRetailResult(Object data) {
        this.status = RESULT_SUCCESS;
        this.msg = MESSAGE_SUCCESS;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为TaotaoResult对象
     * 
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static NewRetailResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, NewRetailResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static NewRetailResult format(String json) {
        try {
            return MAPPER.readValue(json, NewRetailResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static NewRetailResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
