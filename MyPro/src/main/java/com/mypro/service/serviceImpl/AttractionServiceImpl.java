package com.mypro.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.beans.*;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.*;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.AttractionService;
import com.mypro.service.SettingService;
import com.mypro.service.UserService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {
    @Autowired
    AttractionMapper attractionMapper;
    @Autowired
    AttractionShipMapper attractionShipMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    AttractionScoreMapper attractionScoreMapper;
    @Autowired
    SettingService settingService;
    @Autowired
    UserService userService;
    @Override
    public List<Attraction> getAttractionsByUserId(Long userId) {
        List<Long> attractionIdList =  attractionShipMapper.selectAttractionIdByUserId(userId);
//        AttractionExample attractionExample = new AttractionExample();
//        attractionExample.createCriteria().andAttractionIdIn(attractionIdList);
        return attractionMapper.selectByIdList(attractionIdList);
    }

    @Override
    public List<Attraction> getVisited(Long userId) {
        Long visitorId = TokenUtil.getUserId();
        List<Long> visitedAttractionIdList = attractionShipMapper.selectVisitedByUserId(userId);
        List<Attraction> attractionList = attractionMapper.selectByIdList(visitedAttractionIdList);
        if(visitorId==userId) {
            return attractionList;
        }
        byte visitedVisible = settingService.getInfo(userId).getWantVisible();
        String relation = userService.getRelation(visitorId, userId);
        if("5".equals(userService.getRelation(userId, visitorId))){
            throw new ServiceException(ReturnCode.RC301.getCode(), "被拉黑");
        }
        if (0== visitedVisible) {
            return attractionList;
        } else if (1== visitedVisible) {
            if ("1".equals(relation) || "2".equals(relation)) {
                return  attractionList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是粉丝");
        } else if (2== visitedVisible) {
            if ("3".equals(relation) || "4".equals(relation)) {
                return  attractionList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是好友");
        }
        return null;
    }

    @Override
    public List<Attraction> getWant(Long userId) {
        Long visitorId = TokenUtil.getUserId();
        List<Long> wantAttractionIdList = attractionShipMapper.selectWantByUserId(userId);
        List<Attraction> attractionList = attractionMapper.selectByIdList(wantAttractionIdList);
        if(visitorId==userId) {
            return attractionList;
        }
        byte wantVisible = settingService.getInfo(userId).getWantVisible();
        if("5".equals(userService.getRelation(userId, visitorId))){
            throw new ServiceException(ReturnCode.RC301.getCode(), "被拉黑");
        }
        String relation = userService.getRelation(visitorId, userId);
        if (0== wantVisible) {
            return attractionList;
        } else if (1== wantVisible) {
            if ("1".equals(relation) || "2".equals(relation)) {
                return  attractionList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是粉丝");
        } else if (2== wantVisible) {
            if ("3".equals(relation) || "4".equals(relation)) {
                return  attractionList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是好友");
        }
        return null;
    }

    @Override
    public List<Attraction> getHostAttractionsByUserId(Long userId) {
        AttractionExample attractionExample = new AttractionExample();
        attractionExample.createCriteria().andAuthorIdEqualTo(userId);
        return attractionMapper.selectByExample(attractionExample);
    }

    @Override
    public PageInfo<Attraction> findAttractionsByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum) {
        PageHelper.startPage(pagenum,pagesize);
        List list = attractionMapper.selectByKey(key,filter,order);
        return new PageInfo<Attraction>(list,1);
    }

    @Override
    public PageInfo<Attraction> recommend(Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List list = attractionMapper.selectByRecommend();
        return new PageInfo<Attraction>(list,1);
    }

    @Override
    public Attraction Info(Long attractionId) {
        return attractionMapper.selectByPrimaryKey(attractionId);
    }

    @Override
    public List<Post> getPosts(Long attractionId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andAttractionIdEqualTo(attractionId);
        return postMapper.selectByExample(postExample);
    }

    @Override
    public List<Article> getArticles(Long attractionId) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andAttractionIdEqualTo(attractionId);
        return articleMapper.selectByExampleWithBLOBs(articleExample);
    }

    @Override
    public void createAttraction(Attraction attraction) {
        attractionMapper.insert(attraction);
    }

    @Override
    public void updateAttraction(Attraction attraction) {
        attractionMapper.updateByPrimaryKey(attraction);
    }

    @Override
    public void evaluateAttraction(Long userId, Long attractionId, Double score) {
        AttractionScore attractionScore = new AttractionScore(userId,attractionId,score);
        attractionScoreMapper.insert(attractionScore);
    }

    @Override
    public Integer relation(Long attractionId) {
        Long userId = TokenUtil.getUserId();
        String status = attractionShipMapper.selectStatus(userId,attractionId);
        if(status!=null){
            return Integer.valueOf(status);
        }
        return 0;
    }

    @Override
    public void follow(Long attractionId, char type) {
        Long userId = TokenUtil.getUserId();
        AttractionShipExample attractionShipExample = new AttractionShipExample();
        attractionShipExample.createCriteria().andUserIdEqualTo(userId).andAttractionIdEqualTo(attractionId);
        List<AttractionShip> attractionShipList = attractionShipMapper.selectByExample(attractionShipExample);
        AttractionShip attractionShip = null;
        if(attractionShipList.size()>0){
            attractionShip = attractionShipList.get(0);
            attractionShip.setStatus(String.valueOf(type));
            attractionShipMapper.updateByExample(attractionShip,attractionShipExample);
            return;
        }
        if(attractionShip==null){
            attractionShipMapper.insert(new AttractionShip(userId,attractionId,String.valueOf(type)));
        }

    }

    @Override
    public void unfollow(Long attractionId) {
        Long userId = TokenUtil.getUserId();
        AttractionShipExample attractionShipExample = new AttractionShipExample();
        attractionShipExample.createCriteria().andUserIdEqualTo(userId).andAttractionIdEqualTo(attractionId);
        List<AttractionShip> attractionShipList = attractionShipMapper.selectByExample(attractionShipExample);
        if(attractionShipList.size()>0){
            attractionShipMapper.deleteByExample(attractionShipExample);
        }
    }

    @Override
    public PageInfo<Attraction> findAttractions(Integer pagesize, Integer pagenum, String name, String location, String description) {
        AttractionExample attractionExample = new AttractionExample();
        AttractionExample.Criteria criteria = attractionExample.createCriteria();
        if(name!=null&&!"".equals(name)&&!"null".equals(name)){
            criteria.andNameLike('%'+name+'%');
        }
        if(location!=null&&!"".equals(location)&&!"null".equals(location)){
            criteria.andLocationLike('%'+location+'%');
        }
        if(description!=null&&!"".equals(description)&&!"null".equals(name)){
            criteria.andDescriptionLike('%'+description+'%');
        }
        PageHelper.startPage(pagenum,pagesize);
        List<Attraction> list = attractionMapper.selectByExample(attractionExample);
        return new PageInfo<Attraction>(list,1);
    }

    @Override
    public Boolean batchDelete(Long[] ids) {
        AttractionExample attractionExample = new AttractionExample();
        attractionExample.createCriteria().andAttractionIdIn(Arrays.asList(ids));
        if(attractionMapper.deleteByExample(attractionExample)>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long attractionId) {
        if ( attractionMapper.deleteByPrimaryKey(attractionId)!=0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean saveAttraction(Attraction attraction) {
        System.out.println("=========="+attraction.getAttractionId());
        if(attractionMapper.selectByPrimaryKey(attraction.getAttractionId())!=null){
            attractionMapper.updateByPrimaryKeySelective(attraction);
            return true;
        }
        attraction.setGmtCreate(new Date());
        if(attractionMapper.insertSelective(attraction)!=0) {
            return true;
        }
        return false;
    }

}
