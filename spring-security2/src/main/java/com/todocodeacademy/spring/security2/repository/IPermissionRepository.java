package com.todocodeacademy.spring.security2.repository;

import com.todocodeacademy.spring.security2.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {
}
