package com.learnup.project.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.view.BookWarehouseView;
import org.springframework.stereotype.Component;

@Component
public class BookWarehouseViewMapper {
    
    public BookWarehouseView mapBookWarehouseToView(BookWarehouse bookWarehouse) {
        BookWarehouseView bookWarehouseView = new BookWarehouseView();
        bookWarehouseView.setId(bookWarehouse.getId());
        bookWarehouseView.setBook(bookWarehouse.getBook());
        bookWarehouseView.setTheRestOfTheBooks(bookWarehouse.getTheRestOfTheBooks());
        bookWarehouseView.setVersion(bookWarehouse.getVersion());
        return bookWarehouseView;
    }
    
    public BookWarehouse mapBookWarehouseFromView(BookWarehouseView bookWarehouseView) {
        BookWarehouse bookWarehouse = new BookWarehouse();
        bookWarehouse.setId(bookWarehouseView.getId());
        bookWarehouse.setBook(bookWarehouseView.getBook());
        bookWarehouse.setTheRestOfTheBooks(bookWarehouse.getTheRestOfTheBooks());
        bookWarehouse.setVersion(bookWarehouse.getVersion());
        return bookWarehouse;
    }
    
}
