package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Buyers;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class OrdersFilter {
    
    private final Long purchaseAmount;
    
    private final Collection<Buyers> buyer;
}
