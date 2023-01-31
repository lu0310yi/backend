package com.mypro.mapper;

import com.mypro.beans.Chatter;
import com.mypro.beans.ChatterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatterMapper {
    int countByExample(ChatterExample example);

    int deleteByExample(ChatterExample example);

    int insert(Chatter record);

    int insertSelective(Chatter record);

    List<Chatter> selectByExample(ChatterExample example);

    int updateByExampleSelective(@Param("record") Chatter record, @Param("example") ChatterExample example);

    int updateByExample(@Param("record") Chatter record, @Param("example") ChatterExample example);
}