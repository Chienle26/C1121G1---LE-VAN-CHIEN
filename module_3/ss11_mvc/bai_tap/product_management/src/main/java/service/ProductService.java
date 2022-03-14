package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    void update(Integer id, String name, Double price, String description, String producer);

    public void save(Integer id, String name, Double price, String description, String producer);

    void remove (Integer id);

    List<Product> search (String name);
}
