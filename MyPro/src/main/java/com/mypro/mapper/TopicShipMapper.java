package com.mypro.mapper;

import com.mypro.beans.TopicShip;
import com.mypro.beans.TopicShipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TopicShipMapper {
    int countByExample(TopicShipExample example);

    int deleteByExample(TopicShipExample example);

    int insert(TopicShip record);

    int insertSelective(TopicShip record);

    List<TopicShip> selectByExample(TopicShipExample example);

    int updateByExampleSelective(@Param("record") TopicShip record, @Param("example") TopicShipExample example);

    int updateByExample(@Param("record") TopicShip record, @Param("example") TopicShipExample example);
    List<Long> selectTopicByUserId(@Param("userId")Long userId);
}