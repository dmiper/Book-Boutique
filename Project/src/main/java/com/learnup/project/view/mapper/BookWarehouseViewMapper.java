package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.view.AuthorsNoBookView;
import com.learnup.project.view.BookWarehouseView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookWarehouseViewMapper {
    
    public BookWarehouseView mapBookWarehouseToView(BookWarehouse bookWarehouse) {
        BookWarehouseView bookWarehouseView = new BookWarehouseView();
        bookWarehouseView.setId(bookWarehouse.getId());
        bookWarehouseView.setTheRestOfTheBooks(bookWarehouse.getTheRestOfTheBooks());
        bookWarehouseView.setBook(
                new Books(
                        bookWarehouse.getBook().getId(),
                        bookWarehouse.getBook().getTitle(),
                        bookWarehouse.getBook().getAuthor()
                                .stream()
                                .map(authors -> new AuthorsNoBookView(
                                        authors.getId(),
                                        authors.getFullName()))
                                .collect(Collectors.toList()),
                        bookWarehouse.getBook().getYearOfPublication(),
                        bookWarehouse.getBook().getNumberOfPages(),
                        bookWarehouse.getBook().getPrice()
                ));
        return bookWarehouseView;
    }
    
    public BookWarehouse mapBookWarehouseFromView(BookWarehouseView bookWarehouseView) {
        BookWarehouse bookWarehouse = new BookWarehouse();
        bookWarehouse.setId(bookWarehouseView.getId());
        bookWarehouse.setTheRestOfTheBooks(bookWarehouseView.getTheRestOfTheBooks());
        bookWarehouse.setBook(new Books(bookWarehouse.getId()));
        return bookWarehouse;
    }
    
}
