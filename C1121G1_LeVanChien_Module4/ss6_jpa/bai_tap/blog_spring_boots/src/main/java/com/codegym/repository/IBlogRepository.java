package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByAuthor(String name);
}
