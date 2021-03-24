package com.wad.fils.course4.daos;

import com.wad.fils.course4.domain.Product;
import com.wad.fils.course4.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCProductDao implements Dao<Product>{
  @Override
  public Optional<Product> get(long id) {
    String sql="SELECT  * FROM products WHERE id = ?";
    try (Connection connection= DBConnection.getConnection();
         PreparedStatement prepStmt = connection.prepareStatement(sql);
    ){
      prepStmt.setLong(1,id);
      ResultSet rs = prepStmt.executeQuery();
      if (rs.next()) {
        return  Optional.of(new Product(rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price")));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return Optional.empty();
  }



  @Override
  public List<Product> getAll(){
    String sql="SELECT  * FROM products";
    //Better to return an empty list than a null
    List<Product> products = new ArrayList<>();
    //try-with-resources, connection will be closed at the end of try block
    //in reality it will be released to the pool
    try (Connection connection= DBConnection.getConnection();
         PreparedStatement prepStmt = connection.prepareStatement(sql);
    ){
      ResultSet rs = prepStmt.executeQuery();
      while (rs.next()) {
        products.add(new Product(rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("price")));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return products;
  }


  @Override
  public void save(Product product){
    String sql="INSERT INTO products (name, price)  VALUES(?,?)";
    try (Connection connection= DBConnection.getConnection();
         PreparedStatement prepStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ){
      prepStmt.setString(1, product.getName());
      prepStmt.setDouble(2, product.getPrice());
      int affectedRows = prepStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Creating user failed, no rows affected.");
      }
      try (ResultSet generatedKeys = prepStmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          product.setId(generatedKeys.getLong(1));
        }
        else {
          throw new SQLException("Creating user failed, no ID obtained.");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void update(Product product)  {
    String sql ="UPDATE products SET name=?, price=? WHERE id=?";
    try (Connection connection= DBConnection.getConnection();
         PreparedStatement prepStmt = connection.prepareStatement(sql);
    ){
      prepStmt.setString(1, product.getName());
      prepStmt.setDouble(2, product.getPrice());
      prepStmt.setLong(3,product.getId());
      prepStmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

  }

  @Override
  public void delete(Product product) {
    String sql ="DELETE FROM products WHERE id=?";
    try (Connection connection= DBConnection.getConnection();
         PreparedStatement prepStmt = connection.prepareStatement(sql);
    ){
      prepStmt.setLong(1, product.getId());
      prepStmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
