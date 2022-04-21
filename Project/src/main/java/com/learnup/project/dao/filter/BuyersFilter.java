package com.learnup.project.dao.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BuyersFilter {
    
    private final String fullName;
    
    private final LocalDate dateOfBirth;
}
