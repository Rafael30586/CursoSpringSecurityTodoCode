package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Professor;
import com.todocodeacademy.plataforma_educativa.model.Student;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    public List<Professor> findAll();
    public Optional<Professor> findById(Long id);
    public Professor save(Professor professor);
    public void deleteById(Long id);
    public Professor update(Professor professor);
}
