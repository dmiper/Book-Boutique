package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookWarehouseView {
    
    private Long id, theRestOfTheBooks;
    
    private BooksFromBookWarehouseView book;
    
}
