package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Authors;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BooksFilter {
    
    private final String title;
    
    private final Authors author;
    
    private final LocalDate yearOfPublication;
    
    private final Long numberOfPages;
    
    private final Long price;
}
