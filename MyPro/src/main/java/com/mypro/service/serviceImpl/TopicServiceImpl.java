package com.mypro.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.beans.*;
import com.mypro.mapper.ArticleMapper;
import com.mypro.mapper.PostMapper;
import com.mypro.mapper.TopicMapper;
import com.mypro.mapper.TopicShipMapper;
import com.mypro.service.TopicService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    TopicShipMapper topicShipMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public List<Topic> getTopicsByUserId(Long userId) {
        List<Long> topicIdList =  topicShipMapper.selectTopicByUserId(userId);
//        TopicExample topicExample = new TopicExample();
//        topicExample.createCriteria().andTopicIdIn(topicIdList);
        return topicMapper.selectByIdList(topicIdList);
    }

    @Override
    public List<Topic> getHostTopicsByUserId(Long userId) {
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andAuthorIdEqualTo(userId);
        return topicMapper.selectByExample(topicExample);
    }

    @Override
    public PageInfo<Topic> findTopicsByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum) {
        PageHelper.startPage(pagenum,pagesize);
        List list = topicMapper.selectByKey(key,filter,order);
        return new PageInfo<Topic>(list,1);
    }

    @Override
    public Topic Info(Long topicId) {
        return topicMapper.selectByPrimaryKey(topicId);
    }

    @Override
    public List<Post> getPosts(Long topicId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andTopicIdEqualTo(topicId);
        return postMapper.selectByExample(postExample);
    }

    @Override
    public List<Article> getArticles(Long topicId) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andTopicIdEqualTo(topicId);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public void createTopic(Topic topic) {
        topicMapper.insert(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        topicMapper.updateByPrimaryKey(topic);
    }

    @Override
    public Integer relation(Long topicId) {
        Long userId = TokenUtil.getUserId();
        TopicShipExample topicShipExample = new TopicShipExample();
        topicShipExample.createCriteria().andTopicIdEqualTo(topicId).andUserIdEqualTo(userId);
        List<TopicShip> topicShipList = topicShipMapper.selectByExample(topicShipExample);
        if(topicShipList.size()>0){
            return 1;
        }
        return 0;
    }
}
