package com.example.librarybe.controller;

import com.example.librarybe.model.Author;
import com.example.librarybe.model.DTOs.AuthorDto;
import com.example.librarybe.service.AuthorService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @PostMapping()
    public void saveAuthor(@RequestBody AuthorDto authorDto) {
        this.authorService.save(authorDto);
    }
}