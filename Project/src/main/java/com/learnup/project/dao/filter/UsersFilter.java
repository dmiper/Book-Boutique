package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.UsersRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UsersFilter {
    
    private UsersRole role;
    
    private String loginName;
    
    private String email;
    
    private String hashPassword;
    
    private String firstName;
    
    private String lastName;
    
    private LocalDate dateRegistration;
}
