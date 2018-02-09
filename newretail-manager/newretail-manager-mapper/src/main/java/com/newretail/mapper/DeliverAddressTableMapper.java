package com.newretail.mapper;

import com.newretail.pojo.DeliverAddressTable;
import com.newretail.pojo.DeliverAddressTableExample;
import com.newretail.pojo.DeliverAddressTableKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliverAddressTableMapper {
    int countByExample(DeliverAddressTableExample example);

    int deleteByExample(DeliverAddressTableExample example);

    int deleteByPrimaryKey(DeliverAddressTableKey key);

    int insert(DeliverAddressTable record);

    int insertSelective(DeliverAddressTable record);

    List<DeliverAddressTable> selectByExample(DeliverAddressTableExample example);

    DeliverAddressTable selectByPrimaryKey(DeliverAddressTableKey key);

    int updateByExampleSelective(@Param("record") DeliverAddressTable record, @Param("example") DeliverAddressTableExample example);

    int updateByExample(@Param("record") DeliverAddressTable record, @Param("example") DeliverAddressTableExample example);

    int updateByPrimaryKeySelective(DeliverAddressTable record);

    int updateByPrimaryKey(DeliverAddressTable record);
}