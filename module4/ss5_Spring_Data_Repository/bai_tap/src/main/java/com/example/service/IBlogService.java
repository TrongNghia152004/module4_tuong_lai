package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService<T> {
//    Page<Blog> findAll(String name, Pageable pageable);
//
//    void createBlog(Blog blog);
//
//    Blog findBlogById(int id);
//
//    void deleteBlog(int id);
//
//    void updateBlog(Blog blog);
    Iterable<T> findAll();
    Optional<T> findById(int id);
    T save(T t);
    void remove(int id);

}
