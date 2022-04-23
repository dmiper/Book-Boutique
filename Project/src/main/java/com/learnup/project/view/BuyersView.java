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

    private String fullName;

    private LocalDate dateOfBirth;
    
    private List<OrdersNoBuyersView> ordersViews;

}
