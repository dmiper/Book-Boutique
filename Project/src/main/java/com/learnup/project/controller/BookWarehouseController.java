package com.learnup.project.controller;

import com.learnup.project.view.mapper.BookWarehouseViewMapper;
import com.learnup.project.service.BookWarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/book-warehouse")
public class BookWarehouseController {

    private final BookWarehouseService bookWarehouseService;
    private final BookWarehouseViewMapper bookWarehouseViewMapper;

}
