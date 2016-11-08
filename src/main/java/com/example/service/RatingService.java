package com.example.service;

import com.example.repository.dao.RatingDAO;
import com.example.repository.domain.Rating;
import com.example.web.DTO.RatingUserMovieDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingService {
    RatingDAO ratingDAO = new RatingDAO();

    public List<Rating> findAll() {
        return ratingDAO.findAll();
    }


    public List<RatingUserMovieDTO> findTitleUserNameByRating() {
        return ratingDAO.TitleUserNameByRating();
    }
    public List<Rating> findSameColByRatingDate(){
        return ratingDAO.findSameColByRatingDate();
    }

    public void update(Rating rating) {
        ratingDAO.update(rating);
    }

    public List<Rating> findBetweenRating(int min, int max) {
        return ratingDAO.findBetweenRating(min, max);
    }

}
