package com.todocodeacademy.plataforma_educativa.service;

import com.todocodeacademy.plataforma_educativa.model.Permission;
import com.todocodeacademy.plataforma_educativa.model.Role;
import com.todocodeacademy.plataforma_educativa.repository.IPermissionRepository;
import com.todocodeacademy.plataforma_educativa.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role patch(Long roleId, Long permissionId, char accion) {
        if(accion=='a' || accion=='q'){
            Role roleToEdit = roleRepository.findById(roleId).get();
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
            roleRepository.save(roleToEdit);

            return roleRepository.findById(roleId).get();
        }



        return null;
    }
}
