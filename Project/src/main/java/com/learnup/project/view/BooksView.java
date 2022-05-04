package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksView {
    
    private Long id, numberOfPages, price;
    
    private String title;
    
    private AuthorsView author;
    
    private LocalDate yearOfPublication;
    
    private BookWarehouseView bookWarehouse;
    
}
