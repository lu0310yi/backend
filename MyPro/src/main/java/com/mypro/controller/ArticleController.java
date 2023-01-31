package com.mypro.controller;

import com.mypro.beans.Article;
import com.mypro.beans.Collection;
import com.mypro.beans.Comment;
import com.mypro.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/article/profile/info/{articleId}")
    Article info(@PathVariable("articleId")Long articleId){
        return articleService.info(articleId);
    }
    @GetMapping("/article/profile/comments/{articleId}")
    List<Comment> comments(@PathVariable("articleId")Long articleId){
        return articleService.getComments(articleId);
    }
    @PostMapping("/article/operation/collect")
    void collect(@RequestBody Collection collection){
        articleService.collect(collection);
    }
    @PostMapping("/article/operation/thumbup/{articleId}")
    void thumbup(@PathVariable("articleId")Long articleId){
        articleService.thumbup(articleId);
    }
    @PostMapping("/article/operation/comment")
    void comment(@RequestBody Comment comment){
        articleService.comment(comment);
    }
    @PostMapping("/article/creation/publish")
    void publish(@RequestBody Article article){
        articleService.publish(article);
    }
    @PostMapping("/article/creation/delete/{articleId}")
    void delete(@PathVariable("articleId")Long articleId){
        articleService.delete(articleId);
    }
    @PostMapping("/article/creation/update")
    void update(@RequestBody Article article){
        articleService.update(article);
    }
    @GetMapping("/article/profile/isthumbup/{articleId}")
    public Boolean isthumbup(@PathVariable("articleId")Long articleId){
        return articleService.isthumbup(articleId);
    }
    @GetMapping("/article/profile/iscollect/{articleId}")
    public List<Collection> iscollect(@PathVariable("articleId")Long articleId){
        return articleService.iscollect(articleId);
    }
}
