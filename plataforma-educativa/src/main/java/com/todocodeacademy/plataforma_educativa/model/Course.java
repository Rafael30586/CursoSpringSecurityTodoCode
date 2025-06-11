package com.todocodeacademy.plataforma_educativa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="courses")
public class Course {
    private Long id;
    private String name;
    @ManyToOne
    private Professor professor;
    @ManyToMany
    private Set<Student> studentList = new HashSet<>();
}
