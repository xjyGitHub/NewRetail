package com.newretail.mapper;

import com.newretail.pojo.OrderReputationsTable;
import com.newretail.pojo.OrderReputationsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReputationsTableMapper {
    int countByExample(OrderReputationsTableExample example);

    int deleteByExample(OrderReputationsTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderReputationsTable record);

    int insertSelective(OrderReputationsTable record);

    List<OrderReputationsTable> selectByExample(OrderReputationsTableExample example);

    OrderReputationsTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderReputationsTable record, @Param("example") OrderReputationsTableExample example);

    int updateByExample(@Param("record") OrderReputationsTable record, @Param("example") OrderReputationsTableExample example);

    int updateByPrimaryKeySelective(OrderReputationsTable record);

    int updateByPrimaryKey(OrderReputationsTable record);
}