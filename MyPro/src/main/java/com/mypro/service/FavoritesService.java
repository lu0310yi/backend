package com.mypro.service;

import com.mypro.beans.Article;
import com.mypro.beans.Favorites;
import com.mypro.beans.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoritesService {

    List<Favorites> getFavorites(Long userId);

    Favorites info(Long favoritesId);

    List<Article> getItems(Long favoritesId);

    void collect(Long favoritesId);

    void thumbup(Long favoritesId);

    void create(Favorites favorites);

    void delete(Long favoritesId);

    void update(Favorites favorites);
}
