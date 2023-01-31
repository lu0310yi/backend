package com.mypro.mapper;

import com.mypro.beans.FavoritesShip;
import com.mypro.beans.FavoritesShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoritesShipMapper {
    int countByExample(FavoritesShipExample example);

    int deleteByExample(FavoritesShipExample example);

    int insert(FavoritesShip record);

    int insertSelective(FavoritesShip record);

    List<FavoritesShip> selectByExample(FavoritesShipExample example);

    int updateByExampleSelective(@Param("record") FavoritesShip record, @Param("example") FavoritesShipExample example);

    int updateByExample(@Param("record") FavoritesShip record, @Param("example") FavoritesShipExample example);
}