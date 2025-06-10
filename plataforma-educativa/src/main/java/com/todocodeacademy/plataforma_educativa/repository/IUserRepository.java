package com.todocodeacademy.plataforma_educativa.repository;

import com.todocodeacademy.plataforma_educativa.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserSec,Long> {
}
