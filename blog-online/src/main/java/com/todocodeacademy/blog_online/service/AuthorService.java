package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private IAuthorRepository repository;

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Author update(Author author) {
        return repository.save(author);
    }
}
