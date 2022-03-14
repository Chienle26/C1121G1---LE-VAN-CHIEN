package repository.impl;

import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone XS max", 18000000.0, "chip Apple A12", "Apple"));
        productList.add(new Product(2, "Samsung Note20 Ultra", 16000000.0, "chip Snapdragon 865", "Samsung"));
        productList.add(new Product(3, "Iphone 13 pro max", 2000000.0, "chip A15", "Apple"));
        productList.add(new Product(4, "Mi 11", 17000000.0, "chip Snapdragon 888", "Xiaomi"));
        productList.add(new Product(5, "Google Pixel 6", 19000000.0, "chip Tensor", "Google"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, String name, Double price, String description, String producer) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setProducer(producer);
            }
        }
    }

    @Override
    public void save(Integer id, String name, Double price, String description, String producer) {
        productList.add(new Product(id, name, price, description, producer));
    }

    @Override
    public void remove(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }

}
