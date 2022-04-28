package com.learnup.project.controller;

import com.learnup.project.dao.entity.Role;
import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.RoleFilter;
import com.learnup.project.service.RoleService;
import com.learnup.project.view.RoleView;
import com.learnup.project.view.mapper.RoleViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/role")
public class RoleController {
    
    private final RoleService roleService;
    
    private final RoleViewMapper roleViewMapper;
    
    @GetMapping
    public Set<RoleView> getRole(
            @RequestParam(value = "role", required = false) String role,
            @RequestParam(value = "users", required = false) Set<Users> users
    ) {
        return roleService.getAllRole(new RoleFilter(role, users))
                .stream()
                .map(roleViewMapper::mapUsersRoleToView)
                .collect(Collectors.toSet());
    }
    
    @GetMapping("/{id}")
    public RoleView getRoleById(@PathVariable("id") Long id) {
        return roleViewMapper.mapUsersRoleToView(roleService.getRoleById(id));
    }
    
    @PostMapping
    public RoleView createRole(@RequestBody RoleView roleView) {
        if (roleView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Role with id = %s already exist", roleView.getId())
            );
        }
        Role role = roleViewMapper.mapUsersRoleFromView(roleView);
        Role createRole = roleService.createRole(role);
        return roleViewMapper.mapUsersRoleToView(createRole);
    }
    
    @PutMapping("/{id}")
    public RoleView updateRole(@PathVariable("id") Long id,
                                   @RequestBody RoleView roleView) {
        if (roleView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, roleView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Role role = roleService.getRoleById(id);
        if (!role.getRole().equals(roleView.getRole())) {
            role.setRole(roleView.getRole());
        }
        Role updateRole = roleService.updateRole(role);
        return roleViewMapper.mapUsersRoleToView(updateRole);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteUserRole(@PathVariable("id") Long id) {
        return roleService.deleteRole(id);
    }
    
}
