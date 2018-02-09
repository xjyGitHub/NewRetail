package com.newretail.mapper;

import com.newretail.pojo.GoodsCatTable;
import com.newretail.pojo.GoodsCatTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCatTableMapper {
    int countByExample(GoodsCatTableExample example);

    int deleteByExample(GoodsCatTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCatTable record);

    int insertSelective(GoodsCatTable record);

    List<GoodsCatTable> selectByExample(GoodsCatTableExample example);

    GoodsCatTable selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCatTable record, @Param("example") GoodsCatTableExample example);

    int updateByExample(@Param("record") GoodsCatTable record, @Param("example") GoodsCatTableExample example);

    int updateByPrimaryKeySelective(GoodsCatTable record);

    int updateByPrimaryKey(GoodsCatTable record);
}