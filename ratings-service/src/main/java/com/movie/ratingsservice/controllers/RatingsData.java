package com.movie.ratingsservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ratingsservice.models.Rating;
import com.movie.ratingsservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsData {

    @GetMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("100", 4),
                new Rating("200", 3));

        return new UserRating(ratings, userId);
    }
}
