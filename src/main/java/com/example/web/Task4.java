package com.example.web;

import com.example.service.MovieService;
import com.example.web.jsonMappers.MovieMapper;
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
 * Task 4. (/task4)
 * Return the titles of all movies that have no ratings.
 */
@WebServlet(urlPatterns = "/task4")
@Resource
public class Task4 extends HttpServlet {
    private MovieService movieService = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonNodes = objectMapper.createArrayNode();
        jsonNodes.addAll(MovieMapper.ObjectListToJson(movieService.findMoviesWithoutRating()));
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
