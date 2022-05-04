package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Role;
import com.learnup.project.view.RoleView;
import org.springframework.stereotype.Component;

@Component
public class RoleViewMapper {
    
    public RoleView mapUsersRoleToView(Role role) {
        RoleView roleView = new RoleView();
        roleView.setId(role.getId());
        roleView.setRole(role.getRole());
        return roleView;
    }
    
    public Role mapUsersRoleFromView(RoleView roleView) {
        Role role = new Role();
        role.setId(roleView.getId());
        role.setRole(roleView.getRole());
        return role;
    }
    
}
