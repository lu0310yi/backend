package com.mypro.mapper;

import com.mypro.beans.AttractionScore;
import com.mypro.beans.AttractionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttractionScoreMapper {
    int countByExample(AttractionScoreExample example);

    int deleteByExample(AttractionScoreExample example);

    int insert(AttractionScore record);

    int insertSelective(AttractionScore record);

    List<AttractionScore> selectByExample(AttractionScoreExample example);

    int updateByExampleSelective(@Param("record") AttractionScore record, @Param("example") AttractionScoreExample example);

    int updateByExample(@Param("record") AttractionScore record, @Param("example") AttractionScoreExample example);
}