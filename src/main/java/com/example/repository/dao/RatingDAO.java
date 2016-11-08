package com.example.repository.dao;

import com.example.repository.domain.Movie;
import com.example.repository.domain.Rating;
import com.example.repository.utils.DBCPUtils;
import com.example.web.DTO.RatingUserMovieDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingDAO {

    public void update(Rating rating) {
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("update rating set " +
                     "id=?,userId=?,movieId=?,rating=?,ratingDate=? where id=?")) {
            ps.setInt(1, rating.getId());
            ps.setInt(2, rating.getUserId());
            ps.setInt(3, rating.getMovieId());
            ps.setInt(4, rating.getRating());
            ps.setDate(5, rating.getRatingDate());
            ps.setInt(6, rating.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rating> findBetweenRating(int min, int max) {
        List<Rating> ratingList = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from rating where rating in(?,?) order by ratingDate ASC")) {
            ps.setInt(1, min);
            ps.setInt(2, max);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Rating rating = new Rating();
                    rating.setId(rs.getInt(1));
                    rating.setUserId(rs.getInt(2));
                    rating.setMovieId(rs.getInt(3));
                    rating.setRating(rs.getInt(4));
                    rating.setRatingDate(rs.getDate(5));
                    ratingList.add(rating);
                }
                return ratingList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RatingUserMovieDTO> TitleUserNameByRating(){
        List<RatingUserMovieDTO> dtos = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT movie.title,user.name,rating.rating FROM rating " +
                     "left join user on rating.userId=user.id\n" +
                     "left join movie on rating.movieId=movie.id " +
                     "group by user.name,rating.rating\n" +
                     " ")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RatingUserMovieDTO rating = new RatingUserMovieDTO();
                    rating.setTitle(rs.getString(1));
                    rating.setUserName(rs.getString(2));
                    rating.setRating(rs.getString(3));
                    dtos.add(rating);
                }
                return dtos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rating> findSameColByRatingDate(){
        List<Rating> dtos = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select rating,ratingDate, count(*) from rating" +
                     " group by ratingDate HAVING count(*) > 1;\n")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Rating rating = new Rating();
                    rating.setRating(rs.getInt(1));
                    rating.setRatingDate(rs.getDate(2));
                    dtos.add(rating);
                }
                return dtos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<Rating> findAll() {
        List<Rating> ratingList = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from rating")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Rating rating = new Rating();
                    rating.setId(rs.getInt(1));
                    rating.setUserId(rs.getInt(2));
                    rating.setMovieId(rs.getInt(3));
                    rating.setRating(rs.getInt(4));
                    rating.setRatingDate(rs.getDate(5));
                    ratingList.add(rating);
                }
                return ratingList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
