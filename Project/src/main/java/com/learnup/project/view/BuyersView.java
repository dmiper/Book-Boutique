package com.learnup.project.view;

import com.learnup.project.dao.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersView {

    private Long id;
    
    private Users user;

    private LocalDate dateOfBirth;
    
    private Collection<OrdersNoBuyersView> orders;

}
