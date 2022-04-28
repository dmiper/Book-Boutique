package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.AuthorsFromBookView;
import com.learnup.project.view.BookWarehouseView;
import com.learnup.project.view.BooksFromBookWarehouseView;
import org.springframework.stereotype.Component;

@Component
public class BookWarehouseViewMapper {
    
    public BookWarehouseView mapBookWarehouseToView(BookWarehouse bookWarehouse) {
        BookWarehouseView bookWarehouseView = new BookWarehouseView();
        bookWarehouseView.setId(bookWarehouse.getId());
        bookWarehouseView.setTheRestOfTheBooks(bookWarehouse.getTheRestOfTheBooks());
        bookWarehouseView.setBook(
                new BooksFromBookWarehouseView(
                        bookWarehouse.getBook().getId(),
                        bookWarehouse.getBook().getTitle(),
                        new AuthorsFromBookView(
                                bookWarehouse.getBook().getAuthor().getId(),
                                bookWarehouse.getBook().getAuthor().getFullName()
                        ),
                        bookWarehouse.getBook().getYearOfPublication(),
                        bookWarehouse.getBook().getNumberOfPages(),
                        bookWarehouse.getBook().getPrice()
                )
        );
        return bookWarehouseView;
    }
    
    public BookWarehouse mapBookWarehouseFromView(BookWarehouseView bookWarehouseView, BooksService booksService) {
        BookWarehouse bookWarehouse = new BookWarehouse();
        bookWarehouse.setId(bookWarehouseView.getId());
        bookWarehouse.setTheRestOfTheBooks(bookWarehouseView.getTheRestOfTheBooks());
        bookWarehouse.setBook(booksService.getBookByTitle(bookWarehouseView.getBook().getTitle()));
        return bookWarehouse;
    }
    
}
