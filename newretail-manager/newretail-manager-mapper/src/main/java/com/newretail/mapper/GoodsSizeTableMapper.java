package com.newretail.mapper;

import com.newretail.pojo.GoodsSizeTable;
import com.newretail.pojo.GoodsSizeTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSizeTableMapper {
    int countByExample(GoodsSizeTableExample example);

    int deleteByExample(GoodsSizeTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(GoodsSizeTable record);

    int insertSelective(GoodsSizeTable record);

    List<GoodsSizeTable> selectByExample(GoodsSizeTableExample example);

    GoodsSizeTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GoodsSizeTable record, @Param("example") GoodsSizeTableExample example);

    int updateByExample(@Param("record") GoodsSizeTable record, @Param("example") GoodsSizeTableExample example);

    int updateByPrimaryKeySelective(GoodsSizeTable record);

    int updateByPrimaryKey(GoodsSizeTable record);
}