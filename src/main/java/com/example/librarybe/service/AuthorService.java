package com.example.librarybe.service;

import com.example.librarybe.model.Author;
import com.example.librarybe.model.DTOs.AuthorDto;

import java.util.*;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(AuthorDto author);
    void deleteById(Long id);
}
