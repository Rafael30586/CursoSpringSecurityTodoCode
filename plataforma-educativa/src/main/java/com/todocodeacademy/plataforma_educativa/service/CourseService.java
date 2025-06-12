package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.model.Professor;
import com.todocodeacademy.plataforma_educativa.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private ICourseRepository repository;
    
    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Course update(Course course) {
        return repository.save(course);
    }
}
