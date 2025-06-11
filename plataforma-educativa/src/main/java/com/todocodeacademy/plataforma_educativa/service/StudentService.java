package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Role;
import com.todocodeacademy.plataforma_educativa.model.Student;
import com.todocodeacademy.plataforma_educativa.model.UserSec;
import com.todocodeacademy.plataforma_educativa.repository.IStudentRepository;
import com.todocodeacademy.plataforma_educativa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
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
