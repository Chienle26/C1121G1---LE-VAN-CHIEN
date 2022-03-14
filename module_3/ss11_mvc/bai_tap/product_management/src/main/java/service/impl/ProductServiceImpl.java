package service.impl;

import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = this.productRepository.findById(id);
        return product;
    }

    @Override
    public void update(Integer id, String name, Double price, String description, String producer) {
        if (name.equals("")) {
            System.out.println("Tên không được để trống");
            return;
        }

        if (price.equals("")) {
            System.out.println("Giá không được để trống");
            return;
        }

        if (description.equals("")) {
            System.out.println("Mô tả không được để trống");
            return;
        }

        if (producer.equals("")) {
            System.out.println("Tên nhà sản xuất không được để trống");
            return;
        }
        productRepository.update(id, name, price, description, producer);
    }

    @Override
    public void save(Integer id, String name, Double price, String description, String producer) {
        productRepository.save(id, name, price, description, producer);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.searchByName(name);
    }
}
