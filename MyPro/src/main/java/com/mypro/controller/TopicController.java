package com.mypro.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Attraction;
import com.mypro.beans.Post;
import com.mypro.beans.Topic;
import com.mypro.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;
    @GetMapping("/topic/list/find")
    PageInfo<Topic> find(@RequestParam("key")String key,
                         @RequestParam("filter")Integer filter,
                         @RequestParam("order")String order,
                         @RequestParam("pagesize")Integer pagesize,
                         @RequestParam("pagenum")Integer pagenum){
        return topicService.findTopicsByKey(key,filter,order,pagesize,pagenum);
    }
    @GetMapping("/topic/profile/info/{topicId}")
    Topic info(@PathVariable("topicId")Long topicId){
        return topicService.Info(topicId);
    }
    @GetMapping("/topic/profile/posts/{topicId}")
    List<Post> posts(@PathVariable("topicId")Long topicId){
        return topicService.getPosts(topicId);
    }
    @GetMapping("/topic/profile/articles/{topicId}")
    List<Article> articles(@PathVariable("topicId")Long topicId){
        return topicService.getArticles(topicId);
    }
    @PostMapping("/topic/creation/publish")
    void publish(@RequestBody Topic topic){
        topicService.createTopic(topic);
    }
    @PostMapping("/topic/creation/update")
    void update(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }
    @GetMapping("/topic/profile/relation/{topicId}")
    public Integer relation(@PathVariable("topicId")Long topicId){
        return topicService.relation(topicId);
    }

}
