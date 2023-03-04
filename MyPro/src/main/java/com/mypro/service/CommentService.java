package com.mypro.service;

import com.mypro.beans.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getReplies(Long commentId);

    void thumbup(Long commentId);

    void reply(Comment comment);

    void delete(Long commentId);

    void unthumbup(Long commentId);
}
