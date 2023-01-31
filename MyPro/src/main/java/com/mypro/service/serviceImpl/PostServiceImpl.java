package com.mypro.service.serviceImpl;

import com.mypro.beans.*;
import com.mypro.mapper.CollectionMapper;
import com.mypro.mapper.CommentMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.mapper.PostMapper;
import com.mypro.service.PostService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    PacShipMapper pacShipMapper;
    @Autowired
    CollectionMapper collectionMapper;
    @Override
    public List<Post> getPosts(Long userId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andAuthorIdEqualTo(userId);
        return postMapper.selectByExample(postExample);

    }

    @Override
    public void comment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void thumbup(Long postId) {

    }

    @Override
    public void collect(Collection collection) {
        collectionMapper.insert(collection);
        Long userId = collection.getUserId();
        Long pacId = collection.getPostArticleId();
        String type = "2";
        Date gmtOperation = new Date(System.currentTimeMillis());
        Long folderId = collection.getFolderId();
        String pacType = collection.getType();
        pacShipMapper.insert(new PacShip(userId,pacId,type,folderId,gmtOperation,pacType));
    }

    @Override
    public List<Comment> getComments(Long postId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPacIdEqualTo(postId);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public Post info(Long postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    @Override
    public void publishPost(Post post) {
        if(postMapper.selectByPrimaryKey(post.getPostId())==null) {
            post.setAuthorId(TokenUtil.getUserId());
            postMapper.insert(post);
        }
    }

    @Override
    public void deletePost(Long postId) {
        postMapper.deleteByPrimaryKey(postId);
    }

    @Override
    public void updatePost(Post post) {
        if(postMapper.updateByPrimaryKeySelective(post)==0){
            postMapper.insert(post);
        }
    }

    @Override
    public Boolean isthumbup(Long postId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andPacTypeEqualTo("0").andPacIdEqualTo(postId).andUserIdEqualTo(userId);
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            PacShip pacShip = pacShipList.get(0);
            if("1".equals(pacShip.getType())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Collection>  iscollect(Long postId) {
        Long useId = TokenUtil.getUserId();
        CollectionExample collectionExample = new CollectionExample();
        collectionExample.createCriteria().andUserIdEqualTo(useId).andPostArticleIdEqualTo(postId).andTypeEqualTo("1");
        return collectionMapper.selectByExample(collectionExample);
    }
}
