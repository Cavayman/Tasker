package com.example.web;

import com.example.repository.domain.Movie;
import com.example.repository.domain.Rating;
import com.example.repository.domain.User;
import com.example.service.MovieService;
import com.example.service.RatingService;
import com.example.service.UserService;
import com.example.web.mappers.MovieMapper;
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
import java.util.List;

/**
 * Task 0. (/task0/users; /task0/movies; /task0/ratings)
 * Return all users, movies, ratings.
 */
@WebServlet(urlPatterns = "/task0")
@Resource
public class Task0 extends HttpServlet {
    private MovieService movieService = new MovieService();
    private RatingService ratingService = new RatingService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = movieService.findAll();
        List<Rating> ratings = ratingService.findAll();
        List<User> users = userService.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode finalJson = objectMapper.createArrayNode();
        finalJson.addAll(MovieMapper.ObjectListToJson(movies));
        finalJson.addAll(RatingMapper.ObjectListToJson(ratings));
        finalJson.addAll(UserMapper.ObjectListToJson(users));

        PrintWriter out = resp.getWriter();
        out.print(finalJson);
        out.flush();
    }

}
