package com.todocodeacademy.spring.security2.service;

import com.todocodeacademy.spring.security2.model.UserSec;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List findAll();
    public Optional<UserSec> findById(Long id);
    public UserSec save(UserSec userSec);
    public void deleteById(Long id);
    public void update(UserSec userSec);
}
