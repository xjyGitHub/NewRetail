package com.newretail.mapper;

import com.newretail.pojo.OrderLogisticsTable;
import com.newretail.pojo.OrderLogisticsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLogisticsTableMapper {
    int countByExample(OrderLogisticsTableExample example);

    int deleteByExample(OrderLogisticsTableExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderLogisticsTable record);

    int insertSelective(OrderLogisticsTable record);

    List<OrderLogisticsTable> selectByExample(OrderLogisticsTableExample example);

    OrderLogisticsTable selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderLogisticsTable record, @Param("example") OrderLogisticsTableExample example);

    int updateByExample(@Param("record") OrderLogisticsTable record, @Param("example") OrderLogisticsTableExample example);

    int updateByPrimaryKeySelective(OrderLogisticsTable record);

    int updateByPrimaryKey(OrderLogisticsTable record);
}