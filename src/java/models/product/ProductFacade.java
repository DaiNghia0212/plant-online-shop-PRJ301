/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import models.DBContext;

/**
 *
 * @author daing
 */
public class ProductFacade {

    public static int insert(String name, int price, int quantity, String imagePath, String description, int categoryId)
            throws SQLException {
        int result = 0;
        Connection con = DBContext.getConnection();
        String sql = "INSERT INTO products(name, price, quantity, image_path, description, categoryId)\n"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, price);
        preparedStatement.setInt(3, quantity);
        preparedStatement.setString(4, imagePath);
        preparedStatement.setString(5, description);
        preparedStatement.setInt(6, categoryId);
        result = preparedStatement.executeUpdate();
        con.close();
        return result;
    }

    public HashMap<String, Object> getProducts(String search, ArrayList categoriesList, String orderBy, String orderType, int offset, int fetch) throws SQLException {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Product> list = new ArrayList<>();
        int total = 0;
        Connection con = DBContext.getConnection();
        String sql1 = "SELECT *\n"
                + "FROM products\n"
                + "%s\n"
                + "ORDER BY products.%s %s\n"
                + "OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
        String sql2 = "SELECT COUNT(*) as total FROM products\n"
                + "%s\n";
        if (orderType.equals("ascending")) {
            orderType = "ASC";
        } else {
            orderType = "DESC";
        }
        String whereStatement = "WHERE products.quantity > 0";
        if (search != null) {
            whereStatement = whereStatement + " AND products.name LIKE '%" + search.trim() + "%'";
        }
        if (!categoriesList.isEmpty()) {
            String categories = categoriesList.toString();
            whereStatement = whereStatement + " AND products.category_id in (" + categories.substring(1, categories.length() - 1) + ")";
        }
        sql1 = String.format(sql1, whereStatement, orderBy, orderType);
        sql2 = String.format(sql2, whereStatement);
        Statement statement = con.createStatement();
        PreparedStatement preparedStatement = con.prepareStatement(sql1);
        preparedStatement.setInt(1, offset);
        preparedStatement.setInt(2, fetch);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int price = result.getInt("price");
            int quantity = result.getInt("quantity");
            String imagePath = result.getString("image_path");
            String description = result.getString("description");
            Date createdAt = result.getDate("created_at");
            Date updatedAt = result.getDate("updated_at");
            int categoryId = result.getInt("category_id");
            Product product = new Product(id, name, price, quantity, imagePath, description, createdAt, updatedAt, categoryId);
            list.add(product);
        }
        result = statement.executeQuery(sql2);
        if (result.next()) {
            total = result.getInt("total");
        }
        con.close();
        map.put("products", list);
        map.put("total", total);
        return map;
    }

    public Product getProductById(int id) throws SQLException {
        Connection cn = DBContext.getConnection();
        String sql = "SELECT *\n"
                + "FROM products\n"
                + "WHERE products.id = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            String imgpath = rs.getString("image_path");
            String description = rs.getString("description");
            Date createdAt = rs.getDate("created_at");
            Date updatedAt = rs.getDate("updated_at");
            int cateid = rs.getInt("category_id");
            Product product = new Product(id, name, price, quantity, imgpath, description, createdAt, updatedAt, cateid);
            return product;
        }
        cn.close();
        return null;
    }

    public ArrayList<Product> getRelatedProducts(int categoryId) throws SQLException {
        Connection cn = DBContext.getConnection();
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM products\n"
                + "WHERE products.category_id = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, categoryId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            String imgpath = rs.getString("image_path");
            String description = rs.getString("description");
            Date createdAt = rs.getDate("created_at");
            Date updatedAt = rs.getDate("updated_at");
            int cateid = rs.getInt("category_id");
            Product product = new Product(id, name, price, quantity, imgpath, description, createdAt, updatedAt, cateid);
            list.add(product);
        }
        return list;
    }
//     delete product by id

    public int delete(int id) throws Exception {
        int result = 0;
        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "DELETE FROM products\n"
                    + "	WHERE id= ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

    //update product
    public static int updateProducts(String name, int price, int quantity, String imagePath, String description, int categoryId) throws Exception {
        int result = 0;
        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "update dbo.products set  name='?',price='?',quantity='?',image_path='?',description='?',category_id='?' FROM products  where [id] = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setInt(2, price);
            pst.setInt(3, quantity);
            pst.setString(4, imagePath);
            pst.setString(5, description);
            pst.setInt(6, categoryId);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

}
