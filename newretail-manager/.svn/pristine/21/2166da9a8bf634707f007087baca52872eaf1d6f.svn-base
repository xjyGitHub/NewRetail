package com.newretail.mapper;

import com.newretail.pojo.UserAdminTable;
import com.newretail.pojo.UserAdminTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminTableMapper {
    int countByExample(UserAdminTableExample example);

    int deleteByExample(UserAdminTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserAdminTable record);

    int insertSelective(UserAdminTable record);

    List<UserAdminTable> selectByExample(UserAdminTableExample example);

    UserAdminTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserAdminTable record, @Param("example") UserAdminTableExample example);

    int updateByExample(@Param("record") UserAdminTable record, @Param("example") UserAdminTableExample example);

    int updateByPrimaryKeySelective(UserAdminTable record);

    int updateByPrimaryKey(UserAdminTable record);
}