package com.mypro.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Attraction;
import com.mypro.beans.Post;
import com.mypro.beans.Topic;
import org.springframework.stereotype.Service;

@Service


public interface TopicService {
    public List<Topic> getTopicsByUserId(Long userId);

    List<Topic> getHostTopicsByUserId(Long userId);

    PageInfo<Topic> findTopicsByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum);

    Topic Info(Long topicId);

    List<Post> getPosts(Long topicId);

    List<Article> getArticles(Long topicId);

    void createTopic(Topic topic);

    void updateTopic(Topic topic);

    Integer relation(Long topicId);
}
