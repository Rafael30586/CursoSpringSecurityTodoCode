package com.todocodeacademy.healthcare_solutions.repository;

import com.todocodeacademy.healthcare_solutions.model.RegistroMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistroMedicoRepository extends JpaRepository<RegistroMedico,Long> {
}
