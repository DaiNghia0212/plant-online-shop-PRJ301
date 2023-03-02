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
import models.DBContext;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

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

    public static ArrayList<Product> getProducts(String search, String orderBy, String orderType, int offset, int fetch) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        String sql = "SELECT products.id, products.name, price, quantity, image_path,description, products.category_id, categories.name as category_name\n"
                + "FROM products JOIN categories ON products.category_id = categories.id AND products.name LIKE ?\n"
                + "ORDER BY products.%s %s\n"
                + "OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
        if (orderType.equals("ascending"))
            orderType = "ASC";
        else
            orderType = "DESC";
        sql = String.format(sql, orderBy, orderType);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, "%" + search + "%");
        preparedStatement.setInt(2, offset);
        preparedStatement.setInt(3, fetch);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int price = result.getInt("price");
            int quantity = result.getInt("quantity");
            String imagePath = result.getString("image_path");
            String description = result.getString("description");
            int categoryId = result.getInt("category_id");
            Product product = new Product(id, name, price, quantity, imagePath, description, categoryId);
            list.add(product);
        }
        con.close();
        return list;
    }

//    public static Product getProductById(int id) throws Exception {
//        Product plant = null;
//        Connection cn = DBContext.getConnection();
//        if (cn != null) {
//            String sql = "select id,name,price,quantity,image_path,description,dbo.product.category_id as 'id',name\n"
//                    + "from dbo.categories,dbo.products\n"
//                    + "where dbo.categories.id=dbo.products.category_id\n"
//                    + "      and id = ?";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setInt(1, id);
//            ResultSet rs = pst.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {
//
//                    String name = rs.getString("name");
//                    int price = rs.getInt("price");
//                    int quantity = rs.getInt("quantity");
//                    String imgpath = rs.getString("image_path");
//                    String description = rs.getString("description");
//                    int cateid = rs.getInt("category_id");
//                    Product product = new Product(id, name, price, quantity, imgpath, description, cateid);
//                }
//            }
//            cn.close();
//        }
//        return plant;
//    }

//     delete product by id
    public static int delete(int id) throws Exception {
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
        public static int updateProducts(String name,int price,int quantity,String imagePath,String description,int categoryId) throws Exception {
        int result = 0;
        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "update dbo.products set  name='?',price='?',quantity='?',image_path='?',description='?',category_id='?' FROM products  where [id] = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setInt(2, price);
            pst.setInt(3,quantity);
            pst.setString(4, imagePath);
            pst.setString(5,description);
            pst.setInt(6,categoryId);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

}
