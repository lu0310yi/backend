package com.mypro.mapper;

import com.mypro.beans.AttractionShip;
import com.mypro.beans.AttractionShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttractionShipMapper {
    int countByExample(AttractionShipExample example);

    int deleteByExample(AttractionShipExample example);

    int insert(AttractionShip record);

    int insertSelective(AttractionShip record);

    List<AttractionShip> selectByExample(AttractionShipExample example);
    List<Long> selectAttractionIdByUserId(Long userId);

    int updateByExampleSelective(@Param("record") AttractionShip record, @Param("example") AttractionShipExample example);

    int updateByExample(@Param("record") AttractionShip record, @Param("example") AttractionShipExample example);

    List<Long> selectVisitedByUserId(Long userId);

    List<Long> selectWantByUserId(Long userId);

    String selectStatus(Long userId, Long attractionId);
}