package com.mypro.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Attraction;
import com.mypro.beans.Post;
import com.mypro.beans.User;
import com.mypro.service.AttractionService;
import com.mypro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttractionController {
    @Autowired
    AttractionService attractionService;
    @GetMapping("/attraction/list/find")
    public PageInfo<Attraction> find(@RequestParam("key")String key,
                                               @RequestParam("filter")Integer filter,
                                               @RequestParam("order")String order,
                                               @RequestParam("pagesize")Integer pagesize,
                                               @RequestParam("pagenum")Integer pagenum){
        return attractionService.findAttractionsByKey(key,filter,order,pagesize,pagenum);
    }
    @GetMapping("/attraction/list/findAttraction")
    public PageInfo<Attraction> findAttraction(@RequestParam("pageSize")Integer pageSize,
                                               @RequestParam("pageNum")Integer pageNum,
                                               @RequestParam("name")String name,
                                               @RequestParam("location")String location,
                                               @RequestParam("description")String description){
        return attractionService.findAttractions(pageSize,pageNum,name,location,description);
    }
    @PostMapping("/attraction/batchDelete/{attractionIds}")
    public Boolean batchDelete(@PathVariable("attractionIds") Long[] ids){
        return attractionService.batchDelete(ids);
    }
    @DeleteMapping("/attraction/delete/{attractionId}")
    public Boolean delete(@PathVariable("attractionId")Long attractionId){
        return attractionService.delete(attractionId);
    }
    @PostMapping("/attraction/save")
    public Boolean save(@RequestBody Attraction attraction){
        return attractionService.saveAttraction(attraction);
    }

    @GetMapping("/attraction/list/recommend/{pageSize}/{pageNum}")
    public PageInfo<Attraction> recommend(@PathVariable("pageSize")Integer pagesize,
                                      @PathVariable("pageNum")Integer pagenum){
        return attractionService.recommend(pagenum,pagesize);
    }

    @GetMapping("/attraction/profile/info/{attractionId}")
    Attraction info(@PathVariable("attractionId")Long attractionId){
        return attractionService.Info(attractionId);
    }
    @GetMapping("/attraction/profile/posts/{attractionId}")
    List<Post> posts(@PathVariable("attractionId")Long attractionId){
        return attractionService.getPosts(attractionId);
    }
    @GetMapping("/attraction/profile/articles/{attractionId}")
    List<Article> articles(@PathVariable("attractionId")Long attractionId){
        return attractionService.getArticles(attractionId);
    }
    @PostMapping("/attraction/creation/publish")
    void publish(@RequestBody Attraction attraction){
        attractionService.createAttraction(attraction);
    }
    @PostMapping("/attraction/creation/update")
    void update(@RequestBody Attraction attraction){
         attractionService.updateAttraction(attraction);
    }
    @PostMapping("/attraction/creation/evaluate/{attractionId}/{score}")
    void evaluate(@PathVariable("attractionId")Long attractionId,
                 @PathVariable("score")Double score){
        Long userId = TokenUtil.getUserId();
        attractionService.evaluateAttraction(userId,attractionId,score);
    }
    @GetMapping("/attraction/profile/relation/{attractionId}")
    Integer relation(@PathVariable("attractionId")Long attractionId){
        return attractionService.relation(attractionId);
    }
    @PostMapping("attraction/operation/follow/{attractionId}/{type}")
    public void follow(@PathVariable("attractionId")Long attractionId,
                       @PathVariable("type")char type){
        attractionService.follow(attractionId,type);
    }
    @PostMapping("attraction/operation/unfollow/{attractionId}")
    public void unfollow(@PathVariable("attractionId")Long attractionId){
        attractionService.unfollow(attractionId);
    }
}
