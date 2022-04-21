package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookWarehouseFilter {
    
    private final Books book;
    
    private final Long theRestOfTheBooks;
    
    private final Long version;
}
