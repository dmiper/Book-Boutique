package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Buyers;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdersFilter {
    
    private final Long purchaseAmount;
    
    private final Buyers buyer;
}
