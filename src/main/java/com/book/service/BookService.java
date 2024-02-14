package com.book.service;

import com.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO save(BookDTO bookDTO);

    List<BookDTO> findAll();

    BookDTO findById(Long id);
}