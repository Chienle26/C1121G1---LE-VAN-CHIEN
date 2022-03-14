package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Integer id);

    void update(Integer id, String name, Double price, String description, String producer);

    public void save(Integer id, String name, Double price, String description, String producer);

    void remove (Integer id);

    List<Product> searchByName(String name);
}
