package com.newretail.mapper;

import com.newretail.pojo.OrderItemTable;
import com.newretail.pojo.OrderItemTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemTableMapper {
    int countByExample(OrderItemTableExample example);

    int deleteByExample(OrderItemTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderItemTable record);

    int insertSelective(OrderItemTable record);

    List<OrderItemTable> selectByExample(OrderItemTableExample example);

    OrderItemTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderItemTable record, @Param("example") OrderItemTableExample example);

    int updateByExample(@Param("record") OrderItemTable record, @Param("example") OrderItemTableExample example);

    int updateByPrimaryKeySelective(OrderItemTable record);

    int updateByPrimaryKey(OrderItemTable record);
}