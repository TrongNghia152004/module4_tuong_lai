package com.example.service;

import com.example.model.Book;
import com.example.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll(String search) {
        return iBookRepository.findAll();
    }
}
