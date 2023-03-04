package com.mypro.service;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.User;
import com.mypro.beans.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDTO signup(UserDTO userDTO);

    public UserDTO loginServ(UserDTO userDTO);


    /**
     * 根据id获取用户
     *
     * @param userId
     * @return
     */
    public User getInfoById(Long userId);
    public List<User> getFollowing(Long userId,char type);
    public List<User> getFollowers(Long userId);

    List<String> getAlbum(Long userId);
    String getRelation(Long userId,Long friendId);

    PageInfo<User> findUsers(Integer pagesize, Integer pagenum, String nickname, String mobile, String signature);

    Boolean saveUser(User user);


    Boolean delete(Long userId);

    Boolean batchDelete(Long[] ids);


    void update(User user);

    void follow(Long userId);

    void special(Long userId);

    void unfollow(Long userId);

    void block(Long userId);

    PageInfo<User> findUserByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum);
}
