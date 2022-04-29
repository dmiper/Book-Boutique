package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersFilter {
    
    private final Role role;
    
    private final String loginName, email, hashPassword;
    
    private final Buyers buyer;
    
}
