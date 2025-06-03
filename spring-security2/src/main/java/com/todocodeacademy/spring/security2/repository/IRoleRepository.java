package com.todocodeacademy.spring.security2.repository;

import com.todocodeacademy.spring.security2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}
