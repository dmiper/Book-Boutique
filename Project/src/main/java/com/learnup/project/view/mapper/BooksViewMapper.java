package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.view.AuthorsFromBookView;
import com.learnup.project.view.BookWarehouseFromBookView;
import com.learnup.project.view.BooksView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksViewMapper {
    
    public BooksView mapBooksToView(Books books) {
        BooksView booksView = new BooksView();
        booksView.setId(books.getId());
        booksView.setTitle(books.getTitle());
        booksView.setPrice(books.getPrice());
        booksView.setNumberOfPages(books.getNumberOfPages());
        booksView.setYearOfPublication(books.getYearOfPublication());
        booksView.setAuthor(
                new AuthorsFromBookView(
                        books.getAuthor().getId(),
                        books.getAuthor().getFullName()
                ));
        booksView.setBookWarehouse(
                new BookWarehouseFromBookView(
                        books.getBookWarehouse().getId(),
                        books.getBookWarehouse().getTheRestOfTheBooks()
                )
        );
        return booksView;
    }
    
    public Books mapBooksFromView(BooksView booksView) {
        Books books = new Books();
        books.setId(booksView.getId());
        books.setTitle(booksView.getTitle());
        books.setPrice(booksView.getPrice());
        books.setNumberOfPages(booksView.getNumberOfPages());
        books.setYearOfPublication(booksView.getYearOfPublication());
        List<Books> booksList = new ArrayList<>();
        booksList.add(books);
        books.setAuthor(
                new Authors(
                        booksView.getAuthor().getId(),
                        booksView.getAuthor().getFullName(),
                        booksList));
        books.setBookWarehouse(
                new BookWarehouse(
                        booksView.getBookWarehouse().getId(),
                        books,
                        booksView.getBookWarehouse().getTheRestOfTheBooks()
                ));
        return books;
    }
    
}
