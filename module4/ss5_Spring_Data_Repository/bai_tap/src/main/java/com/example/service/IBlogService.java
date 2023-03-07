package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String name, Pageable pageable);

    void createBlog(Blog blog);

    Blog findBlogById(int id);

    void deleteBlog(int id);

    void updateBlog(Blog blog);
}
