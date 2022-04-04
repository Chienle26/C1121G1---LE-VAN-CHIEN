package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        if (product.getId() == null) {
            BaseRepository.entityManager.persist(product);
        } else {
            BaseRepository.entityManager.merge(product);
        }

        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String search) {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select p from product p where p.name like ?1",Product.class);
        typedQuery.setParameter(1,"%" + search + "%");
        return typedQuery.getResultList();
    }
}
