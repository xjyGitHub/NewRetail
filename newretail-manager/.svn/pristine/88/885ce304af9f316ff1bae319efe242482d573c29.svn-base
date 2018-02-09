package com.newretail.mapper;

import com.newretail.pojo.CityTable;
import com.newretail.pojo.CityTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityTableMapper {
    int countByExample(CityTableExample example);

    int deleteByExample(CityTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityTable record);

    int insertSelective(CityTable record);

    List<CityTable> selectByExample(CityTableExample example);

    CityTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityTable record, @Param("example") CityTableExample example);

    int updateByExample(@Param("record") CityTable record, @Param("example") CityTableExample example);

    int updateByPrimaryKeySelective(CityTable record);

    int updateByPrimaryKey(CityTable record);
}