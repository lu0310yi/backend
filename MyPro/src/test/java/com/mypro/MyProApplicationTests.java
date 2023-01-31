package com.mypro;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.beans.Attraction;
import com.mypro.beans.User;
import com.mypro.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MyProApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    TopicShipMapper topicShipMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    AttractionShipMapper attractionShipMapper;
    @Autowired
    AttractionMapper attractionMapper;
    @Test
    void contextLoads() {
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andMobileEqualTo("13789314093").andPasswordEqualTo("rcXVr395Il");
//        System.out.println( userMapper.selectByExample(userExample));
//        System.out.println(userMapper.selectByMobileAndPassword("13789314093","rcXVr395Il"));
//        userMapper.insertSelective(new User("15512345264","password"));
//        System.out.println(userMapper.selectByPrimaryKey(5));
//        Integer int1 = relationshipMapper.selectStatus(1,5);
//        System.out.println(int1);
//        List<Long> topicIdList =  topicShipMapper.selectTopicByUserId(1);
////        TopicExample topicExample = new TopicExample();
////        topicExample.createCriteria().andTopicIdIn(topicIdList);
//        System.out.println(topicMapper.selectByIdList(topicIdList));
//        List<Long> visitedAttractionIdList = attractionShipMapper.selectVisitedByUserId(1);
//        AttractionExample attractionExample = new AttractionExample();
//        attractionExample.createCriteria().andAttractionIdIn(visitedAttractionIdList);
//        System.out.println(visitedAttractionIdList);
//        attractionMapper.selectByIdList(visitedAttractionIdList);
//        System.out.println(attractionMapper.selectByKey("长垣", filter, order));
//        PageHelper.startPage(1,1);
//        List list = attractionMapper.selectByRecommend();
//        System.out.println(list);
//        System.out.println(new PageInfo<Attraction>(list,1));
//        System.out.println(userMapper.selectByPrimaryKey(1l));
//        PageHelper.startPage(2,10);
//        List<User> users = userMapper.selectByExample(null);
//        System.out.println(users);
//        System.out.println("=========================");
//        PageInfo<User> pageInfo = new PageInfo<>(users);
//        System.out.println(pageInfo.getList());
//        User user = new User();
//        user.setGmtSignUp(new Date());
//        user.setMobile("15942368799");
//        user.setPassword("aaa");
//        user.setUserId(11111l);
//        userMapper.insert(user);
        User user = userMapper.selectByMobileAndPassword("1555555", "1255");
        System.out.println("==================");
        System.out.println(user.getUserId());
        System.out.println(user.getNickname());
        System.out.println(user);
    }

}
