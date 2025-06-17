package com.todocodeacademy.LogisCode.repository;

import com.todocodeacademy.LogisCode.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje,Long> {
}
