package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.BooksNoAuthorView;
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
                            .map(books -> new BooksNoAuthorView(
                                    books.getId(),
                                    books.getTitle(),
                                    books.getYearOfPublication(),
                                    books.getNumberOfPages(),
                                    books.getPrice()))
                            .collect(Collectors.toList()));
        }
        return authorsView;
    }
    
    public Authors mapAuthorsFromView(AuthorsView authorsView) {
        Authors authors = new Authors();
        authors.setId(authorsView.getId());
        authors.setFullName(authorsView.getFullName());
        if (authorsView.getBooks() != null) {
            authors.setBook(
                    authorsView.getBooks()
                            .stream()
                            .map(booksNoAuthorView -> new Books(
                                    booksNoAuthorView.getId(),
                                    booksNoAuthorView.getTitle(),
                                    booksNoAuthorView.getYearOfPublication(),
                                    booksNoAuthorView.getNumberOfPages(),
                                    booksNoAuthorView.getPrice()))
                            .collect(Collectors.toList()));
        }
        return authors;
    }
    
}
