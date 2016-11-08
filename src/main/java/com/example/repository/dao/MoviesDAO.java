package com.example.repository.dao;

import com.example.repository.domain.Movie;
import com.example.repository.domain.User;
import com.example.repository.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class MoviesDAO {

    public void update(Movie movie) {
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("update 'movie' set " +
                     "id=?,title=? director=? where id=?")) {
            ps.setInt(1, movie.getId());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getDirector());
            ps.setInt(4, movie.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovieById(int id){
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("delete from movie  where movie.id=?")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(Movie movie) {
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO movie VALUES(?,?,?)")) {
            ps.setInt(1, movie.getId());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getDirector());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Movie findById(int Id) {
        Movie movie = new Movie();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from movie")) {
            try (ResultSet rs = ps.executeQuery()) {
              if(rs.next()) {
                  movie.setId(rs.getInt(1));
                  movie.setTitle(rs.getString(2));
                  movie.setDirector(rs.getString(3));
              }
                return movie;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    return null;
    }
    public List<Movie> findMoviesWithoutRating(){
        List<Movie> movieList = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(
             "SELECT * FROM movie left JOIN rating  ON movie.id=rating.movieId Where rating.movieId is null")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt(1));
                    movie.setTitle(rs.getString(2));
                    movie.setDirector(rs.getString(3));
                    movieList.add(movie);
                }
                return movieList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from movie")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt(1));
                    movie.setTitle(rs.getString(2));
                    movie.setDirector(rs.getString(3));
                    movieList.add(movie);
                }
                return movieList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
