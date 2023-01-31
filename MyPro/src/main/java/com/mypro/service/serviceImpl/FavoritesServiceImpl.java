package com.mypro.service.serviceImpl;

import com.mypro.beans.*;
import com.mypro.exception.ServiceException;
import com.mypro.mapper.ArticleMapper;
import com.mypro.mapper.FavoritesMapper;
import com.mypro.mapper.PacShipMapper;
import com.mypro.mapper.SettingMapper;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.FavoritesService;
import com.mypro.service.SettingService;
import com.mypro.service.UserService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Article> getItems(Long favoritesId) {
        PacShipExample pacShipExample = new PacShipExample();
        pacShipExample.createCriteria().andFavoritesIdEqualTo(favoritesId);
        List<PacShip> list =  pacShipMapper.selectByExample(pacShipExample);
        List pacIdList = new ArrayList();
        for(PacShip  pacship : list){
            pacIdList.add(pacship.getPacId());
        }
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andAttractionIdIn(pacIdList);
        return articleMapper.selectByExample(articleExample);
    }

    @Override
    public void collect(Long favoritesId) {

//        favoritesMapper.insert()
    }

    @Override
    public void thumbup(Long favoritesId) {

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
