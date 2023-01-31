package com.mypro.controller;

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
    @PostMapping("/post/operation/thumbup/{postId}")
    void collect(@PathVariable("postId")Long postId){
        postService.thumbup(postId);
    }
    @PostMapping("/post/operation/comment")
    void collect(@RequestBody Comment comment){
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
}
