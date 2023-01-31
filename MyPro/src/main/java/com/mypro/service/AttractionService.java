package com.mypro.service;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Attraction;
import com.mypro.beans.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttractionService {
    public List<Attraction> getAttractionsByUserId(Long userId);

    List<Attraction> getVisited(Long userId);

    List<Attraction> getWant(Long userId);
    List<Attraction> getHostAttractionsByUserId(Long userId);

    PageInfo<Attraction> findAttractionsByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum);

    PageInfo<Attraction> recommend(Integer pagenum, Integer pagesize);

    Attraction Info(Long attractionId);

    List<Post> getPosts(Long attractionId);

    List<Article> getArticles(Long attractionId);

    void createAttraction(Attraction attraction);

    void updateAttraction(Attraction attraction);

    void evaluateAttraction(Long userId,Long attractionId, Double score);

    Integer relation(Long attractionId);

    void follow(Long attractionId, char type);

    void unfollow(Long attractionId);
}
