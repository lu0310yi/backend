package com.mypro.service.serviceImpl;

import com.mypro.beans.Comment;
import com.mypro.beans.CommentExample;
import com.mypro.beans.PacShip;
import com.mypro.beans.PacShipExample;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.CommentMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.CommentService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    PacShipMapper pacShipMapper;
    @Override
    public List<Comment> getReplies(Long commentId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPacIdEqualTo(commentId).andTypeEqualTo("2");
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public void thumbup(Long commentId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId).
                andPacIdEqualTo(commentId).andPacTypeEqualTo("2").andTypeEqualTo("1");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            throw new ServiceException(ReturnCode.RC500.getCode(), "您已点赞该内容");
        }
        pacShipMapper.insert(new PacShip(userId,commentId,"1",null,new Date(),"2"));
    }

    @Override
    public void reply(Comment comment) {
        Long userId = TokenUtil.getUserId();
        comment.setUserId(userId);
        comment.setGmtCreate(new Date());
        comment.setReplyCount(0);
        comment.setThumbupCount(0);
        commentMapper.insert(comment);
    }

    @Override
    public void delete(Long commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public void unthumbup(Long commentId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId).andPacIdEqualTo(commentId).andPacTypeEqualTo("2").andTypeEqualTo("1");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            pacShipMapper.deleteByExample(pacShipExample);
            return;
        }
        throw new ServiceException(ReturnCode.RC500.getCode(), "您并未点赞该comment");
    }
}
