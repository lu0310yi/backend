package com.mypro.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mypro.beans.*;
import com.mypro.beans.dto.UserDTO;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.RelationshipMapper;
import com.mypro.mapper.UserMapper;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.SettingService;
import com.mypro.service.UserService;
import com.mypro.utils.TokenUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    SettingService settingService;


    @Override
//    @Transactional
    public UserDTO signup(UserDTO userDTO) {
        User user = userMapper.selectByMobileAndPassword(userDTO.getMobile(),userDTO.getPassword());
        if(user==null) {
            user=new User();
            BeanUtils.copyProperties(userDTO,user);
            user.setGmtSignUp(new Date());
            userMapper.insert(user);
            return userDTO;
        }
        throw new ServiceException(ReturnCode.RC400.getCode(),"该用户已注册");
    }

    @Override
    public UserDTO loginServ(UserDTO userDTO) {
        String mobile = userDTO.getMobile();
        String password = userDTO.getPassword();
        if(StringUtils.isNullOrEmpty(mobile)||StringUtils.isNullOrEmpty((password))) {
            return null;
        }
        User user = userMapper.selectByMobileAndPassword(mobile, password);
        if(user!=null){
            BeanUtils.copyProperties(user,userDTO);
            String token = TokenUtil.getToken(user.getUserId().toString(),user.getPassword());
            userDTO.setToken(token);
            System.out.println(userDTO.getUserId());
            return userDTO;
        }else{
            throw new ServiceException(ReturnCode.RC500.getCode(),"手机号或者密码错误");
        }
    }

    @Override
    public User getInfoById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getFollowing(Long userId, char type) {
//        List<Long> objIdList = relationshipMapper.selectObjIdBySubId(userId,type);
//
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andUserIdIn(objIdList);
//        return userMapper.selectByExample(userExample);
        Long visitorId = TokenUtil.getUserId();
        List<Long> objIdList = null;
        if(48==type) {
            List<String> status = Arrays.asList("1","0");
            objIdList = relationshipMapper.selectObjIdBySubId(userId,status);
        }else if(49==type) {
            List<String> status = Arrays.asList("0");
            objIdList = relationshipMapper.selectObjIdBySubId(userId,status);
        }else if(50==type){
            List<String> status = Arrays.asList("1");
            objIdList = relationshipMapper.selectObjIdBySubId(userId,status);
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIn(objIdList);
        List<User> userList = userMapper.selectByExample(userExample);
        if(visitorId==userId) {
            return userList;
        }
        byte fansVisible = settingService.getInfo(userId).getFansVisible();
        if("5".equals(getRelation(userId, visitorId))){
            throw new ServiceException(ReturnCode.RC301.getCode(), "被拉黑");
        }
        String relation = getRelation(visitorId, userId);
        if (0== fansVisible) {
            return userList;
        } else if (1== fansVisible) {
            if ("1".equals(relation) || "2".equals(relation)) {
                return  userList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是粉丝");
        } else if (2== fansVisible) {
            if ("3".equals(relation) || "4".equals(relation)) {
                return  userList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是好友");
        }
        return null;
    }

    @Override
    public List<User> getFollowers(Long userId) {
        Long visitorId = TokenUtil.getUserId();

        List<Long> subIdList = relationshipMapper.selectSubIdByObjId(userId);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIn(subIdList);
        List<User> userList = userMapper.selectByExample(userExample);
        if(visitorId==userId) {
            return userList;
        }
        byte fansVisible = settingService.getInfo(userId).getFansVisible();
        if("5".equals(getRelation(userId, visitorId))){
            throw new ServiceException(ReturnCode.RC301.getCode(), "被拉黑");
        }
        String relation = getRelation(visitorId, userId);
        if (0== fansVisible) {
            return userList;
        } else if (1== fansVisible) {
            if ("1".equals(relation) || "2".equals(relation)) {
                return  userList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是粉丝");
        } else if (2== fansVisible) {
            if ("3".equals(relation) || "4".equals(relation)) {
                return  userList;
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "不是好友");
        }
        return null;
    }

    @Override
    public List<String> getAlbum(Long userId) {
        return null;
    }

    @Override
    public String getRelation(Long userId,Long friendId) {
        String s1 =  relationshipMapper.selectStatus(userId,friendId);
        String relation = new String();
        if(s1==null){
            relation="0";
        }else if("2".equals(s1)){
            relation="5";
        }else if("1".equals(s1)) {
            String s2 =  relationshipMapper.selectStatus(friendId,userId);
            if(s2==null||"2".equals(s2)){
                relation="2";
            }else{
                relation="4";
            }
        }else if("0".equals(s1)) {
            String s2 =  relationshipMapper.selectStatus(friendId,userId);
            if("0".equals(s2)||"1".equals(s2)){
                relation="3";
            }else{
                relation="1";
            }
        }
        return relation;
    }

    @Override
    public PageInfo<User> findUsers(Integer pagesize, Integer pagenum, String nickname, String mobile, String signature) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(nickname!=null&&!"".equals(nickname)&&!"null".equals(nickname)){
            criteria.andNicknameLike('%'+nickname+'%');
        }
        if(mobile!=null&&!"".equals(mobile)&&!"null".equals(mobile)){
            criteria.andMobileLike('%'+mobile+'%');
        }
        if(signature!=null&&!"".equals(signature)&&!"null".equals(nickname)){
            criteria.andSignatureLike('%'+signature+'%');
        }
        PageHelper.startPage(pagenum,pagesize);
        List<User> list = userMapper.selectByExample(userExample);
        return new PageInfo<User>(list,1);
    }

    @Override
    public Boolean saveUser(User user) {
        if(userMapper.insert(user)!=0) {
            return true;
        }
        return true;
    }

    @Override
    public Boolean delete(Long userId) {
        if ( userMapper.deleteByPrimaryKey(userId)!=0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchDelete(Long[] ids) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIn(Arrays.asList(ids));
        if(userMapper.deleteByExample(userExample)>0){
            return true;
        }
        return false;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void follow(Long userId) {
        updateRelation(userId,"0");
    }

    @Override
    public void special(Long userId) {
        updateRelation(userId,"1");
    }

    @Override
    public void unfollow(Long userId) {
        User currentUser = TokenUtil.getUser();
        if(currentUser.getUserId()==userId){
            return;
        }
        RelationshipExample relationshipExample = new RelationshipExample();
        List<String> statusList = Arrays.asList("1","0");
        relationshipExample.createCriteria().andSubjectIdEqualTo(currentUser.getUserId()).andObjectIdEqualTo(userId).andStatusIn(statusList);
        List<Relationship> relationshipList =  relationshipMapper.selectByExample(relationshipExample);
        Relationship relationship = null;
        if(relationshipList.size()>0){
            relationship = relationshipList.get(0);
        }
        if(relationship==null) {
        }else {
            relationshipMapper.deleteByExample(relationshipExample);
        }
    }

    @Override
    public void block(Long userId) {
        updateRelation(userId,"2");
    }
    public void updateRelation(Long userId,String status){
        User currentUser = TokenUtil.getUser();
        if(currentUser.getUserId()==userId){
            return;
        }
        RelationshipExample relationshipExample = new RelationshipExample();
        relationshipExample.createCriteria().andSubjectIdEqualTo(currentUser.getUserId()).andObjectIdEqualTo(userId);
        List<Relationship> relationshipList =  relationshipMapper.selectByExample(relationshipExample);
        Relationship relationship = null;
        if(relationshipList.size()>0){
            relationship = relationshipList.get(0);
        }
        if(relationship==null) {
            relationshipMapper.insert(new Relationship(currentUser.getUserId(),userId,status));
        }else {
            relationship.setStatus(status);
            relationshipMapper.updateByExample(relationship, relationshipExample);
        }
    }

}
