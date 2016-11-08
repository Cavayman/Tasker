package com.example.web.mappers;

import com.example.repository.domain.Rating;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingMapper {

    public static ObjectNode ObjectToJson(Rating Rating) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode RatingNode = mapper.createObjectNode();
        RatingNode.put("id", Rating.getId());
        RatingNode.put("userId", Rating.getUserId());
        RatingNode.put("movieId", Rating.getUserId());
        RatingNode.put("rating", Rating.getRating());
        RatingNode.put("ratingDate", Rating.getRatingDate().toString());
        return RatingNode;
    }

    public static ArrayNode ObjectListToJson(List<Rating> Rating) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode RatingNode = mapper.createArrayNode();
        for (Rating m : Rating) {
            RatingNode.add(ObjectToJson(m));
        }
        return RatingNode;
    }


    public static List<Rating> JsonToObject(JsonNode ratingsNode) {
        if (ratingsNode.isMissingNode()) {
            return null;
        }
        List<Rating> RatingsList = new ArrayList<>();
        for (JsonNode RatingNode : ratingsNode) {
            Rating RatingObject = new Rating();
            RatingObject.setId(RatingNode.get("id").asInt());
            RatingObject.setUserId(RatingNode.get("userId").asInt());
            RatingObject.setMovieId(RatingNode.get("movieId").asInt());
            RatingObject.setRating(RatingNode.get("rating").asInt());
            RatingObject.setRatingDate(new Date(RatingNode.get("ratingDate").asLong()));
            RatingsList.add(RatingObject);
        }
        return RatingsList;
    }
}