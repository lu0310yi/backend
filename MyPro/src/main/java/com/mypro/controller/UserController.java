package com.mypro.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.*;
import com.mypro.beans.dto.UserDTO;
import com.mypro.exception.ServiceException;
import com.mypro.resultHandle.ReturnCode;
import com.mypro.service.*;

import com.mypro.utils.TokenUtil;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Array;
import java.util.List;
//@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    AttractionService attractionService;
    @Autowired
    PostService postService;
    @Autowired
    ArticleService articleService;
    @Autowired
    FavoritesService favoritesService;
    // 登录
//    @ApiOperation(value = "登陆", notes = "登陆")
//    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
//    public Object login(User user, HttpServletResponse response) {
//        JSONObject jsonObject = new JSONObject();
//        User userForBase = new User();
//        userForBase.setUserId(userService.findByUsername(user).getId());
//        userForBase.setUsername(userService.findByUsername(user).getUsername());
//        userForBase.setPassword(userService.findByUsername(user).getPassword());
//        if (!userForBase.getPassword().equals(user.getPassword())) {
//            jsonObject.put("message", "登录失败,密码错误");
//            return jsonObject;
//        } else {
//            String token = tokenService.getToken(userForBase);
//            jsonObject.put("token", token);
//
//            Cookie cookie = new Cookie("token", token);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//
//            return jsonObject;
//
//        }
//    }
//    /***
//     * 这个请求需要验证token才能访问
//     *
//     */
//    @UserLoginToken
//    @ApiOperation(value = "获取信息", notes = "获取信息")
//    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
//    public String getMessage() {
//
//        // 取出token中带的用户id 进行操作
//        System.out.println(TokenUtil.getTokenUserId());
//
//        return "您已通过验证";
//    }

    @PostMapping("/user/auth/login")
    public UserDTO login(@RequestBody UserDTO userDTO){
        return userService.loginServ(userDTO);
    }
    @PostMapping("/user/auth/signup")
    public UserDTO signup(@RequestBody UserDTO userDTO){
        if(StringUtils.isNullOrEmpty(userDTO.getMobile())||StringUtils.isNullOrEmpty(userDTO.getPassword())){
            throw new ServiceException(ReturnCode.RC400.getCode(),"手机号或者密码为空");
        }
        return userService.signup(userDTO);
    }
    @PostMapping("/user/save")
    public Boolean save(@RequestBody User user){
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
////        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Origin", "*");
        return userService.saveUser(user);
    }
    @DeleteMapping("/user/delete/{userId}")
    public Boolean delete(@PathVariable("userId")Long userId){
        return userService.delete(userId);
    }
    @PostMapping("/user/batchDelete/{userIds}")
    public Boolean batchDelete(@PathVariable("userIds") Long[] ids){
        return userService.batchDelete(ids);
    }
    @GetMapping("/user/list/findUser")
    public PageInfo<User> findUser(@RequestParam("pageSize")Integer pageSize,
                                   @RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("nickname")String nickname,
                                   @RequestParam("mobile")String mobile,
                                   @RequestParam("signature")String signature){
        return userService.findUsers(pageSize,pageNum,nickname,mobile,signature);
    }
    @GetMapping("/user/list/find")
    public PageInfo<User> find(@RequestParam("key")String key,
                               @RequestParam("filter")Integer filter,
                               @RequestParam("order")String order,
                               @RequestParam("pagesize")Integer pagesize,
                               @RequestParam("pagenum")Integer pagenum){
        return userService.findUserByKey(key,filter,order,pagesize,pagenum);

    }

    @PostMapping("/user/auth/logout")
    public String logout(){
        return "login";
    }
    @PostMapping("/user/auth/cancel")
    public String cancel(){
        return null;
    }

    @GetMapping("/user/auth/info/{userId}")
    public User info(@PathVariable("userId")Long userId){
        return userService.getInfoById(userId);
    }
    @PostMapping("/user/auth/update")
//    @RequestParam("nickname")String nickname,
//    @RequestParam("password")String password,
//    @RequestParam("gender")String gender,
//    @RequestParam("mobile")String mobile,
//    @RequestParam("birth")Date birth,
//    @RequestParam("signature")String signature,
//    @RequestParam("userId")Long userId
    public void update(@RequestBody User user){
//        User user = new User(userId,nickname,password,gender,mobile,birth,signature);
        userService.update(user);
    }
    @GetMapping("/user/following/topics/{userId}")
    public List<Topic> getTopics(@PathVariable("userId")Long userId){
        return topicService.getTopicsByUserId(userId);
    }
    @GetMapping("/user/following/attractions/{userId}")
    public List<Attraction> getAttractions(@PathVariable("userId")Long userId){
        return attractionService.getAttractionsByUserId(userId);
    }
    @GetMapping("/user/following/users/{userId}/{type}")
    public List<User> getFollowing(@PathVariable("userId")Long userId,@PathVariable("type")char type){
        return userService.getFollowing(userId,type);
    }


    @GetMapping("/user/profile/followers/{userId}")
    public List<User> getFollowers(@PathVariable("userId")Long userId){
        return userService.getFollowers(userId);
    }
  
    @GetMapping("/user/profile/visited/{userId}")
    public List<Attraction> getVisited(@PathVariable("userId")Long userId){
        return attractionService.getVisited(userId);
    }
  
    @GetMapping("/user/profile/want/{userId}")
    public List<Attraction> getWant(@PathVariable("userId")Long userId){
        return attractionService.getWant(userId);
    }
  
    @GetMapping("/user/profile/album/{userId}")
    public List<String> getAlbum(@PathVariable("userId")Long userId){
        return userService.getAlbum(userId);
    }
  
    @GetMapping("/user/profile/posts/{userId}")
    public List<Post> getPosts(@PathVariable("userId")Long userId){
        return postService.getPosts(userId);
    }

    @GetMapping("/user/profile/articles/{userId}")
    public List<Article> getArticles(@PathVariable("userId")Long userId){
        return articleService.getArticles(userId);
    }

    @GetMapping("/user/profile/favorites/{userId}")
    public List<Favorites> getFavorites(@PathVariable("userId")Long userId){
        return favoritesService.getFavorites(userId);
    }

    @GetMapping("/user/profile/relation/{friendId}")
    public Integer getRelation(@PathVariable("friendId")Long friendId){
        Long userId = TokenUtil.getUserId();
        return Integer.parseInt(userService.getRelation(userId,friendId));
    }

    @GetMapping("/user/host/attractions/{userId}")
    public List<Attraction> getHostAttractions(@PathVariable("userId")Long userId){
        return attractionService.getHostAttractionsByUserId(userId);
    }

    @GetMapping("/user/host/topics/{userId}")
    public List<Topic> getHostTopics(@PathVariable("userId")Long userId){
        return topicService.getHostTopicsByUserId(userId);
    }
    @PostMapping("/user/operation/follow/{userId}")
    public void follow(@PathVariable("userId")Long userId){
        userService.follow(userId);
    }

    @PostMapping("/user/operation/special/{userId}")
    public void special(@PathVariable("userId")Long userId){
        userService.special(userId);
    }

    @PostMapping("/user/operation/unfollow/{userId}")
    public void unfollow(@PathVariable("userId")Long userId){
        userService.unfollow(userId);
    }

    @PostMapping("/user/operation/block/{userId}")
    public void block(@PathVariable("userId")Long userId){
        userService.block(userId);
    }


}
