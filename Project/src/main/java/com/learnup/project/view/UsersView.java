package com.learnup.project.view;

import com.learnup.project.dao.entity.UsersRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersView {
    
    private Long id;
    
    private UsersRole role;
    
    private String loginName;
    
    private String email;
    
    private String hashPassword;
    
    private String firstName;
    
    private String lastName;
    
    private LocalDate dateRegistration;
    
}
