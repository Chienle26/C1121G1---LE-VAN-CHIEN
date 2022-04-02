package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "iphone 12", 15000.0, "chip A12", "Apple"));
        productMap.put(2, new Product(2, "iphone 13", 17000.0, "chip A13", "Apple"));
        productMap.put(3, new Product(3, "Samsung Note 20", 16000.0, "snap888", "Samsung"));
        productMap.put(4, new Product(4, "Oppo findX", 15000.0, "snap865", "Oppo"));
        productMap.put(5, new Product(5, "Mi 11T", 14000.0, "snap888", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String search) {
        List<Product> products = this.findAll();
        List<Product> searchProducts = new ArrayList<>();
        for (Product product: products){
            if (product.getName().contains(search)){
                searchProducts.add(product);
            }
        }
        return searchProducts;
    }
}
