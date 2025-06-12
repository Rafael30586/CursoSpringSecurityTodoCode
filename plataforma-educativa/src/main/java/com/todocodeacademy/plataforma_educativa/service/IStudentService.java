package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.dto.StudentDTO;
import com.todocodeacademy.plataforma_educativa.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> findAll();
    public List<StudentDTO> findAllDTOs();
    public Optional<Student> findById(Long id);
    public StudentDTO findDTOById(Long id);
    public Student save(Student student);
    public void deleteById(Long id);
    public Student update(Student student);
}
