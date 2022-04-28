package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleView {
    
    private Long id;
    
    private String role;
    
    private Set<UsersFromRoleView> users;

}
