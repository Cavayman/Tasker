package com.example.web.mappers;

import com.example.repository.domain.Movie;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class MovieMapper {

    public static ObjectNode ObjectToJson(Movie movie) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode movieNode = mapper.createObjectNode();
        movieNode.put("id", movie.getId());
        movieNode.put("title", movie.getTitle());
        movieNode.put("director", movie.getDirector());
        return movieNode;
    }

    public static ArrayNode ObjectListToJson(List<Movie> movie) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode movieNode = mapper.createArrayNode();
        for (Movie m : movie) {
            movieNode.add(ObjectToJson(m));
        }
        return movieNode;
    }


    public static List<Movie> JsonToObject(JsonNode moviesNode) {
        if (moviesNode.isMissingNode()) {
            return null;
        }
        List<Movie> moviesList = new ArrayList<>();
        for (JsonNode movieNode : moviesNode) {
            Movie movieObject = new Movie();
            movieObject.setId(movieNode.get("id").asInt());
            movieObject.setTitle(movieNode.get("title").asText());
            movieObject.setDirector(movieNode.get("director").asText());
            moviesList.add(movieObject);
        }
        return moviesList;
    }

}
