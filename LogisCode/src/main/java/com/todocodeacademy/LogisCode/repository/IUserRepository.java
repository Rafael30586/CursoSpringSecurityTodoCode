package com.todocodeacademy.LogisCode.repository;

import com.todocodeacademy.LogisCode.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserSec,Long> {

    Optional<UserSec> findByUsername(String username);
}
