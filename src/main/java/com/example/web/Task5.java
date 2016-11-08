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
//        Task 5. (/task5)
//        Delete the movies you added in task 2 (by id 9 and 10).
//        Return all movies
@WebServlet(urlPatterns = "/task5")
@Resource
public class Task5 extends HttpServlet {
    private MovieService movieService = new MovieService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonNodes = objectMapper.createArrayNode();
        movieService.deleteById(9);
        movieService.deleteById(10);

        jsonNodes.addAll(MovieMapper.ObjectListToJson(movieService.findAll()));
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
