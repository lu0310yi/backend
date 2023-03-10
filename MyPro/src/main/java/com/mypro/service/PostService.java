package com.mypro.service;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Collection;
import com.mypro.beans.Comment;
import com.mypro.beans.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getPosts(Long userId);

    void comment(Comment comment);

    void thumbup(Long postId);

    void collect(Collection collection);

    List<Comment> getComments(Long postId);

    Post info(Long postId);

    void publishPost(Post post);

    void deletePost(Long postId);

    void updatePost(Post post);

    Boolean isthumbup(Long postId);

    List<Collection> iscollect(Long postId);

    PageInfo<Post> findPostByKey(String key, Integer filter, String order, Integer pageSize, Integer pageNum);

    PageInfo<Post> recommend(Integer pageNum, Integer pageSize);

    void uncollect(Collection collection);

    void unthumbup(Long postId);
}
