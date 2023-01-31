package com.mypro.mapper;

import com.mypro.beans.PacShip;
import com.mypro.beans.PacShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PacShipMapper {
    int countByExample(PacShipExample example);

    int deleteByExample(PacShipExample example);

    int insert(PacShip record);

    int insertSelective(PacShip record);

    List<PacShip> selectByExample(PacShipExample example);

    int updateByExampleSelective(@Param("record") PacShip record, @Param("example") PacShipExample example);

    int updateByExample(@Param("record") PacShip record, @Param("example") PacShipExample example);
}