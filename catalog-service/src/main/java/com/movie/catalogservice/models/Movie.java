package com.movie.catalogservice.models;

public class Movie {
    private String id;
    private String title;
    private String overview;

    public Movie() {
    }

    public Movie(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
