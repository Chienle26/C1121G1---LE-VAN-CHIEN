package repository.impl;

import DTO.ProductDTO;
import model.Category;
import model.Color;
import model.Product;
import repository.DatabaseConnection;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    DatabaseConnection connectDatabase = new DatabaseConnection();
    private final String SELECT_PRODUCT_DTO = "SELECT product.product_id , product.product_name , product.product_price , product.product_quantity , color.color_name , category.category_name\n" +
            " FROM my_database.product join category on product.category_id = category.category_id\n" +
            " join color on color.color_id = product.color_id  order by product.product_id ;";
    private final String SELECT_CATEGORY = "SELECT * FROM my_database.category;";
    private final String SELECT_COLOR = "SELECT * FROM my_database.color;";
    private final String INSERT_PRODUCT = "insert into product(product_name,product_price,product_quantity,color_id,category_id)\n" +
            "values(?,?,?,?,?);";
    private final String SEARCH_BY_NAME = "SELECT product.product_id , product.product_name , product.product_price , product.product_quantity , color.color_name , category.category_name\n" +
            "FROM my_database.product join category on product.category_id = category.category_id\n" +
            "join color on color.color_id = product.color_id\n" +
            "where product.product_name like concat(\"%\",?,\"%\")\n" +
            "order by product.product_id ;";
    private final String DELETE_BY_ID = "delete from product where product_id = ? ;";
    private final String SELECT_PRODUCT = "SELECT product_id , product_name , product_price , product_quantity , color_id , category_id FROM my_database.product order by product_name ;";
    private final String EDIT_PRODUCT = "update product set product_name = ? , product_price = ? , product_quantity = ? , color_id = ? , category_id = ? where product_id = ? ;";

    @Override
    public List<ProductDTO> getAllProductDTO() {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_DTO);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(rs.getInt(1));
                productDTO.setName(rs.getString(2));
                productDTO.setPrice(rs.getString(3));
                productDTO.setQuantity(rs.getString(4));
                productDTO.setColor(rs.getString(5));
                productDTO.setCategoryName(rs.getString(6));
                list.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Color> getAllColor() {
        List<Color> list = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COLOR);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Color color = new Color();
                color.setId(rs.getInt(1));
                color.setName(rs.getString(2));
                list.add(color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addNewProduct(Product product) {
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setInt(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> findProductByName(String nameSearch) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, nameSearch);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(rs.getInt(1));
                productDTO.setName(rs.getString(2));
                productDTO.setPrice(rs.getString(3));
                productDTO.setQuantity(rs.getString(4));
                productDTO.setColor(rs.getString(5));
                productDTO.setCategoryName(rs.getString(6));
                list.add(productDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteProduct(Integer id) {
        boolean check = true;
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getString(3));
                product.setQuantity(rs.getString(4));
                product.setColor(rs.getInt(5));
                product.setCategoryName(rs.getInt(6));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean editProduct(Product product) {
        boolean check = true;
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setInt(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryName());
            preparedStatement.setInt(6, product.getId());
            check = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
