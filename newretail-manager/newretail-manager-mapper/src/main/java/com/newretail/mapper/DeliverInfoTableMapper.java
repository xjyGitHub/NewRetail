package com.newretail.mapper;

import com.newretail.pojo.DeliverInfoTable;
import com.newretail.pojo.DeliverInfoTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliverInfoTableMapper {
    int countByExample(DeliverInfoTableExample example);

    int deleteByExample(DeliverInfoTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(DeliverInfoTable record);

    int insertSelective(DeliverInfoTable record);

    List<DeliverInfoTable> selectByExample(DeliverInfoTableExample example);

    DeliverInfoTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DeliverInfoTable record, @Param("example") DeliverInfoTableExample example);

    int updateByExample(@Param("record") DeliverInfoTable record, @Param("example") DeliverInfoTableExample example);

    int updateByPrimaryKeySelective(DeliverInfoTable record);

    int updateByPrimaryKey(DeliverInfoTable record);
}