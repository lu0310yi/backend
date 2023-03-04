package com.mypro.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Collection;
import com.mypro.beans.Comment;
import com.mypro.beans.Post;
import com.mypro.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping("/post/profile/info/{postId}")
    Post info(@PathVariable("postId")Long postId){
        return postService.info(postId);
    }
    @GetMapping("/post/profile/comments/{postId}")
    List<Comment> comments(@PathVariable("postId")Long postId){
        return postService.getComments(postId);
    }

    @PostMapping("/post/operation/collect")
    void collect(@RequestBody Collection collection){
        postService.collect(collection);
    }
    @PostMapping("/post/operation/uncollect")
    void uncollect(@RequestBody Collection collection){
        postService.uncollect(collection);
    }
    @PostMapping("/post/operation/thumbup/{postId}")
    void thumbup(@PathVariable("postId")Long postId){
        postService.thumbup(postId);
    }
    @PostMapping("/post/operation/unthumbup/{postId}")
    void unthumbup(@PathVariable("postId")Long postId){
        postService.unthumbup(postId);
    }
    @PostMapping("/post/operation/comment")
    void comment(@RequestBody Comment comment){
        postService.comment(comment);
    }
    @PostMapping("/post/creation/publish")
    void publish(@RequestBody Post post){
        postService.publishPost(post);
    }
    @PostMapping("/post/creation/delete/{postId}")
    void delete(@PathVariable("postId")Long postId){
        postService.deletePost(postId);
    }
    @PostMapping("/post/creation/update")
    void update(@RequestBody Post post){
        postService.updatePost(post);
    }

    @GetMapping("/post/profile/isthumbup/{postId}")
    public Boolean isthumbup(@PathVariable("postId")Long postId){
        return postService.isthumbup(postId);
    }
    @GetMapping("/post/profile/iscollect/{postId}")
    public List<Collection> iscollect(@PathVariable("postId")Long postId){
        return postService.iscollect(postId);
    }
    @GetMapping("/post/list/find")
    public PageInfo<Post> find(@RequestParam("key")String key,
                                  @RequestParam("filter")Integer filter,
                                  @RequestParam("order")String order,
                                  @RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("pageNum")Integer pageNum){
        return postService.findPostByKey(key,filter,order,pageSize,pageNum);

    }
    @GetMapping("/post/list/recommend/{pageSize}/{pageNum}")
    public PageInfo<Post> recommend(@PathVariable("pageSize")Integer pageSize,
                                       @PathVariable("pageNum")Integer pageNum){
        return postService.recommend(pageNum,pageSize);
    }
}
