package com.mypro.service.serviceImpl;

import com.mypro.beans.Location;
import com.mypro.beans.LocationExample;
import com.mypro.mapper.LocationMapper;
import com.mypro.service.LocationService;
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

    }

    @Override
    public void offline() {

    }
}
