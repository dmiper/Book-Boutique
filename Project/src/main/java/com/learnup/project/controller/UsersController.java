package com.learnup.project.controller;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.dao.filter.UsersFilter;
import com.learnup.project.service.UsersService;
import com.learnup.project.view.UsersView;
import com.learnup.project.view.mapper.UsersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/users")
public class UsersController {
    
    private final UsersService usersService;
    
    private final UsersViewMapper usersViewMapper;
    
    @GetMapping
    public List<UsersView> getUsers(
            @RequestParam(value = "role", required = false) UsersRole role,
            @RequestParam(value = "loginName", required = false) String loginName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "hashPassword", required = false) String hashPassword,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "dateRegistration", required = false) LocalDate dateRegistration
    ) {
        return usersService.getAllUsers(new UsersFilter(role, loginName, email, hashPassword, firstName, lastName, dateRegistration))
                .stream()
                .map(usersViewMapper::mapUsersToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public UsersView getUser(@PathVariable("id") Long id) {
        return usersViewMapper.mapUsersToView(usersService.getUserById(id));
    }
    
    @PostMapping
    public UsersView createUser(@RequestBody UsersView usersView) {
        if (usersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("User with id = %s already exist", usersView.getId())
            );
        }
        Users users = usersViewMapper.mapUsersFromView(usersView);
        Users createUsers = usersService.createUser(users);
        return usersViewMapper.mapUsersToView(createUsers);
    }
    
    @PutMapping("/{id}")
    public UsersView updateAuthor(@PathVariable("id") Long id,
                                  @RequestBody UsersView authorsView) {
        if (authorsView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, authorsView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Users users = usersService.getUserById(id);
        if (!users.getDateRegistration().equals(authorsView.getDateRegistration())) {
            users.setDateRegistration(authorsView.getDateRegistration());
        }
        if (!users.getEmail().equals(authorsView.getEmail())) {
            users.setEmail(authorsView.getEmail());
        }
        if (!users.getLoginName().equals(authorsView.getLoginName())) {
            users.setLoginName(authorsView.getLoginName());
        }
        if (!users.getLastName().equals(authorsView.getLastName())) {
            users.setLastName(authorsView.getLastName());
        }
        if (!users.getFirstName().equals(authorsView.getFirstName())) {
            users.setFirstName(authorsView.getFirstName());
        }
        if (!users.getHashPassword().equals(authorsView.getHashPassword())) {
            users.setHashPassword(authorsView.getHashPassword());
        }
        if (!users.getRole().equals(authorsView.getRole())) {
            users.setRole(authorsView.getRole());
        }
        Users updateUser = usersService.updateUser(users);
        return usersViewMapper.mapUsersToView(updateUser);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteAuthor(@PathVariable("id") Long id) {
        return usersService.deleteUser(id);
    }
    
}
