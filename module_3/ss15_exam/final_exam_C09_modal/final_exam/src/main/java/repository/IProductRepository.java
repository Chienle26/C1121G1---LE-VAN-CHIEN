package repository;

import DTO.ProductDTO;
import model.Category;
import model.Color;
import model.Product;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> getAllProductDTO();

    List<Category> getAllCategory();

    List<Color> getAllColor();

    void addNewProduct(Product product);

    List<ProductDTO> findProductByName(String nameSearch);

    boolean deleteProduct(Integer id);

    List<Product> getAllProduct();

    boolean editProduct(Product product);
}
