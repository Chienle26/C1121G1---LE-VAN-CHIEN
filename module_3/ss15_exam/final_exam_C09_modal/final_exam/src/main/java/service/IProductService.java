package service;

import DTO.ProductDTO;
import model.Category;
import model.Color;
import model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProDuctDTO();

    List<Category> getAllCategory();

    void addNewProduct(Product product);

    List<Color> getAllColor();

    List<ProductDTO> findProductByName(String nameSearch);

    boolean deleteProduct(Integer id);

    List<Product> getAllProDuct();

    boolean editProduct(Product product);
}
