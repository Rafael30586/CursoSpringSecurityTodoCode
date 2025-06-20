package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    public List<Post> findAll();
    public Optional<Post> findById(Long id);
    public void deleteById(Long id);
    public Post save(Post post);
    public Post update(Post post);
}
