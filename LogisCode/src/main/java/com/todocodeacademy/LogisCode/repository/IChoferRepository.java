package com.todocodeacademy.LogisCode.repository;

import com.todocodeacademy.LogisCode.model.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChoferRepository extends JpaRepository<Chofer, Long> {
}
