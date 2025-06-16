package com.todocodeacademy.plataforma_educativa.controller;

import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.model.Professor;
import com.todocodeacademy.plataforma_educativa.service.ICourseService;
import com.todocodeacademy.plataforma_educativa.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("denyAll()")
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService service;
    @Autowired
    private IProfessorService professorService;

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

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_PROFESSOR')") //Revisar este método
    public Course update(@RequestParam("course-id") Long courseId,
                         @RequestBody Course courseNewName){
        String professorUsername = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Professor> professorsList = professorService.findAll();
        Course courseToEdit = new Course();
        List<Course> professorCourses = new ArrayList<>();
        Professor professorToEdit = professorService.findByUsername(professorUsername).get();

        for(Professor p : professorsList){
            if(p.getUsername().equals(professorUsername)){
                professorCourses = p.getCourseList();
            }
        }

        if(service.findById(courseId).isPresent()){
            for(Course c : professorCourses){
                if(c.getId()==courseId){
                    courseToEdit = service.findById(courseId).get();
                    courseToEdit.setName(courseNewName.getName());
                    service.update(courseToEdit);
                    //professorCourses.add(courseToEdit);
                    //professorToEdit.setCourseList(professorCourses);
                    //professorService.update(professorToEdit);
                }
            }
        }

        return courseToEdit;
    }
}
