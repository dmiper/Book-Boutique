package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailsFilter {
    
    private final Orders order;
    
    private final Books book;
    
    private final Long quantity, price;
}
