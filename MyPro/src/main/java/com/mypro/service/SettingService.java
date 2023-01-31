package com.mypro.service;

import com.mypro.beans.Setting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface SettingService {
     void update(Setting setting);
     @Transactional
     Setting getInfo(Long userId);
}
