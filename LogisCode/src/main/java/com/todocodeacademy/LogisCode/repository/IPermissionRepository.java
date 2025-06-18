package com.todocodeacademy.LogisCode.repository;

import com.todocodeacademy.LogisCode.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {

    Optional<Permission> findByPermissionName(String permissionName);
}
