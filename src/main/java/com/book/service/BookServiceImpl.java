package com.book.service;

import com.book.dto.BookDTO;
import com.book.entity.Book;
import com.book.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book = bookRepository.save(book);


        bookDTO.setId(book.getId());
        log.info("Saving book: {}", bookDTO.getTitle());
        return bookDTO;
    }

    @Override
    public List<BookDTO> findAll() {
        log.info("getting all books from db");
        return bookRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public BookDTO findById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToDto)

                .orElse(null);
    }

    private BookDTO convertToDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        return dto;
    }
}
