package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Users;
import com.learnup.project.service.RoleService;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.RoleView;
import com.learnup.project.view.UsersView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsersViewMapper {
    
    public UsersView mapUsersToView(Users users) {
        UsersView usersView = new UsersView();
        usersView.setId(users.getId());
        usersView.setEmail(users.getEmail());
        usersView.setLoginName(users.getLoginName());
        usersView.setHashPassword(users.getHashPassword());
        usersView.setRole(
                new RoleView(
                        users.getRole().getId(),
                        users.getRole().getRole()));
        usersView.setBuyer(
                new BuyersView(
                        users.getBuyer().getId(),
                        users.getBuyer().getDateOfBirth(),
                        users.getBuyer().getDateRegistration(),
                        users.getBuyer().getFirstName(),
                        users.getBuyer().getLastName()));
        return usersView;
    }
    
    public Users mapUsersFromView(UsersView usersView, RoleService roleService) {
        Users users = new Users();
        users.setId(usersView.getId());
        users.setEmail(usersView.getEmail());
        users.setHashPassword(usersView.getHashPassword());
        users.setLoginName(usersView.getLoginName());
        if (usersView.getRole() != null) {
            users.setRole(roleService.getRoleByRole(usersView.getRole().getRole()));
        }
        if (usersView.getBuyer() != null) {
            users.setBuyer(
                    new Buyers(
                            usersView.getBuyer().getId(),
                            usersView.getBuyer().getDateOfBirth(),
                            usersView.getBuyer().getDateRegistration(),
                            usersView.getBuyer().getFirstName(),
                            usersView.getBuyer().getLastName()));
        }
        return users;
    }
    
}
