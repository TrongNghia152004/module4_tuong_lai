package com.example.service;

import com.example.dto.BookDTO;
import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<BookDTO> findAllBook();

    BookDTO findById(int id);

    void updateBook(Book book);
}
