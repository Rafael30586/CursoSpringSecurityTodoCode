package com.todocodeacademy.LogisCode.controller;

import com.todocodeacademy.LogisCode.model.Permission;
import com.todocodeacademy.LogisCode.model.Role;
import com.todocodeacademy.LogisCode.service.IPermissionService;
import com.todocodeacademy.LogisCode.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
@PreAuthorize("denyAll()")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Role>> getAllRoles() {
        List roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity createRole(@RequestBody Role role) {
        Set<Permission> permissionList = new HashSet<>();
        Permission readPermission;

        // Recuperar la Permission/s por su ID
        for (Permission per : role.getPermissionList()) {
            readPermission = permissionService.findById(per.getId()).orElse(null);
            if (readPermission != null) {
                //si encuentro, guardo en la lista
                permissionList.add(readPermission);
            }
        }

        role.setPermissionList(permissionList);
        Role newRole = roleService.save(role);
        return ResponseEntity.ok(newRole);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/{roleId}")
    @PreAuthorize("permitAll()")
    public Role patchRole(@PathVariable Long roleId,
                          @RequestParam("permission-id") Long permissionId,
                          @RequestParam char accion){
        return roleService.patch(roleId,permissionId,accion);
    }
}
