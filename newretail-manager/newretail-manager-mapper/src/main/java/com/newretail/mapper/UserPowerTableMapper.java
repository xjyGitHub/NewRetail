package com.newretail.mapper;

import com.newretail.pojo.UserPowerTable;
import com.newretail.pojo.UserPowerTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPowerTableMapper {
    int countByExample(UserPowerTableExample example);

    int deleteByExample(UserPowerTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPowerTable record);

    int insertSelective(UserPowerTable record);

    List<UserPowerTable> selectByExample(UserPowerTableExample example);

    UserPowerTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPowerTable record, @Param("example") UserPowerTableExample example);

    int updateByExample(@Param("record") UserPowerTable record, @Param("example") UserPowerTableExample example);

    int updateByPrimaryKeySelective(UserPowerTable record);

    int updateByPrimaryKey(UserPowerTable record);
}