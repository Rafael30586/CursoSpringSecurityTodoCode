package com.todocodeacademy.spring.security2.service;

import com.todocodeacademy.spring.security2.model.UserSec;
import com.todocodeacademy.spring.security2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository repository;

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserSec save(UserSec userSec) {
        return repository.save(userSec);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(UserSec userSec) {
        repository.save(userSec);
    }
}
