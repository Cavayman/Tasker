package com.example.service;

import com.example.repository.dao.UsersDAO;
import com.example.repository.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cavayman on 07.11.2016.
 */
public class UserService {
    UsersDAO usersDAO = new UsersDAO();

    public List<User> findAll() {
        return usersDAO.findAll();
    }

    public void update(User user) {
        usersDAO.update(user);
    }

    public void updateAutoComitOFF(User user){
        try {
            usersDAO.updateAutoComitOFF(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }
