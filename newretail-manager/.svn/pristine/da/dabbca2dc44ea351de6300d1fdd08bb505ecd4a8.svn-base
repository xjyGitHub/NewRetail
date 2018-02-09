package com.newretail.mapper;

import com.newretail.pojo.AddressTable;
import com.newretail.pojo.AddressTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressTableMapper {
    int countByExample(AddressTableExample example);

    int deleteByExample(AddressTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(AddressTable record);

    int insertSelective(AddressTable record);

    List<AddressTable> selectByExample(AddressTableExample example);

    AddressTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AddressTable record, @Param("example") AddressTableExample example);

    int updateByExample(@Param("record") AddressTable record, @Param("example") AddressTableExample example);

    int updateByPrimaryKeySelective(AddressTable record);

    int updateByPrimaryKey(AddressTable record);
}