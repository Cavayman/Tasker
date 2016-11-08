package com.example.web.jsonMappers;

import com.example.web.DTO.RatingDateDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 08.11.2016.
 */
public class RatingDateDTOMapper {
    public static ObjectNode ObjectToJson(RatingDateDTO dto) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode RatingNode = mapper.createObjectNode();
        RatingNode.put("rating", dto.getRating());
        RatingNode.put("ratingDate", dto.getRatingDate().toString());
        return RatingNode;
    }

    public static ArrayNode ObjectListToJson(List<RatingDateDTO> Rating) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode RatingNode = mapper.createArrayNode();
        for (RatingDateDTO m : Rating) {
            RatingNode.add(ObjectToJson(m));
        }
        return RatingNode;
    }

    public static List<RatingDateDTO> JsonToObject(JsonNode ratingsNode) {
        if (ratingsNode.isMissingNode()) {
            return null;
        }
        List<RatingDateDTO> RatingsList = new ArrayList<>();
        for (JsonNode RatingNode : ratingsNode) {
            RatingDateDTO RatingObject = new RatingDateDTO();
            RatingObject.setRating(RatingNode.get("rating").asInt());
            RatingObject.setRatingDate(new Date(RatingNode.get("ratingDate").asLong()));

            RatingsList.add(RatingObject);
        }
        return RatingsList;
    }
}
