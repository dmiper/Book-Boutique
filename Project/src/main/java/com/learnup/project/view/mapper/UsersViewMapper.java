package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.service.RoleService;
import com.learnup.project.view.BuyersFromUserView;
import com.learnup.project.view.RoleFromUserView;
import com.learnup.project.view.UsersView;
import org.springframework.stereotype.Component;

@Component
public class UsersViewMapper {
    
    public UsersView mapUsersToView(Users users) {
        UsersView usersView = new UsersView();
        usersView.setId(users.getId());
        usersView.setEmail(users.getEmail());
        usersView.setLoginName(users.getLoginName());
        usersView.setHashPassword(users.getHashPassword());
        usersView.setRole(
                new RoleFromUserView(
                        usersView.getRole().getId(),
                        usersView.getRole().getRole()
                )
        );
        usersView.setBuyer(
                new BuyersFromUserView(
                        usersView.getBuyer().getId(),
                        usersView.getBuyer().getDateOfBirth(),
                        usersView.getBuyer().getDateRegistration(),
                        usersView.getBuyer().getFirstName(),
                        usersView.getBuyer().getLastName()
                )
        );
        return usersView;
    }
    
    public Users mapUsersFromView(UsersView usersView, RoleService roleService) {
        Users users = new Users();
        users.setId(usersView.getId());
        users.setEmail(usersView.getEmail());
        users.setHashPassword(usersView.getHashPassword());
        users.setLoginName(usersView.getLoginName());
        users.setRole(roleService.getRoleByRole(usersView.getRole().getRole()));
        return users;
    }
    
}
