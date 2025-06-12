package com.todocodeacademy.plataforma_educativa.controller;

import com.todocodeacademy.plataforma_educativa.dto.NamesDTO;
import com.todocodeacademy.plataforma_educativa.dto.StudentDTO;
import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.model.Permission;
import com.todocodeacademy.plataforma_educativa.model.Student;
import com.todocodeacademy.plataforma_educativa.service.ICourseService;
import com.todocodeacademy.plataforma_educativa.service.IStudentService;
import com.todocodeacademy.plataforma_educativa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
@PreAuthorize("denyAll()")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICourseService courseService;

    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN','PROFESSOR')")
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(service.findAllDTOs());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STUDENT','ADMIN','PROFESSOR')")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findDTOById(id));
    }

    @PostMapping //Hay que encriptar el password
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> save(@RequestBody Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return ResponseEntity.ok(service.save(student));
    }

    @PatchMapping("/names/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> changeName(@PathVariable Long id,
                                              @RequestBody NamesDTO names){
        Student student = service.findById(id).get();
        student.setFirstName(names.getFirstName());
        student.setLastName(names.getLastName());

        service.update(student);
        return ResponseEntity.ok(student);
    }

    @PatchMapping("/remove-course/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> removeCourse(@PathVariable Long id,
                                                @RequestParam Long courseId){
        Student student = service.findById(id).get();
        List<Course> courseList = student.getCourseList();

        for(Course c : courseList){
            if(courseId==c.getId()) courseList.remove(c);
        }

        student.setCourseList(courseList);

        service.update(student);

        return ResponseEntity.ok(service.findById(id).get());
    }

    @PatchMapping("/add-course/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> addCourse(@PathVariable Long id,
                                             @RequestParam Long newCourseId){
        Student student = service.findById(id).get();
        List<Course> courseList = student.getCourseList();
        boolean isCourse = false; // Para indicar si el curso ya estaba dentro de la lista. Sólo agregar el nuevo curso si no estaba

        Course newCourse = courseService.findById(newCourseId).get();
        for(Course c : courseList){
            if(c.getName().equals(newCourse.getName())) isCourse = true;
        }

        courseList.add(newCourse);

        student.setCourseList(courseList);
        service.save(student);

        return ResponseEntity.ok(service.findById(id).get());
    }

    //monica weiss usuario: moni contraseña: 12345678

}
