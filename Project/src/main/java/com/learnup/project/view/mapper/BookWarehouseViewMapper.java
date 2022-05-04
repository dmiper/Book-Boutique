package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.view.BookWarehouseView;
import org.springframework.stereotype.Component;

@Component
public class BookWarehouseViewMapper {
    
    public BookWarehouseView mapBookWarehouseToView(BookWarehouse bookWarehouse) {
        BookWarehouseView bookWarehouseView = new BookWarehouseView();
        bookWarehouseView.setId(bookWarehouse.getId());
        bookWarehouseView.setTheRestOfTheBooks(bookWarehouse.getTheRestOfTheBooks());
        return bookWarehouseView;
    }
    
    public BookWarehouse mapBookWarehouseFromView(BookWarehouseView bookWarehouseView) {
        BookWarehouse bookWarehouse = new BookWarehouse();
        bookWarehouse.setId(bookWarehouseView.getId());
        bookWarehouse.setTheRestOfTheBooks(bookWarehouseView.getTheRestOfTheBooks());
        return bookWarehouse;
    }
    
}
