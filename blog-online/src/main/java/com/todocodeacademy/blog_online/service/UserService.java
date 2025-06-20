package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.UserSec;
import com.todocodeacademy.blog_online.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<UserSec> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserSec save(UserSec user) {
        return repository.save(user);
    }

    @Override
    public UserSec update(UserSec user) {
        return repository.save(user);
    }

    @Override
    public String encriptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
