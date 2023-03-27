package com.example.librarybe.service.impl;

import com.example.librarybe.model.Author;
import com.example.librarybe.model.Book;
import com.example.librarybe.model.DTOs.BookDto;
import com.example.librarybe.repository.AuthorRepository;
import com.example.librarybe.repository.BookRepository;
import com.example.librarybe.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override

    public void AddBook(BookDto bookDto) {
        Optional<Author> a = authorRepository.findById(bookDto.getAuthorId());
        if(!a.isPresent()){
            throw new RuntimeException("author not found");
        }
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAvailableCopies(), a.get());
        bookRepository.save(book);
    }

    @Override
    public Page<Book> FindAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book EditBook(Long bookId, BookDto bookDto) {
        Optional<Book> b = bookRepository.findById(bookId);
        if(!b.isPresent()){
            throw new RuntimeException("book not found");
        }
        Book book = b.get();
        book.setCategory(bookDto.getCategory());
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Optional<Author> a = authorRepository.findById(bookDto.getAuthorId());
        if(!a.isPresent()){
            throw new RuntimeException("author not found");
        }
        book.setAuthor(a.get());
        return book;
    }

    @Override
    public void DeleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
