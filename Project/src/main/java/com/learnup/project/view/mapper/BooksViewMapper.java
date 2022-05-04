package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.service.AuthorsService;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.BookWarehouseView;
import com.learnup.project.view.BooksView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
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
                new AuthorsView(
                        books.getAuthor().getId(),
                        books.getAuthor().getFullName()
                ));
        booksView.setBookWarehouse(
                new BookWarehouseView(
                        books.getBookWarehouse().getId(),
                        books.getBookWarehouse().getTheRestOfTheBooks()
                )
        );
        return booksView;
    }
    
    public Books mapBooksFromView(BooksView booksView, AuthorsService authorsService) {
        Books books = new Books();
        books.setId(booksView.getId());
        books.setTitle(booksView.getTitle());
        books.setPrice(booksView.getPrice());
        books.setNumberOfPages(booksView.getNumberOfPages());
        books.setYearOfPublication(booksView.getYearOfPublication());
        books.setAuthor(authorsService.getAuthorByFullName(booksView.getAuthor().getFullName()));
        books.setBookWarehouse(
                new BookWarehouse(
                        booksView.getBookWarehouse().getId(),
                        booksView.getBookWarehouse().getTheRestOfTheBooks()
                ));
        return books;
    }
    
}
