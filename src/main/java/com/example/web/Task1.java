package com.example.web;

import com.example.repository.domain.Rating;
import com.example.service.RatingService;
import com.example.web.jsonMappers.RatingMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Task 1. (/task1)
 * Some date in rating is lost. Find the userId of all users who have ratings with a NULL
 * value for the date. Set it to today's date in database.
 * Return all ratings.
 */
@WebServlet(urlPatterns = "/task1")
@Resource
public class Task1 extends HttpServlet {
    private RatingService ratingService = new RatingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Rating> ratings = ratingService.findAll();

        //searching for nulls and updating them
        for (Rating rating : ratings) {
            if (rating.getRatingDate() == null) {
                rating.setRatingDate(new java.sql.Date(new Date().getTime()));
                ratingService.update(rating);
            }
        }

        ArrayNode jsonNodes = RatingMapper.ObjectListToJson(ratingService.findAll());
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();

    }

}
