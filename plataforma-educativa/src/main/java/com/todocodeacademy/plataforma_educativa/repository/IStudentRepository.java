package com.todocodeacademy.plataforma_educativa.repository;

import com.todocodeacademy.plataforma_educativa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
