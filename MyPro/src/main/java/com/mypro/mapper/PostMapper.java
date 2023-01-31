package com.mypro.mapper;

import com.mypro.beans.Post;
import com.mypro.beans.PostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    int countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Long postId);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExample(PostExample example);
    List<Post> selectByAuthorId(Long userId);
    Post selectByPrimaryKey(Long postId);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}