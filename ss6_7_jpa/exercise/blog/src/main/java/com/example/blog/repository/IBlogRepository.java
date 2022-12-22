package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

    @Query(value = "select * from Blog where title like %:title%", nativeQuery = true)
    Page<Blog> searchByTitle(@Param("title") String title, Pageable pageable);
}
