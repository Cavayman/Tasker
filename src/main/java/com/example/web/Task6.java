package com.example.web;

import com.example.service.RatingService;
import com.example.web.jsonMappers.RatingUserMovieDTOMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Task 6. (/task6)
 * Return the title of the movie, user name and rating for every rating.SQL script:
 */
@WebServlet(urlPatterns = "/task6")
@Resource
public class Task6 extends HttpServlet {
    private RatingService ratingService = new RatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonNodes = objectMapper.createArrayNode();
        jsonNodes.addAll(RatingUserMovieDTOMapper.ObjectListToJson(ratingService.findTitleUserNameByRating()));
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(jsonNodes);
        out.close();
    }
}
