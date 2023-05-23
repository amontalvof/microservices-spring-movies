package com.movie.catalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalogservice.models.CatalogItem;
import com.movie.catalogservice.models.UserRating;
import com.movie.catalogservice.services.MovieInfo;
import com.movie.catalogservice.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = userRatingInfo.getUserRatingInfo(userId);

        return ratings.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating))
                .collect(Collectors.toList());

    }

}
