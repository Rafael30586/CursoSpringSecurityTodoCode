package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public List<Course> findAll();
    public Optional<Course> findById(Long id);
    public Course save(Course course);
    public void deleteById(Long id);
    public Professor update(Course course);
}
