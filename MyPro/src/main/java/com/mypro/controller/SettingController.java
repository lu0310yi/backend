package com.mypro.controller;

import com.mypro.beans.Setting;
import com.mypro.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    SettingService settingService;
    @PostMapping("/update")
    public void update(@RequestBody Setting setting){
        settingService.update(setting);
    }
    @GetMapping("/info/{userId}")
    public Setting info(@PathVariable("userId")Long userId){
        return settingService.getInfo(userId);
    }
}
