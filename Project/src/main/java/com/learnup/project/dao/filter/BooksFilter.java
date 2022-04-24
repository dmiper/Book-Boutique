package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Authors;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
public class BooksFilter {
    
    private final String title;
    
    private final Collection<Authors> author;
    
    private final LocalDate yearOfPublication;
    
    private final Long numberOfPages;
    
    private final Long price;
}
