package com.example.web;

import com.example.service.RatingService;
import com.example.web.mappers.RatingMapper;
import com.example.web.mappers.UserMapper;
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
 * Task 8. (/task8)
 * Get ratings, where there are at least 2 ratings with the same date.
 */
@WebServlet(urlPatterns = "/task8")
@Resource
public class Task8 extends HttpServlet {
    private RatingService ratingService = new RatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonNodes = mapper.createArrayNode();
        jsonNodes.addAll(RatingMapper.ObjectListToJson(ratingService.findSameColByRatingDate()));
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
