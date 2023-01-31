package com.mypro.controller;

import com.mypro.beans.Location;
import com.mypro.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;
    @PostMapping("/update")
    public void update(@RequestBody Location location){
        locationService.update(location);
    }
    @PostMapping("/around")
    public void around(@RequestBody Location location,
                       @RequestParam(value = "radius",required = false,defaultValue = "10")Double radius){
        locationService.around(location,radius);
    }
    @PostMapping("/online")
    public void online(){
        locationService.online();
    }
    @PostMapping("/offline")
    public void offline(){
        locationService.offline();
    }
}
