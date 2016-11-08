package com.example.web;

import com.example.repository.dao.RatingDAO;
import com.example.service.RatingService;
import com.example.web.mappers.RatingMapper;
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
 * Task 3. (/task3)
 * Return the movieID, ratingDate of all movies that received a rating of 4 or 5, and sort
 * them in increasing order by ratingDate.
 */
@WebServlet(urlPatterns = "/task3")
@Resource
public class Task3 extends HttpServlet {
    private RatingService ratingService = new RatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonNodes = objectMapper.createArrayNode();
        jsonNodes.addAll(RatingMapper.ObjectListToJson(ratingService.findBetweenRating(4, 5)));
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
