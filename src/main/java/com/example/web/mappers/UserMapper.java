package com.example.web.mappers;


import com.example.repository.domain.User;
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
public class UserMapper {
    public static ObjectNode ObjectToJson(User User) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode UserNode = mapper.createObjectNode();
        UserNode.put("id", User.getId());
        UserNode.put("name", User.getName());
        return UserNode;
    }

    public static ArrayNode ObjectListToJson(List<User> User) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode UserNode = mapper.createArrayNode();
        for (User m : User) {
            UserNode.add(ObjectToJson(m));
        }
        return UserNode;
    }


    public static List<User> JsonToObject(JsonNode UsersNode) {
        if (UsersNode.isMissingNode()) {
            return null;
        }
        List<User> UsersList = new ArrayList<>();
        for (JsonNode UserNode : UsersNode) {
            User UserObject = new User();
            UserObject.setId(UserNode.get("id").asInt());
            UserObject.setName(UserNode.get("name").asText());
            UsersList.add(UserObject);
        }
        return UsersList;
    }
}
