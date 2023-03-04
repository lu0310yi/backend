package com.mypro.service;


import com.github.pagehelper.PageInfo;
import com.mypro.beans.Article;
import com.mypro.beans.Collection;
import com.mypro.beans.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    List<Article> getArticles(Long userId);

    Article info(Long articleId);

    List<Comment> getComments(Long articleId);

    void collect(Collection collection);

    void comment(Comment comment);

    void publish(Article article);

    void delete(Long articleId);

    void update(Article article);
    void thumbup(Long articleID);

    Boolean isthumbup(Long articleId);

    List<Collection> iscollect(Long articleId);

    PageInfo<Article> findArticleByKey(String key, Integer filter, String order, Integer pagesize, Integer pagenum);

    PageInfo<Article> recommend(Integer pageNum, Integer pageSize);

    void uncollect(Collection collection);

    void unthumbup(Long articleId);
}
