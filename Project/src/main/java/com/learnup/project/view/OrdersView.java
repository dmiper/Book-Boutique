package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersView {
    
    private Long id, purchaseAmount;
    
    private BuyersView buyer;
    
    private List<OrderDetailsView> orderDetails;
    
}
