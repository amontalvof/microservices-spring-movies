package com.movie.ratingsservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> userRating;
    private String userId;

    public UserRating() {
    }

    public UserRating(List<Rating> userRating, String userId) {
        this.userRating = userRating;
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getUserRating() {
        return this.userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

}
