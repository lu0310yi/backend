package com.mypro.service.serviceImpl;

import com.mypro.beans.*;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.CollectionMapper;
import com.mypro.mapper.CommentMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.mapper.PostMapper;
import com.mypro.resultHandle.ReturnCode;
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
        comment.setUserId(TokenUtil.getUserId());
        comment.setType("0");
        commentMapper.insertSelective(comment);
    }

    @Override
    public void thumbup(Long postId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId).andPacIdEqualTo(postId).andPacTypeEqualTo("0");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            PacShip pacShip = pacShipList.get(0);
            pacShip.setType("1");
            pacShipMapper.updateByExampleSelective(pacShip,pacShipExample);
            return;
        }
        pacShipMapper.insert(new PacShip(userId,postId,"1",null,new Date(),"0"));
    }
    @Override
    public void collect(Collection collection) {
        Long userId = TokenUtil.getUserId();
        collection.setUserId(userId);
        if("1".equals(collection.getType())) {
            CollectionExample collectionExample = new CollectionExample();
            collectionExample.createCriteria().andTypeEqualTo(collection.getType())
                    .andUserIdEqualTo(userId).andPostArticleIdEqualTo(collection.getPostArticleId()).
                    andFolderIdEqualTo(collection.getFolderId());
            List<Collection> collectionList = collectionMapper.selectByExample(collectionExample);
            if (collectionList.size() <= 0) {
                collectionMapper.insert(collection);
                Long paId = collection.getPostArticleId();
                String type = "2";
                Date gmtOperation = new Date(System.currentTimeMillis());
                Long folderId = collection.getFolderId();
                String paType = "0";
                pacShipMapper.insert(new PacShip(userId, paId, type, folderId, gmtOperation, paType));
            }
        }
        else{
            throw new ServiceException(ReturnCode.RC400.getCode(), "不是post");
        }
    }

    @Override
    public List<Comment> getComments(Long postId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPacIdEqualTo(postId).andTypeEqualTo("0");
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public Post info(Long postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    @Override
    public void publishPost(Post post) {
        post.setAuthorId(TokenUtil.getUserId());
        post.setGmtCreate(new Date());
        post.setGmtEdit(new Date());
        postMapper.insertSelective(post);
    }

    @Override
    public void deletePost(Long postId) {
        postMapper.deleteByPrimaryKey(postId);
    }

    @Override
    public void updatePost(Post post) {
        post.setAuthorId(TokenUtil.getUserId());
        post.setGmtEdit(new Date());
        if(postMapper.selectByPrimaryKey(post.getPostId())!=null){
            postMapper.updateByPrimaryKeySelective(post);
        }else{
            post.setGmtCreate(new Date());
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
