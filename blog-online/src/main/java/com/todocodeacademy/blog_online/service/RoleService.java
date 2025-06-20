package com.todocodeacademy.blog_online.service;

import com.todocodeacademy.blog_online.model.Permission;
import com.todocodeacademy.blog_online.model.Role;
import com.todocodeacademy.blog_online.repository.IPermissionRepository;
import com.todocodeacademy.blog_online.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository repository;
    @Autowired
    private IPermissionRepository permissionRepository;
    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role update(Role role) {
        return repository.save(role);
    }

    @Override
    public Role patch(Long roleId, Long permissionId, char accion) {
        if(accion=='a' || accion=='q'){

            Role roleToEdit = repository.findById(roleId).get();
            Set<Permission> permissionList = roleToEdit.getPermissionList();

            if(accion=='a'){
                Permission permission = permissionRepository.findById(permissionId).get();
                permissionList.add(permission);
            }else{
                for(Permission p : permissionList){
                    if(p.getId()==roleId) permissionList.remove(p);
                }
            }
            roleToEdit.setPermissionList(permissionList);
            repository.save(roleToEdit);

            return repository.findById(roleId).get();
        }

        return null;
    }

    @Override
    public Optional<Role> findByRole(String role) {
        return repository.findByRole(role);
    }

}
