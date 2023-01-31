package com.mypro.service.serviceImpl;

import com.mypro.beans.*;
import com.mypro.mapper.ArticleMapper;
import com.mypro.mapper.CollectionMapper;
import com.mypro.mapper.CommentMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.service.ArticleService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    PacShipMapper pacShipMapper;
    @Override
    public List<Article> getArticles(Long userId) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andAuthorIdEqualTo(userId);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public Article info(Long articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public List<Comment> getComments(Long articleId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andPacIdEqualTo(articleId);
        return commentMapper.selectByExample(commentExample);
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
    public void comment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void publish(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void delete(Long articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public void update(Article article) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andArticleIdEqualTo(article.getArticleId());
        if(articleMapper.updateByExampleSelective(article,articleExample)==0){
            articleMapper.insert(article);
        }
    }

    @Override
    public void thumbup(Long articleID) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId).andPacIdEqualTo(articleID).andPacTypeEqualTo("1");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            PacShip pacShip = pacShipList.get(0);
            pacShip.setType("1");
            pacShipMapper.updateByExampleSelective(pacShip,pacShipExample);
            return;
        }
        pacShipMapper.insert(new PacShip(userId,articleID,"1",null,new Date(),"1"));
    }

    @Override
    public Boolean isthumbup(Long articleId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andPacTypeEqualTo("1").andPacIdEqualTo(articleId).andUserIdEqualTo(userId);
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
    public List<Collection> iscollect(Long articleId) {
        Long useId = TokenUtil.getUserId();
        CollectionExample collectionExample = new CollectionExample();
        collectionExample.createCriteria().andUserIdEqualTo(useId).andPostArticleIdEqualTo(articleId).andTypeEqualTo("0");
        return collectionMapper.selectByExample(collectionExample);
    }
}
