package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoleFilter {
    
    private final String role;
    
    private final List<Users> users;
    
}
