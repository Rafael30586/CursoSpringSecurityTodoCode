package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Professor;
import com.todocodeacademy.plataforma_educativa.model.Role;
import com.todocodeacademy.plataforma_educativa.model.UserSec;
import com.todocodeacademy.plataforma_educativa.repository.IProfessorRepository;
import com.todocodeacademy.plataforma_educativa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfessorService implements IProfessorService{

    @Autowired
    private IProfessorRepository repository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<Professor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Professor save(Professor professor) {
        Set<Role> roleList = new HashSet<>();
        Role role = new Role();
        role.setRole("PROFESSOR");
        roleList.add(role);

        UserSec userSec = new UserSec();
        userSec.setEnabled(true);
        userSec.setAccountNotExpired(true);
        userSec.setAccountNotLocked(true);
        userSec.setCredentialNotExpired(true);
        userSec.setRoleList(roleList);
        userSec.setUsername(professor.getUsername());
        userSec.setPassword(professor.getPassword());

        userRepository.save(userSec);

        return repository.save(professor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Professor update(Professor professor) {
        return repository.save(professor);
    }
}
