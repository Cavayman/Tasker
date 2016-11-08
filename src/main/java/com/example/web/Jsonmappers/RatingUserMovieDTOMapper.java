package com.example.web.jsonMappers;

import com.example.web.DTO.RatingUserMovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class RatingUserMovieDTOMapper {
    public static ObjectNode ObjectToJson(RatingUserMovieDTO dto) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode RatingNode = mapper.createObjectNode();
        RatingNode.put("userName", dto.getUserName());
        RatingNode.put("title", dto.getTitle());
        RatingNode.put("rating", dto.getRating());
        return RatingNode;
    }

    public static ArrayNode ObjectListToJson(List<RatingUserMovieDTO> Rating) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode RatingNode = mapper.createArrayNode();
        for (RatingUserMovieDTO m : Rating) {
            RatingNode.add(ObjectToJson(m));
        }
        return RatingNode;
    }

    public static List<RatingUserMovieDTO> JsonToObject(JsonNode ratingsNode) {
        if (ratingsNode.isMissingNode()) {
            return null;
        }
        List<RatingUserMovieDTO> RatingsList = new ArrayList<>();
        for (JsonNode RatingNode : ratingsNode) {
            RatingUserMovieDTO RatingObject = new RatingUserMovieDTO();
            RatingObject.setRating(RatingNode.get("rating").asText());
            RatingObject.setUserName(RatingNode.get("userName").asText());
            RatingObject.setTitle(RatingNode.get("title").asText());

            RatingsList.add(RatingObject);
        }
        return RatingsList;
    }
}
