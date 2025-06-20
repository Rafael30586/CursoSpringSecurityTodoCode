package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Author;
import com.todocodeacademy.blog_online.model.UserSec;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<UserSec> findAll();
    public Optional<UserSec> findById(Long id);
    public void deleteById(Long id);
    public UserSec save(UserSec user);
    public UserSec update(UserSec user);
    public String encriptPassword(String password);
}
