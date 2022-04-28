package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersView {
    
    private Long id;
    
    private UsersFromBuyerView user;
    
    private LocalDate dateOfBirth, dateRegistration;
    
    private Set<OrdersFromBuyersView> orders;
    
    private String firstName, lastName;
    
}
