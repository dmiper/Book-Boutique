package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorsView {

    private Long id;

    private String fullName;
    
    private List<BooksNoAuthorView> booksView;
    
}
