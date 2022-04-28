package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersView {
    
    private Long id, purchaseAmount;
    
    private BuyersFromOrdersView buyer;
    
    private OrderDetailsFromOrderView orderDetails;
    
}
