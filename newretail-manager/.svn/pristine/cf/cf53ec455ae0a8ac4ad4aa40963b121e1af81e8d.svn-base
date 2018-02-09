package com.newretail.mapper;

import com.newretail.pojo.OrderTable;
import com.newretail.pojo.OrderTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTableMapper {
    int countByExample(OrderTableExample example);

    int deleteByExample(OrderTableExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderTable record);

    int insertSelective(OrderTable record);

    List<OrderTable> selectByExample(OrderTableExample example);

    OrderTable selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    int updateByExample(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    int updateByPrimaryKeySelective(OrderTable record);

    int updateByPrimaryKey(OrderTable record);
}