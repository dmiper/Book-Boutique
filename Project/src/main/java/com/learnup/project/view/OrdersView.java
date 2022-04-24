package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersView {

    private Long id;
    
    private Collection<BuyersNoOrdersView> buyer;

    private Long purchaseAmount;
    
}
