package com.learnup.project.dao.filter;

import com.learnup.project.dao.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthorsFilter {
    
    private final String fullName;
    
    private final Set<Books> book;
    
}
