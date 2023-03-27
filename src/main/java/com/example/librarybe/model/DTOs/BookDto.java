package com.example.librarybe.model.DTOs;

import com.example.librarybe.model.enums.Categories;
import jdk.jfr.Category;
import lombok.Data;

import java.util.Locale;

@Data
public class BookDto {
    private String name;
    private Categories category;
    private Integer availableCopies;
    private Long authorId;

    public BookDto() {
    }

    public BookDto(String name, Categories category, Integer availableCopies, Long authorId) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.authorId = authorId;
    }
}

