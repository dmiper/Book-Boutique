package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersFromUserView {
    
    private Long id;
    
    private LocalDate dateOfBirth, dateRegistration;
    
    private String firstName, lastName;
    
}
