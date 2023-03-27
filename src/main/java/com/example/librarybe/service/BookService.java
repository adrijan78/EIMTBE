package com.example.librarybe.service;

import com.example.librarybe.model.Book;
import com.example.librarybe.model.DTOs.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void AddBook(BookDto book);

    Page<Book> FindAllWithPagination(Pageable pageable);

    Book EditBook(Long bookId, BookDto book);
    void DeleteBook(Long bookId);
}
