package com.newretail.mapper;

import com.newretail.pojo.GoodsEvaluationTable;
import com.newretail.pojo.GoodsEvaluationTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsEvaluationTableMapper {
    int countByExample(GoodsEvaluationTableExample example);

    int deleteByExample(GoodsEvaluationTableExample example);

    int deleteByPrimaryKey(String evaluateId);

    int insert(GoodsEvaluationTable record);

    int insertSelective(GoodsEvaluationTable record);

    List<GoodsEvaluationTable> selectByExample(GoodsEvaluationTableExample example);

    GoodsEvaluationTable selectByPrimaryKey(String evaluateId);

    int updateByExampleSelective(@Param("record") GoodsEvaluationTable record, @Param("example") GoodsEvaluationTableExample example);

    int updateByExample(@Param("record") GoodsEvaluationTable record, @Param("example") GoodsEvaluationTableExample example);

    int updateByPrimaryKeySelective(GoodsEvaluationTable record);

    int updateByPrimaryKey(GoodsEvaluationTable record);
}