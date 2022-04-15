package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);

    Page<Blog> findAllPaging (String search, Pageable pageable);

    Page<Blog> findByCategory(String categoryName, Pageable pageable);
}
