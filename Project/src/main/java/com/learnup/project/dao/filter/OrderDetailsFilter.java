package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailsFilter {
    
    private Orders order;
    
    private Books book;
    
    private Long quantity;
    
    private Long price;
}
