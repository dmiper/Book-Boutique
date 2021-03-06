package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrdersFilter {
    
    private final Long purchaseAmount;
    
    private final Buyers buyer;
    
    private final List<OrderDetails> orderDetails;
    
}
