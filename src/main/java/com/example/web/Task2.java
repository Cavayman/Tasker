package com.example.web;

import com.example.repository.domain.Movie;
import com.example.service.MovieService;

import com.example.web.mappers.MovieMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


//Task 2. (/task2)
//        Insert the following movies into the Movie table:
//        movieId title director
//        9 Deadpool Tim Miller
//        10 The 300 spartans Zak Snyder
//        Return all movies.
@WebServlet(urlPatterns = "/task2")
@Resource
public class Task2 extends HttpServlet {
    private MovieService movieService = new MovieService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            //here must be log4j logging but i think it's not necessary
        }

        List<Movie> movies = MovieMapper.JsonToObject(mapper.readTree(jb.toString()));
        movieService.saveList(movies);

        ArrayNode jsonNodes = MovieMapper.ObjectListToJson(movieService.findAll());
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
