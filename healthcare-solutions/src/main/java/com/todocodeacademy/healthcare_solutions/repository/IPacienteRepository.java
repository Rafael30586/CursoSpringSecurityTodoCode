package com.todocodeacademy.healthcare_solutions.repository;

import com.todocodeacademy.healthcare_solutions.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
}
