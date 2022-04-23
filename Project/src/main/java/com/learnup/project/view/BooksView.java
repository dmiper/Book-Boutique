package com.learnup.project.view;

import com.learnup.project.dao.entity.Authors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksView {
    
    private Long id;
    
    private String title;
    
    private List<AuthorsNoBookView> author;
    
    private LocalDate yearOfPublication;
    
    private Long numberOfPages;
    
    private Long price;
    
}
