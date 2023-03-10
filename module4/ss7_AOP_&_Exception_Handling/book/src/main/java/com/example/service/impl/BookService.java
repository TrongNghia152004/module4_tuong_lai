package com.example.service.impl;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBook() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        BookDTO bookDTO;
        for (Book book : bookList) {
            bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO findById(int id) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(Object.requireNonNull(bookRepository.findById(id).orElse(null)), bookDTO);
        return bookDTO;
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
