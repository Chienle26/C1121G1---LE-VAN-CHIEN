package service.impl;

import DTO.ProductDTO;
import model.Category;
import model.Color;
import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository repository = new ProductRepository();

    @Override
    public List<ProductDTO> getAllProDuctDTO() {
        return repository.getAllProductDTO();
    }

    @Override
    public List<Category> getAllCategory() {
        return repository.getAllCategory();
    }

    @Override
    public void addNewProduct(Product product) {
        repository.addNewProduct(product);
    }

    @Override
    public List<Color> getAllColor() {
        return repository.getAllColor();
    }

    @Override
    public List<ProductDTO> findProductByName(String nameSearch) {
        return repository.findProductByName(nameSearch);
    }

    @Override
    public boolean deleteProduct(Integer id) {
       return repository.deleteProduct(id);
    }

    @Override
    public List<Product> getAllProDuct() {
        return repository.getAllProduct();
    }

    @Override
    public boolean editProduct(Product product) {
        return repository.editProduct(product);
    }
}
