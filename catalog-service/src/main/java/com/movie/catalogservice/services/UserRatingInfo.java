package com.movie.catalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalogservice.models.Rating;
import com.movie.catalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRatingInfo", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })
    public UserRating getUserRatingInfo(String userId) {
        return restTemplate.getForObject("http://ratings-service/ratingsdata/users/" +
                userId, UserRating.class);
    }

    public UserRating getFallbackUserRatingInfo(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setUserRating(
                Arrays.asList(new Rating("0", 0)));
        return userRating;
    }
}
