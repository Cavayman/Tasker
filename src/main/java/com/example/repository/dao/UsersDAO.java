package com.example.repository.dao;

import com.example.repository.domain.Movie;
import com.example.repository.domain.Rating;
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
public class UsersDAO {
    public void update(User User) {
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("update user set " +
                     "id=?,name=? where id=?")) {
            ps.setInt(1, User.getId());
            ps.setString(2, User.getName());
            ps.setInt(3, User.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection con = DBCPUtils.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from user")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setName(rs.getString(2));
                    users.add(user);
                }
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAutoComitOFF(User user) throws SQLException {
        PreparedStatement updateSales = null;
        PreparedStatement updateTotal = null;
        try (Connection con = DBCPUtils.getConnection()) {

            String updateString =
                    "update user " +
                            "set id = ? where user.id = ?";

            String updateStatement =
                    "update user " +
                            "set name = ? " +
                            "where user.id = ?";

            con.setAutoCommit(false);
            updateSales = con.prepareStatement(updateString);
            updateTotal = con.prepareStatement(updateStatement);

            updateSales.setInt(1, user.getId());
            updateSales.setInt(2, user.getId());
            updateSales.execute();

            updateTotal.setString(1, user.getName());
            updateTotal.setInt(2, user.getId());
            updateTotal.execute();

            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (updateSales != null) {
                updateSales.close();
            }
            if (updateTotal != null) {
                updateTotal.close();

            }

        }
    }

}
