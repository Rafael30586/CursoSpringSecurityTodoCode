package com.todocodeacademy.logiscode2.repository;

import com.todocodeacademy.logiscode2.model.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChoferRepository extends JpaRepository<Chofer, Long> {
}
