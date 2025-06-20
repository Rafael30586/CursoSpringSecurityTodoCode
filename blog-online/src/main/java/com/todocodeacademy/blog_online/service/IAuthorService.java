package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.model.Post;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    public List<Author> findAll();
    public Optional<Author> findById(Long id);
    public void deleteById(Long id);
    public Author save(Author author);
    public Author update(Author author);
}
