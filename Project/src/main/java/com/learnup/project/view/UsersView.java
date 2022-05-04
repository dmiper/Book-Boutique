package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersView {
    
    private Long id;
    
    private RoleView role;
    
    private String loginName, email, hashPassword;
    
    private BuyersView buyer;
    
}
