package com.todocodeacademy.blog_online.repository;

import com.todocodeacademy.blog_online.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserSec,Long> {

    Optional<UserSec> findByUsername(String username);
}
