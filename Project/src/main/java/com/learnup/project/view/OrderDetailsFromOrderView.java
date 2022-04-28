package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsFromOrderView {
    
    private Long id, quantity, price;
    
    private BooksView book;
    
}
