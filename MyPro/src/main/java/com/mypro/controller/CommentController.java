package com.mypro.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Comment;
import com.mypro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/profile/replies/{commentId}")
    public List<Comment> getReplies(@PathVariable("commentId")Long commentId){
        return commentService.getReplies(commentId);
    }
    @PostMapping("/operation/thumbup/{commentId}")
    public void thumbup(@PathVariable("commentId")Long commentId){
        commentService.thumbup(commentId);
    }
    @PostMapping("/operation/unthumbup/{commentId}")
    public void unthumbup(@PathVariable("commentId")Long commentId){
        commentService.unthumbup(commentId);
    }
    @PostMapping("/operation/reply")
    public void reply(@RequestBody Comment comment){
        commentService.reply(comment);
    }
    @PostMapping("/operation/delete/{commentId}")
    public void delete(@PathVariable("commentId")Long commentId){
        commentService.delete(commentId);
    }
}
