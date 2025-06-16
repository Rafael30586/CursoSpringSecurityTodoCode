package com.todocodeacademy.plataforma_educativa.repository;

import com.todocodeacademy.plataforma_educativa.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByUsername(String username);
}
