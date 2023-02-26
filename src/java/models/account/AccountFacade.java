/*
 * To change this license header, choose License Headeresult in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.DBContext;

/**
 *
 * @author daing
 */
public class AccountFacade {

    public static Account selectById(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "select * from accounts where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        Account account = new Account();
        if (result.next()) {
            account.setId(result.getInt("id"));
            account.setEmail(result.getString("email"));
            account.setName(result.getString("name"));
            account.setPassword(result.getString("password"));
            account.setPhone(result.getString("phone"));
            account.setRole(result.getInt("role"));
            account.setStatus(result.getInt("status"));
        } else {
            account = null;
        }
        con.close();
        return account;
    }

    public static Account selectByEmail(String email) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "select * from accounts where email = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet result = preparedStatement.executeQuery();
        Account account = new Account();
        if (result.next()) {
            account.setId(result.getInt("id"));
            account.setEmail(result.getString("email"));
            account.setName(result.getString("name"));
            account.setPassword(result.getString("password"));
            account.setPhone(result.getString("phone"));
            account.setRole(result.getInt("role"));
            account.setStatus(result.getInt("status"));
        } else {
            account = null;
        }
        con.close();
        return account;
    }

    public static int insert(Account account) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "INSERT INTO accounts(email, password, name, phone, status, role)\n"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, account.getEmail());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setString(3, account.getName());
        preparedStatement.setString(4, account.getPhone());
        preparedStatement.setInt(5, account.getStatus());
        preparedStatement.setInt(6, account.getRole());
        int count = preparedStatement.executeUpdate();
        con.close();
        return count;
    }
    
    public static int update(Account account) throws SQLException {
        Connection con = DBContext.getConnection();
        String sql = "UPDATE accounts SET email = ?, password = ?, name = ?, phone = ?, status = ?, role = ? WHERE id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, account.getEmail());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setString(3, account.getName());
        preparedStatement.setString(4, account.getPhone());
        preparedStatement.setInt(5, account.getStatus());
        preparedStatement.setInt(6, account.getRole());
        preparedStatement.setInt(7, account.getId());
        int count = preparedStatement.executeUpdate();
        con.close();
        return count;
    }
}
