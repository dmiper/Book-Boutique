package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersView {
    
    private Long id;
    
    private UsersFromBuyerView user;
    
    private LocalDate dateOfBirth, dateRegistration;
    
    private List<OrdersFromBuyersView> orders;
    
    private String firstName, lastName;
    
}
