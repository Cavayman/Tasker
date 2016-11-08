package com.example.web.DTO;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingUserMovieDTO {

    private String title;
    private String userName;
    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RatingUserMovieDTO{" +
                "title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
