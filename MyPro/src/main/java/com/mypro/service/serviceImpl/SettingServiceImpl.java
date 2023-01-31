package com.mypro.service.serviceImpl;

import com.mypro.beans.Setting;
import com.mypro.mapper.SettingMapper;
import com.mypro.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    SettingMapper settingMapper;
    @Override
    public void update(Setting setting) {
        if(settingMapper.updateByPrimaryKeySelective(setting)==0){
            settingMapper.insert(setting);
        }
    }

    @Override
    @Transactional
    public Setting getInfo(Long userId) {
        Setting setting;
        setting = settingMapper.selectByPrimaryKey(userId);
        if(setting==null){
            setting = new Setting(userId,(byte) 0, (byte) 0,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0);
        }
        return setting ;
    }
}
