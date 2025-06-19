package com.todocodeacademy.logiscode2.repository;

import com.todocodeacademy.logiscode2.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
