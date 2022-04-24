package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.view.UsersRoleView;
import org.springframework.stereotype.Component;

@Component
public class UsersRoleViewMapper {
    
    public UsersRoleView mapUsersRoleToView(UsersRole usersRole) {
        UsersRoleView usersRoleView = new UsersRoleView();
        usersRoleView.setId(usersRole.getId());
        usersRoleView.setRole(usersRole.getRole());
        return usersRoleView;
    }
    
    public UsersRole mapUsersRoleFromView(UsersRoleView usersRoleView) {
        UsersRole usersRole = new UsersRole();
        usersRole.setId(usersRoleView.getId());
        usersRole.setRole(usersRoleView.getRole());
        return usersRole;
    }
    
}
