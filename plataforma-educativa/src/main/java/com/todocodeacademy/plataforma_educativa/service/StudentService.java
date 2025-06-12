package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.dto.StudentDTO;
import com.todocodeacademy.plataforma_educativa.model.Role;
import com.todocodeacademy.plataforma_educativa.model.Student;
import com.todocodeacademy.plataforma_educativa.model.UserSec;
import com.todocodeacademy.plataforma_educativa.repository.IStudentRepository;
import com.todocodeacademy.plataforma_educativa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentRepository repository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<StudentDTO> findAllDTOs() {
        List<Student> studentList = repository.findAll();
        List<StudentDTO> dtoList = new ArrayList<>();
        StudentDTO dto;

        for(Student s : studentList){
            dto = new StudentDTO();
            dto.setId(s.getId());
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setCourseList(s.getCourseList());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public StudentDTO findDTOById(Long id) {
        Optional<Student> optional = repository.findById(id);
        StudentDTO dto = new StudentDTO();

        if(optional.isPresent()){
            dto.setId(optional.get().getId());
            dto.setFirstName(optional.get().getFirstName());
            dto.setLastName(optional.get().getLastName());
            dto.setCourseList(optional.get().getCourseList());
        }
        return dto;
    }

    @Override
    public Student save(Student student) {
        Role role = new Role();
        role.setRole("STUDENT");
        Set<Role> roleList = new HashSet<>();
        roleList.add(role);

        UserSec userSec = new UserSec();
        userSec.setPassword(student.getPassword());
        userSec.setUsername(student.getUsername());
        userSec.setRoleList(roleList);
        userSec.setCredentialNotExpired(true);
        userSec.setAccountNotExpired(true);
        userSec.setAccountNotLocked(true);
        userSec.setEnabled(true);

        userRepository.save(userSec);
        return repository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }
}
