package com.example.repository.domain;

import java.sql.Date;

/**
 * Created by cavayman on 07.11.2016.
 */
public class Rating {
    private Integer id;
    private int userId;
    private int movieId;
    private int rating;
    private Date ratingDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;

        Rating rating1 = (Rating) o;

        if (getId() != rating1.getId()) return false;
        if (getUserId() != rating1.getUserId()) return false;
        if (getMovieId() != rating1.getMovieId()) return false;
        if (getRating() != rating1.getRating()) return false;
        return getRatingDate() != null ? getRatingDate().equals(rating1.getRatingDate()) : rating1.getRatingDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + getMovieId();
        result = 31 * result + getRating();
        result = 31 * result + (getRatingDate() != null ? getRatingDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", ratingDate=" + ratingDate +
                '}';
    }
}
