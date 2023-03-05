package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.repository.ICategoryRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Blog> findAll(String name) {
        return blogRepository.findByAuthorNameContaining(name);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.delete(findBlogById(id));
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
