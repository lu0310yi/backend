package com.mypro.mapper;

import com.mypro.beans.Relationship;
import com.mypro.beans.RelationshipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RelationshipMapper {
    int countByExample(RelationshipExample example);

    int deleteByExample(RelationshipExample example);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    List<Relationship> selectByExample(RelationshipExample example);

    int updateByExampleSelective(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByExample(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    List<Long> selectObjIdBySubId(Long userId,char type);

    List<Long> selectSubIdByObjId(Long userId);
    String selectStatus(Long userId,Long friendId);
}