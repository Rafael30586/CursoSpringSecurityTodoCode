package com.todocodeacademy.plataforma_educativa.controller;

import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("denyAll()")
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN','PROFESSOR')")
    public ResponseEntity<Optional<Course>> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN','PROFESSOR')")
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Course> save(@RequestBody Course course){
        return ResponseEntity.ok(service.save(course));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Course> changeName(@PathVariable Long id,
                                             @RequestParam String newName){
        Course course = service.findById(id).get();
        course.setName(newName);
        service.update(course);

        return ResponseEntity.ok(course);
    }
}
