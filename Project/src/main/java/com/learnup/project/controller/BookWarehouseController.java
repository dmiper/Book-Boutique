package com.learnup.project.controller;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import com.learnup.project.service.BookWarehouseService;
import com.learnup.project.view.BookWarehouseView;
import com.learnup.project.view.mapper.BookWarehouseViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/book-warehouse")
public class BookWarehouseController {
    
    private final BookWarehouseService bookWarehouseService;
    private final BookWarehouseViewMapper bookWarehouseViewMapper;
    
    @GetMapping
    public List<BookWarehouseView> getBookWarehouse(
            @RequestParam(value = "book", required = false) Books book,
            @RequestParam(value = "theRestOfTheBooks", required = false) Long theRestOfTheBooks
    ) {
        return bookWarehouseService.getAllBookWarehouse(new BookWarehouseFilter(book, theRestOfTheBooks))
                .stream()
                .map(bookWarehouseViewMapper::mapBookWarehouseToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BookWarehouseView booksBookWarehouse(@PathVariable("id") Long id) {
        return bookWarehouseViewMapper.mapBookWarehouseToView(bookWarehouseService.getBookWarehouseById(id));
    }
    
    @PostMapping
    public BookWarehouseView createBookWarehouse(@RequestBody BookWarehouseView bookWarehouseView) {
        if (bookWarehouseView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", bookWarehouseView.getId())
            );
        }
        BookWarehouse bookWarehouse = bookWarehouseViewMapper.mapBookWarehouseFromView(bookWarehouseView);
        BookWarehouse createBookWarehouse = bookWarehouseService.createBookWarehouse(bookWarehouse);
        return bookWarehouseViewMapper.mapBookWarehouseToView(createBookWarehouse);
    }
}
