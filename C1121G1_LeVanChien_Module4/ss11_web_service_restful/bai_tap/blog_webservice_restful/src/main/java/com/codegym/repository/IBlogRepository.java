package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByAuthorContainingOrderByDate(String name, Pageable pageable);

//    List<Blog> findAllByCategory_CategoryNameContaining(String categoryName);

//    @Query(value = "select * from blog join category on blog.category_id=category.id where category.category_name like concat('%',:categoryName,'%')", nativeQuery = true)
//    List<Blog> findAllBlogByCategoryName(String categoryName);

    @Query(value = "select b from blog b where b.category.categoryName like concat('%',:categoryName,'%')")
    List<Blog>findAllByCategoryName(@Param("categoryName") String categoryName);
}
