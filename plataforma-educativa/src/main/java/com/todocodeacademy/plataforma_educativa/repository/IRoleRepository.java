package com.todocodeacademy.plataforma_educativa.repository;

import com.todocodeacademy.plataforma_educativa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}
