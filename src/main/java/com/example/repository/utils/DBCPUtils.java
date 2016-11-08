package com.example.repository.utils;


import com.example.web.DBBroker;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by cavayman on 06.11.2016.
 */
public class DBCPUtils {
    private static DataSource dataSource = null;


    /**
     * returns connection
     * @return
     */
    public static Connection getConnection() {
        Connection ct = null;
        try {
            ct = DBBroker.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }


    /**
     * return DataSource
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
