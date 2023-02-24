/*
 * To change this license header, choose License Headers in Project Properties.
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

    public static Account findByEmail(String email) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("select * from accounts where email=?");
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setEmail(rs.getString("email"));
            account.setName(rs.getString("name"));
            account.setPassword(rs.getString("password"));
            account.setPhone(rs.getString("phone"));
            account.setRoles(rs.getInt("role"));
            account.setStatus(rs.getInt("status"));
            return account;
        }
        return null;
    }
}