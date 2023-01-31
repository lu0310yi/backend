package com.mypro.service.serviceImpl;

import com.mypro.beans.Comment;
import com.mypro.beans.CommentExample;
import com.mypro.mapper.CommentMapper;
import com.mypro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> getReplies(Long commentId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPacIdEqualTo(commentId);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public void thumbup(Long commentId) {

    }

    @Override
    public void reply(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void delete(Long commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }
}
