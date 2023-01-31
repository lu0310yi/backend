package com.mypro.mapper;

import com.mypro.beans.Attraction;
import com.mypro.beans.AttractionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttractionMapper {
    int countByExample(AttractionExample example);

    int deleteByExample(AttractionExample example);

    int deleteByPrimaryKey(Long attractionId);

    int insert(Attraction record);

    int insertSelective(Attraction record);

    List<Attraction> selectByExample(AttractionExample example);
    List<Attraction> selectByIdList(List idList);

    Attraction selectByPrimaryKey(Long attractionId);

    int updateByExampleSelective(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByExample(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByPrimaryKeySelective(Attraction record);

    int updateByPrimaryKey(Attraction record);

    List<Attraction> selectByKey(String key, Integer filter, String order);

    List<Attraction>  selectByRecommend();
}