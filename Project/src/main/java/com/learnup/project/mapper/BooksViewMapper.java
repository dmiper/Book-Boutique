package com.learnup.project.mapper;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.view.BooksView;
import org.springframework.stereotype.Component;

@Component
public class BooksViewMapper {
    
    public BooksView mapBooksToView(Books books) {
        BooksView booksView = new BooksView();
        booksView.setId(books.getId());
        booksView.setTitle(books.getTitle());
        booksView.setAuthor(books.getAuthor());
        booksView.setYearOfPublication(books.getYearOfPublication());
        booksView.setNumberOfPages(books.getNumberOfPages());
        booksView.setPrice(books.getPrice());
        return booksView;
    }
    
    public Books mapBooksFromView(BooksView booksView) {
        Books books = new Books();
        books.setId(booksView.getId());
        books.setTitle(booksView.getTitle());
        books.setAuthor(booksView.getAuthor());
        books.setYearOfPublication(booksView.getYearOfPublication());
        books.setNumberOfPages(booksView.getNumberOfPages());
        books.setPrice(booksView.getPrice());
        return books;
    }
    
}
