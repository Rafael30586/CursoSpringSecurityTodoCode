package com.todocodeacademy.logiscode2.repository;

import com.todocodeacademy.logiscode2.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje, Long> {
}
