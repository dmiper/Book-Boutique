package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.view.UsersView;
import org.springframework.stereotype.Component;

@Component
public class UsersViewMapper {
    
    public UsersView mapUsersToView(Users users) {
        UsersView usersView = new UsersView();
        usersView.setId(users.getId());
        usersView.setRole(users.getRole());
        usersView.setEmail(users.getEmail());
        usersView.setLastName(users.getLastName());
        usersView.setFirstName(users.getFirstName());
        usersView.setLoginName(users.getLoginName());
        usersView.setHashPassword(users.getHashPassword());
        usersView.setDateRegistration(users.getDateRegistration());
        
        return usersView;
    }
    
    public Users mapUsersFromView(UsersView usersView) {
        Users users = new Users();
        users.setId(usersView.getId());
        users.setRole(
                new UsersRole(
                        usersView.getRole().getId(),
                        usersView.getRole().getRole()));
        users.setEmail(usersView.getEmail());
        users.setLastName(usersView.getLastName());
        users.setLoginName(usersView.getLoginName());
        users.setFirstName(usersView.getFirstName());
        users.setHashPassword(usersView.getHashPassword());
        users.setDateRegistration(usersView.getDateRegistration());
        return users;
    }
    
}
