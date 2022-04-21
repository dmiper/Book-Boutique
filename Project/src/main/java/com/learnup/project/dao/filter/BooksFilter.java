package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Authors;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BooksFilter {
    
    private String title;
    
    private Authors author;
    
    private LocalDate yearOfPublication;
    
    private Long numberOfPages;
    
    private Long price;
}
