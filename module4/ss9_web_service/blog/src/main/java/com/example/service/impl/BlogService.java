package com.example.service.impl;

import com.example.dto.BlogDTO;
import com.example.dto.CategoryDTO;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<BlogDTO> findAll(Pageable pageable) {
        Page<Blog> blogList = blogRepository.findAll(pageable);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        BlogDTO blogDTO;
        for (Blog blog : blogList) {
            blogDTO = new BlogDTO();
            blogDTO.setCategoryDTO(new CategoryDTO());
            BeanUtils.copyProperties(blog.getCategory(), blogDTO.getCategoryDTO());
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTOList.add(blogDTO);
        }
        return new PageImpl<>(blogDTOList);
    }

    @Override
    public BlogDTO findById(int id) {
        BlogDTO blogDTO = new BlogDTO();
        Blog blog = blogRepository.findById(id).get();
        blogDTO.setCategoryDTO(new CategoryDTO());
        BeanUtils.copyProperties(blog.getCategory(), blogDTO.getCategoryDTO());
        BeanUtils.copyProperties(blog, blogDTO);
        return blogDTO;
    }
}
