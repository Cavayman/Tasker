package com.example.service;

import com.example.repository.dao.MoviesDAO;
import com.example.repository.domain.Movie;
import com.example.repository.domain.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class MovieService {
    MoviesDAO moviesDAO = new MoviesDAO();

    public List<Movie> findAll() {
        return moviesDAO.findAll();
    }
    public void update(Movie movie){
        moviesDAO.update(movie);
    }
    public void saveList(List<Movie>movies){
        for(Movie m:movies){
            moviesDAO.save(m);
        }
    }
    public void deleteById(int id){
        if(findById(id)!=null){
            moviesDAO.deleteMovieById(id);
        }
    }
    public List<Movie> findMoviesWithoutRating(){
       return moviesDAO.findMoviesWithoutRating();
    }
    public Movie findById(int Id){
       return moviesDAO.findById(Id);
    }
    public void save(Movie movie){
        moviesDAO.save(movie);
    }

}
