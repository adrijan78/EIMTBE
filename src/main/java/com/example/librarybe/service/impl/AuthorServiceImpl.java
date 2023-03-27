package com.example.librarybe.service.impl;

import com.example.librarybe.model.Author;
import com.example.librarybe.model.Country;
import com.example.librarybe.model.DTOs.AuthorDto;
import com.example.librarybe.model.exceptions.AuthorNotFoundException;
import com.example.librarybe.repository.AuthorRepository;
import com.example.librarybe.repository.CountryRepository;
import com.example.librarybe.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();

    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(this.authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id)));
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Optional<Country> c = countryRepository.findById(authorDto.getCountryId());
        if(!c.isPresent()){
            throw new RuntimeException("country not found");
        }
        Author a = new Author(authorDto.getName(), authorDto.getSurname(), c.get());
        authorRepository.save(a);
        return Optional.of(a);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
