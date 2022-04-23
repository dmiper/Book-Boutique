package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.view.AuthorsNoBookView;
import com.learnup.project.view.BooksView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BooksViewMapper {
    
    public BooksView mapBooksToView(Books books) {
        BooksView booksView = new BooksView();
        booksView.setId(books.getId());
        booksView.setTitle(books.getTitle());
        if (books.getAuthor() != null) {
            booksView.setAuthor(
                    books.getAuthor()
                            .stream()
                            .map(authors -> new AuthorsNoBookView(
                                    authors.getId(),
                                    authors.getFullName()))
                            .collect(Collectors.toList())
            );
        }
        booksView.setYearOfPublication(books.getYearOfPublication());
        booksView.setNumberOfPages(books.getNumberOfPages());
        booksView.setPrice(books.getPrice());
        return booksView;
    }
    
    public Books mapBooksFromView(BooksView booksView) {
        Books books = new Books();
        books.setId(booksView.getId());
        books.setTitle(booksView.getTitle());
        if (booksView.getAuthor() != null) {
            books.setAuthor(
                    booksView.getAuthor()
                            .stream()
                            .map(authorsNoBookView -> new Authors(
                                    authorsNoBookView.getId(),
                                    authorsNoBookView.getFullName()))
                            .collect(Collectors.toList())
            );
        }
        books.setYearOfPublication(booksView.getYearOfPublication());
        books.setNumberOfPages(booksView.getNumberOfPages());
        books.setPrice(booksView.getPrice());
        return books;
    }
    
}
