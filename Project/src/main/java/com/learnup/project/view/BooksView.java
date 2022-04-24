package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksView {
    
    private Long id;
    
    private String title;
    
    private Collection<AuthorsNoBookView> author;
    
    private LocalDate yearOfPublication;
    
    private Long numberOfPages;
    
    private Long price;
    
}
