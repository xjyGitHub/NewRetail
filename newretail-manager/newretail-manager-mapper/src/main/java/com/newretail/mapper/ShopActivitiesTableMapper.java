package com.newretail.mapper;

import com.newretail.pojo.ShopActivitiesTable;
import com.newretail.pojo.ShopActivitiesTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopActivitiesTableMapper {
    int countByExample(ShopActivitiesTableExample example);

    int deleteByExample(ShopActivitiesTableExample example);

    int insert(ShopActivitiesTable record);

    int insertSelective(ShopActivitiesTable record);

    List<ShopActivitiesTable> selectByExample(ShopActivitiesTableExample example);

    int updateByExampleSelective(@Param("record") ShopActivitiesTable record, @Param("example") ShopActivitiesTableExample example);

    int updateByExample(@Param("record") ShopActivitiesTable record, @Param("example") ShopActivitiesTableExample example);
}