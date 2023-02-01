package com.mypro.service.serviceImpl;

import com.mypro.beans.Location;
import com.mypro.beans.LocationExample;
import com.mypro.mapper.LocationMapper;
import com.mypro.service.LocationService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationMapper locationMapper;
    @Override
    public void update(Location location) {
        if(locationMapper.selectByPrimaryKey(location.getUserId())!=null) {
            LocationExample locationExample = new LocationExample();
            locationExample.createCriteria().andUserIdEqualTo(location.getUserId());
            locationMapper.updateByExampleSelective(location,locationExample);
            return;
        }
        locationMapper.insertSelective(location);
    }

    @Override
    public void around(Location location, Double radius) {

    }

    @Override
    public void online() {
        Long userId = TokenUtil.getUserId();

        Location location = locationMapper.selectByPrimaryKey(userId);
        if(location==null){
            locationMapper.insertSelective(new Location(userId, (Double) null, (Double) null, (byte) 1));
            return;
        }
        location.setOnline((byte)1);
        locationMapper.updateByPrimaryKeySelective(location);
    }

    @Override
    public void offline() {
        Long userId = TokenUtil.getUserId();
        Location location = locationMapper.selectByPrimaryKey(userId);
        if(location==null){
            locationMapper.insertSelective(new Location(userId, (Double) null, (Double) null, (byte) 0));
            return;
        }
        location.setOnline((byte)0);
        locationMapper.updateByPrimaryKeySelective(location);
    }
}
