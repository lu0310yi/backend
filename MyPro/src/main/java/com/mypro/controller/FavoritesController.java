package com.mypro.controller;

import com.mypro.beans.Article;
import com.mypro.beans.Favorites;
import com.mypro.beans.Post;
import com.mypro.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class FavoritesController {
    @Autowired
    FavoritesService favoritesService;
    @GetMapping("/favorites/profile/info/{favoritesId}")
    Favorites info(@PathVariable("favoritesId")Long favoritesId){
        return favoritesService.info(favoritesId);
    }
    @GetMapping("/favorites/profile/items/{favoritesId}")
    HashMap<String,List<Long>> items(@PathVariable("favoritesId")Long favoritesId){
        return favoritesService.getItems(favoritesId);
    }
    @PostMapping("/favorites/operation/collect/{favoritesId}")
    void collect(@PathVariable("favoritesId")Long favoritesId){
        favoritesService.collect(favoritesId);
    }
    @PostMapping("/favorites/operation/thumbup/{favoritesId}")
    void thumbup(@PathVariable("favoritesId")Long favoritesId){
        favoritesService.thumbup(favoritesId);
    }
    @PostMapping("/favorites/creation/create")
    void collect(@RequestBody Favorites favorites){
        favoritesService.create(favorites);
    }
    @PostMapping("/favorites/creation/delete/{favoritesId}")
    void delete(@PathVariable("favoritesId")Long favoritesId){
        favoritesService.delete(favoritesId);
    }
    @PostMapping("/favorites/creation/update")
    void update(@RequestBody Favorites favorites){
        favoritesService.update(favorites);
    }
}
