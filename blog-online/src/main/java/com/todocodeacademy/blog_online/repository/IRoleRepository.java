package com.todocodeacademy.blog_online.repository;

import com.todocodeacademy.blog_online.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(String role);
}
