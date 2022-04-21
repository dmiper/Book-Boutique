package com.learnup.project.controller;

import com.learnup.project.mapper.BookWarehouseViewMapper;
import com.learnup.project.service.BookWarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-boutique/book-warehouse")
public class BookWarehouseController {

    private final BookWarehouseService bookWarehouseService;
    private final BookWarehouseViewMapper bookWarehouseViewMapper;

    public BookWarehouseController(BookWarehouseService bookWarehouseService, BookWarehouseViewMapper bookWarehouseViewMapper) {
        this.bookWarehouseService = bookWarehouseService;
        this.bookWarehouseViewMapper = bookWarehouseViewMapper;
    }
}
