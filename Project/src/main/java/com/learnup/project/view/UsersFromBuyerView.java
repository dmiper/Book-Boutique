package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersFromBuyerView {
    
    private Long id;
    
    private RoleFromUserView role;
    
    private String loginName;
    
}
