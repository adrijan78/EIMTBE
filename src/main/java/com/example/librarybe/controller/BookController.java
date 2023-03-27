package com.example.librarybe.controller;

import com.example.librarybe.model.Book;
import com.example.librarybe.model.DTOs.BookDto;
import com.example.librarybe.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping()
    public Page<Book> findAll(Pageable pageable) {
        return this.bookService.FindAllWithPagination(pageable);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editById(@PathVariable Long id,
                                         @RequestBody BookDto bookDto) {
        return ResponseEntity.ok().body(this.bookService.EditBook(id, bookDto));
    }

    @PostMapping("/add")
    public void save(@RequestBody BookDto bookDto) {
        this.bookService.AddBook(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.DeleteBook(id);
        return ResponseEntity.ok().build();
    }
}
