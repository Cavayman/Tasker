package com.example.web.DTO;

import java.sql.Date;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingDateDTO {
    private String rating;
    private Date ratingDate;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

}
