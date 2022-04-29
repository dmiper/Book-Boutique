package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class BuyersFilter {
    
    private final Users user;
    
    private final LocalDate dateOfBirth, dateRegistration;
    
    private final List<Orders> orders;
    
    private final String firstName, lastName;
    
}
