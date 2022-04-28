package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.BooksFromAuthorView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorsViewMapper {
    
    public AuthorsView mapAuthorsToView(Authors authors) {
        AuthorsView authorsView = new AuthorsView();
        authorsView.setId(authors.getId());
        authorsView.setFullName(authors.getFullName());
        if (authors.getBook() != null) {
            authorsView.setBooks(
                    authors.getBook()
                            .stream()
                            .map(books -> new BooksFromAuthorView(
                                    books.getId(),
                                    books.getTitle(),
                                    books.getYearOfPublication(),
                                    books.getNumberOfPages(),
                                    books.getPrice()))
                            .collect(Collectors.toSet()));
        }
        return authorsView;
    }
    
    public Authors mapAuthorsFromView(AuthorsView authorsView) {
        Authors authors = new Authors();
        authors.setId(authorsView.getId());
        authors.setFullName(authorsView.getFullName());
        return authors;
    }
    
}
