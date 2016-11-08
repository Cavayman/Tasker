package com.example.web.DTO;

import com.example.repository.domain.Rating;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingDateDTO {
    private Integer rating;
    private Date ratingDate;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public static List<RatingDateDTO> mapToRatingDateDTO(List<Rating> r){
        List<RatingDateDTO> ratingDateDTOs=new ArrayList<>();
        for(Rating rating:r){
            RatingDateDTO ratingDateDTO=new RatingDateDTO();
            ratingDateDTO.setRatingDate(rating.getRatingDate());
            ratingDateDTO.setRating(rating.getRating());
                    ratingDateDTOs.add(ratingDateDTO);
        }
        return ratingDateDTOs;
    }

}
