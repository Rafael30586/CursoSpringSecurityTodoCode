package com.todocodeacademy.plataforma_educativa.controller;

import com.todocodeacademy.plataforma_educativa.dto.NamesDTO;
import com.todocodeacademy.plataforma_educativa.dto.ProfessorDTO;
import com.todocodeacademy.plataforma_educativa.model.Course;
import com.todocodeacademy.plataforma_educativa.model.Professor;
import com.todocodeacademy.plataforma_educativa.model.Student;
import com.todocodeacademy.plataforma_educativa.service.ICourseService;
import com.todocodeacademy.plataforma_educativa.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/professors")
@PreAuthorize("denyAll()")
public class ProfessorController {
    
    @Autowired
    private IProfessorService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICourseService courseService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','PROFESSOR')")
    public ResponseEntity<List<ProfessorDTO>> findAll(){
        return ResponseEntity.ok(service.findAll2());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESSOR')") // Modificar este metodo
    public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id){
        ProfessorDTO professorDTO = service.findById2(id);
        return ResponseEntity.ok(professorDTO);
    }

    @PostMapping //Hay que encriptar el password
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Professor> save(@RequestBody Professor professor){
        professor.setPassword(passwordEncoder.encode(professor.getPassword()));
        return ResponseEntity.ok(service.save(professor));
    }

    @PatchMapping("/names/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Professor> changeName(@PathVariable Long id,
                                              @RequestBody NamesDTO names){
        Professor professor = service.findById(id).get();
        professor.setFirstName(names.getFirstName());
        professor.setLastName(names.getLastName());

        service.update(professor);
        return ResponseEntity.ok(professor);
    }

    @PatchMapping("/remove-course/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Professor> removeCourse(@PathVariable Long id,
                                                @RequestParam("course-id") Long courseId){
        Professor professor = service.findById(id).get();
        List<Course> courseList = professor.getCourseList();
        boolean isCourse = false;
        Course courseToRemove = new Course();

        for(Course c : courseList){
            if(courseId==c.getId()) {
                isCourse = true;
                courseToRemove = c;
            }
        }

        if(isCourse){
            courseList.remove(courseToRemove);
        }

        professor.setCourseList(courseList);

        service.update(professor);

        return ResponseEntity.ok(service.findById(id).get());
    }

    @PatchMapping("/add-course/{id}")
    @PreAuthorize("hasRole('ADMIN')") //arreglar este metodo, da un problema con sql
    public ResponseEntity<Professor> addCourse(@PathVariable Long id,
                                             @RequestParam("new-course-id") Long newCourseId){
        Professor professor = service.findById(id).get();
        List<Course> courseList = professor.getCourseList();
        boolean isCourse = false; // Para indicar si el curso ya estaba dentro de la lista. Sólo agregar el nuevo curso si no estaba

        Course newCourse = courseService.findById(newCourseId).get();
        for(Course c : courseList){
            if(c.getName().equals(newCourse.getName())) isCourse = true;
        }

        if(!isCourse){
            courseList.add(newCourse);
            professor.setCourseList(courseList);
            service.update(professor);
        }


        return ResponseEntity.ok(service.findById(id).get());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
    //Alejandro Gimenez usuario: alegimenez contraseña: 5678
    //Maria Elsa Rodriguez usaurio: marirodriguez contraseña: 5678
}
