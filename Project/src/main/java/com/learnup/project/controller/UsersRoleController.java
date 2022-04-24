package com.learnup.project.controller;

import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.dao.filter.UsersRoleFilter;
import com.learnup.project.service.UsersRoleService;
import com.learnup.project.view.UsersRoleView;
import com.learnup.project.view.mapper.UsersRoleViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/users-role")
public class UsersRoleController {
    
    private final UsersRoleService usersRoleService;
    
    private final UsersRoleViewMapper usersRoleViewMapper;
    
    @GetMapping
    public List<UsersRoleView> getUsersRole(
            @RequestParam(value = "role", required = false) String role
    ) {
        return usersRoleService.getAllUsersRole(new UsersRoleFilter(role))
                .stream()
                .map(usersRoleViewMapper::mapUsersRoleToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public UsersRoleView getUserRole(@PathVariable("id") Long id) {
        return usersRoleViewMapper.mapUsersRoleToView(usersRoleService.getUserRoleById(id));
    }
    
    @PostMapping
    public UsersRoleView createUserRole(@RequestBody UsersRoleView usersRoleView) {
        if (usersRoleView.getId() != null) {
            throw new EntityExistsException(
                    String.format("UserRole with id = %s already exist", usersRoleView.getId())
            );
        }
        UsersRole usersRole = usersRoleViewMapper.mapUsersRoleFromView(usersRoleView);
        UsersRole createUsersRole = usersRoleService.createUserRole(usersRole);
        return usersRoleViewMapper.mapUsersRoleToView(createUsersRole);
    }
    
}
