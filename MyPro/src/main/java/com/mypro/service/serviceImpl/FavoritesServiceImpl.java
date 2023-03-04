package com.mypro.service.serviceImpl;

import com.mypro.beans.*;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.*;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.FavoritesService;
import com.mypro.service.SettingService;
import com.mypro.service.UserService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    FavoritesMapper favoritesMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    PacShipMapper pacShipMapper;
    @Autowired
    SettingMapper settingMapper;
    @Autowired
    SettingService settingService;
    @Autowired
    UserService userService;
    @Autowired
    FavoritesShipMapper favoritesShipMapper;
    @Override
    public List<Favorites> getFavorites(Long userId) {
        FavoritesExample favoritesExample = new FavoritesExample();
        Long visitorId = TokenUtil.getUserId();
        if(visitorId==userId) {
            favoritesExample.createCriteria().andUserIdEqualTo(userId);
            return favoritesMapper.selectByExample(favoritesExample);
        }
        favoritesExample.createCriteria().andUserIdEqualTo(userId).andIsPublicEqualTo(true);
        if("5".equals(userService.getRelation(userId, visitorId))){
            throw new ServiceException(ReturnCode.RC301.getCode(), "被拉黑");
        }
        String relation = userService.getRelation(visitorId, userId);
        byte favoritesVisible = settingService.getInfo(userId).getFavoritesVisible();
        if (0==favoritesVisible) {
            return favoritesMapper.selectByExample(favoritesExample);
        } else if (1==favoritesVisible) {
            if ("1".equals(relation) || "2".equals(relation)) {
                return favoritesMapper.selectByExample(favoritesExample);
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "抱歉，您不是对方的粉丝");
        } else if (2==favoritesVisible) {
            if ("3".equals(relation) || "4".equals(relation)) {
                return favoritesMapper.selectByExample(favoritesExample);
            }
            throw new ServiceException(ReturnCode.RC301.getCode(), "抱歉。您不是对方的好友");
        }
        return null;
    }

    @Override
    public Favorites info(Long favoritesId) {
        return favoritesMapper.selectByPrimaryKey(favoritesId);
    }

    @Override
    public HashMap<String,List<Long>> getItems(Long favoritesId) {
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andFavoritesIdEqualTo(favoritesId);
        List<PacShip> list =  pacShipMapper.selectByExample(pacShipExample);
        List articleIdList = new ArrayList();
        List postIdList = new ArrayList();
        for(PacShip  pacship : list){
            if("0".equals(pacship.getPacType())) {
                postIdList.add(pacship.getPacId());
            }else if("1".equals(pacship.getPacType())){
                articleIdList.add(pacship.getPacId());
            }
        }
        HashMap<String,List<Long>> map  =new HashMap<>();
        map.put("articleIdList",articleIdList);
        map.put("postIdList",postIdList);
        return map;
    }

    @Override
    public void collect(Long favoritesId) {
        Long userId = TokenUtil.getUserId();
        FavoritesShip favoritesShip = new FavoritesShip();
        favoritesShip.setFavoritesId(favoritesId);
        favoritesShip.setUserId(userId);
        favoritesShip.setGmtOperation(new Date());
        favoritesShip.setType("2");
        FavoritesShipExample favoritesShipExample = new FavoritesShipExample();
        favoritesShipExample.createCriteria().andFavoritesIdEqualTo(favoritesId).
                andUserIdEqualTo(userId).andTypeEqualTo("2");
        List favoritesShipList  = favoritesShipMapper.selectByExample(favoritesShipExample);
        if(favoritesShipList.size()>0){
            throw new ServiceException(ReturnCode.RC500.getCode(),"您已收藏该内容" );
        }
        favoritesShipMapper.insert(favoritesShip);
    }

    @Override
    public void thumbup(Long favoritesId) {
        Long userId = TokenUtil.getUserId();
        FavoritesShip favoritesShip = new FavoritesShip();
        favoritesShip.setFavoritesId(favoritesId);
        favoritesShip.setUserId(userId);
        favoritesShip.setGmtOperation(new Date());
        favoritesShip.setType("1");
        FavoritesShipExample favoritesShipExample = new FavoritesShipExample();
        favoritesShipExample.createCriteria().andFavoritesIdEqualTo(favoritesId).
                andUserIdEqualTo(userId).andTypeEqualTo("1");
        List favoritesShipList  = favoritesShipMapper.selectByExample(favoritesShipExample);
        if(favoritesShipList.size()>0){
            throw new ServiceException(ReturnCode.RC500.getCode(),"您已点赞该内容" );
        }
        favoritesShipMapper.insert(favoritesShip);
    }

    @Override
    public void create(Favorites favorites) {
        favoritesMapper.insert(favorites);
    }

    @Override
    public void delete(Long favoritesId) {
        FavoritesExample favoritesExample = new FavoritesExample();
        favoritesExample.createCriteria().andFolderIdEqualTo(favoritesId);
        favoritesMapper.deleteByExample(favoritesExample);
    }

    @Override
    public void update(Favorites favorites) {
        FavoritesExample favoritesExample = new FavoritesExample();
        favoritesExample.createCriteria().andFolderIdEqualTo(favorites.getFolderId());
        favoritesMapper.updateByExample(favorites,favoritesExample);
    }
}
