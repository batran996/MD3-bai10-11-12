package com.example.rikkei.service;

import com.example.rikkei.config.ConnectMySQL;
import com.example.rikkei.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {

    private Connection connection = ConnectMySQL.getConnection();
    private static final String CREATE_PRODUCT = " insert into products(name,price,storage) values (?,?,?)";
    private static final  String LIST_PRODUCT = "select *from products";
    private static final String PRODUCT_BY_ID = "select * from products where id = ?";
    private  static  final  String DELETE_STUDENT = "delete from products where id = ?";
    private  static  final  String EDIT_PRODUCT = "update products set name = ?,price = ?,storage = ? where id = ?";
    private  static  final String SEARCH_PRODUCT= "SELECT * FROM products WHERE name LIKE ?";


    @Override
    public List<Product> finAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int storage = resultSet.getInt("storage");

                Product product = new Product(id,name,price,storage);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void save(Product product) {
       try {
           if (findByID(product.getId()) == null){
               PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
               preparedStatement.setString(1, product.getName());
               preparedStatement.setFloat(2, product.getPrice());
               preparedStatement.setInt(3, product.getStorage());
////update lệnh ơt trên
               preparedStatement.executeUpdate();
           }else {
               PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
               preparedStatement.setString(1, product.getName());
               preparedStatement.setFloat(2, product.getPrice());
               preparedStatement.setInt(3, product.getStorage());
               preparedStatement.setInt(4,product.getId());
////update lệnh ơt trên
               preparedStatement.executeUpdate();
           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


    }

    @Override
    public Product findByID(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int storage = resultSet.getInt("storage");
                product = new Product(id,name,price,storage);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findByName(String nameSearch) {
        List<Product> productListSearch = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
            preparedStatement.setString(1,'%'+nameSearch +'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int storage = resultSet.getInt("storage");
                productListSearch.add(new Product(id,name,price,storage));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productListSearch;
    }


}
