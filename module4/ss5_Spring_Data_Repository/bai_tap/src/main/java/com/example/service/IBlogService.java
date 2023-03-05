package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll(String name);

    void createBlog(Blog blog);

    Blog findBlogById(int id);

    void deleteBlog(int id);

    void updateBlog(Blog blog);
}
