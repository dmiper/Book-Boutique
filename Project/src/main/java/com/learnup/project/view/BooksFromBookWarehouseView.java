package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksFromBookWarehouseView {
    
    private Long id, numberOfPages, price;
    
    private String title;
    
    private AuthorsFromBookView author;
    
    private LocalDate yearOfPublication;
    
    public BooksFromBookWarehouseView(Long id, String title, AuthorsFromBookView author, LocalDate yearOfPublication, Long numberOfPages, Long price) {
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
