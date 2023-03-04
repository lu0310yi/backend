package com.mypro.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.beans.*;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.ArticleMapper;
import com.mypro.mapper.CollectionMapper;
import com.mypro.mapper.CommentMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.resultHandle.ReturnCode;
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

    @Override
    public PageInfo<Article> findArticleByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum) {
        PageHelper.startPage(pagenum,pagesize);
        List list = articleMapper.selectByKey(key,filter,order);
        return new PageInfo<Article>(list,1);
    }

    @Override
    public PageInfo<Article> recommend(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List list = articleMapper.selectByRecommend();
        return new PageInfo<Article>(list,1);
    }
//    @Override
//    public void collect(Collection collection) {
//        collectionMapper.insert(collection);
//        Long userId = collection.getUserId();
//        Long pacId = collection.getPostArticleId();
//        String type = "2";
//        Date gmtOperation = new Date(System.currentTimeMillis());
//        Long folderId = collection.getFolderId();
//        String pacType = collection.getType();
//        pacShipMapper.insert(new PacShip(userId,pacId,type,folderId,gmtOperation,pacType));
//    }
    @Override
    public void collect(Collection collection) {
        Long userId = TokenUtil.getUserId();
        collection.setUserId(userId);
        if("0".equals(collection.getType())) {
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
                String paType = "1";
                pacShipMapper.insert(new PacShip(userId, paId, type, folderId, gmtOperation, paType));
            }else{
                throw new ServiceException(ReturnCode.RC500.getCode(),"该收藏记录已经存在" );
            }
        }
        else{
            throw new ServiceException(ReturnCode.RC400.getCode(), "不是article");
        }
    }

    @Override
    public void uncollect(Collection collection) {
        Long userId = TokenUtil.getUserId();
        if(userId!=collection.getUserId()){
            throw new ServiceException(ReturnCode.RC401.getCode(), "您不是该收藏的主人，无权取消收藏该article");
        }
        if("0".equals(collection.getType())) {
            CollectionExample collectionExample = new CollectionExample();
            collectionExample.createCriteria().andTypeEqualTo(collection.getType())
                    .andUserIdEqualTo(userId).andPostArticleIdEqualTo(collection.getPostArticleId()).
                    andFolderIdEqualTo(collection.getFolderId());
            List<Collection> collectionList = collectionMapper.selectByExample(collectionExample);
            if (collectionList.size() > 0) {
                collectionMapper.deleteByExample(collectionExample);
                Long paId = collection.getPostArticleId();
                Long folderId = collection.getFolderId();
                PacShipExample pacShipExample = new PacShipExample();
                pacShipExample.createCriteria().andPacTypeEqualTo("1").andPacIdEqualTo(paId).andUserIdEqualTo(userId)
                        .andTypeEqualTo("2").andFavoritesIdEqualTo(folderId);
                pacShipMapper.deleteByExample(pacShipExample);
            }else{
                throw new ServiceException(ReturnCode.RC500.getCode(),"该收藏记录不存在，无法取消" );
            }
        }
        else{
            throw new ServiceException(ReturnCode.RC400.getCode(), "不是article");
        }
    }
//    @Override
//    public void thumbup(Long articleID) {
//        Long userId = TokenUtil.getUserId();
//        PacShipExample pacShipExample = new PacShipExample();
//        pacShipExample.createCriteria().andUserIdEqualTo(userId).andPacIdEqualTo(articleID).andPacTypeEqualTo("1");
//        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
//        if(pacShipList.size()>0){
//            PacShip pacShip = pacShipList.get(0);
//            pacShip.setType("1");
//            pacShipMapper.updateByExampleSelective(pacShip,pacShipExample);
//            return;
//        }
//        pacShipMapper.insert(new PacShip(userId,articleID,"1",null,new Date(),"1"));
//    }
    @Override
    public void thumbup(Long articleId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId)
                .andPacIdEqualTo(articleId).andPacTypeEqualTo("1").andTypeEqualTo("1");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            throw new ServiceException(ReturnCode.RC500.getCode(), "您已点赞该内容");
        }
        pacShipMapper.insert(new PacShip(userId,articleId,"1",null,new Date(),"1"));
    }
    @Override
    public void unthumbup(Long articleId) {
        Long userId = TokenUtil.getUserId();
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andUserIdEqualTo(userId).andPacIdEqualTo(articleId).andPacTypeEqualTo("1").andTypeEqualTo("1");
        List<PacShip> pacShipList = pacShipMapper.selectByExample(pacShipExample);
        if(pacShipList.size()>0){
            pacShipMapper.deleteByExample(pacShipExample);
            return;
        }
        throw new ServiceException(ReturnCode.RC500.getCode(), "您并未点赞该article");
    }
}
