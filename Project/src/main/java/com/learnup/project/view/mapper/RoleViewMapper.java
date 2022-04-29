package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Role;
import com.learnup.project.view.RoleView;
import com.learnup.project.view.UsersFromRoleView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoleViewMapper {
    
    public RoleView mapUsersRoleToView(Role role) {
        RoleView roleView = new RoleView();
        roleView.setId(role.getId());
        roleView.setRole(role.getRole());
        if (role.getUsers() != null) {
            roleView.setUsers(
                    role.getUsers()
                            .stream()
                            .map(users -> new UsersFromRoleView(
                                    users.getId(),
                                    users.getLoginName()
                            ))
                            .collect(Collectors.toList()));
        }
        return roleView;
    }
    
    public Role mapUsersRoleFromView(RoleView roleView) {
        Role role = new Role();
        role.setId(roleView.getId());
        role.setRole(roleView.getRole());
        return role;
    }
    
}
