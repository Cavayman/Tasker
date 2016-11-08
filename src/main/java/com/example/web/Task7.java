package com.example.web;

import com.example.repository.domain.User;
import com.example.service.UserService;
import com.example.web.jsonMappers.UserMapper;
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

/**
 * Task 7. (/task7)
 * Update a few rows somehow using POST request.
 * Open and close transaction manually for this operation using native JDBC methods.
 */
@WebServlet(urlPatterns = "/task7")
@Resource
public class Task7 extends HttpServlet {

    private UserService userService = new UserService();

    //* we will update users throu post
    //* with autocommit(false) so transaction will be made manualy
    //
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
        List<User> users = UserMapper.JsonToObject(mapper.readTree(jb.toString()));
        for (User user : users) {
            System.out.println(user);
            userService.updateAutoComitOFF(user);
        }

        ArrayNode jsonNodes = mapper.createArrayNode();
        jsonNodes.addAll(UserMapper.ObjectListToJson(userService.findAll()));
        PrintWriter out = resp.getWriter();
        out.print(jsonNodes);
        out.close();
    }
}
