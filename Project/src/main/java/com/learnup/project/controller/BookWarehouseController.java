package com.learnup.project.controller;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import com.learnup.project.service.BookWarehouseService;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.BookWarehouseView;
import com.learnup.project.view.mapper.BookWarehouseViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/book-warehouse")
public class BookWarehouseController {
    
    private final BookWarehouseService bookWarehouseService;
    private final BooksService booksService;
    
    private final BookWarehouseViewMapper bookWarehouseViewMapper;
    
    @GetMapping
    public Set<BookWarehouseView> getBookWarehouse(
            @RequestParam(value = "book", required = false) Books book,
            @RequestParam(value = "theRestOfTheBooks", required = false) Long theRestOfTheBooks
    ) {
        return bookWarehouseService.getAllBookWarehouse(new BookWarehouseFilter(book, theRestOfTheBooks))
                .stream()
                .map(bookWarehouseViewMapper::mapBookWarehouseToView)
                .collect(Collectors.toSet());
    }
    
    @GetMapping("/{id}")
    public BookWarehouseView getBookWarehouseById(@PathVariable("id") Long id) {
        return bookWarehouseViewMapper.mapBookWarehouseToView(bookWarehouseService.getBookWarehouseById(id));
    }
    
    @PostMapping
    public BookWarehouseView createBookWarehouse(@RequestBody BookWarehouseView bookWarehouseView) {
        if (bookWarehouseView.getId() != null) {
            throw new EntityExistsException(
                    String.format("BookWarehouse with id = %s already exist", bookWarehouseView.getId())
            );
        }
        BookWarehouse bookWarehouse = bookWarehouseViewMapper.mapBookWarehouseFromView(bookWarehouseView, booksService);
        BookWarehouse createBookWarehouse = bookWarehouseService.createBookWarehouse(bookWarehouse);
        return bookWarehouseViewMapper.mapBookWarehouseToView(createBookWarehouse);
    }
    
    @PutMapping("/{id}")
    public BookWarehouseView updateBookWarehouse(@PathVariable("id") Long id,
                                                 @RequestBody BookWarehouseView bookWarehouseView) {
        if (bookWarehouseView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, bookWarehouseView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        BookWarehouse bookWarehouse = bookWarehouseService.getBookWarehouseById(id);
        if (!bookWarehouse.getTheRestOfTheBooks().equals(bookWarehouseView.getTheRestOfTheBooks())) {
            bookWarehouse.setTheRestOfTheBooks(bookWarehouseView.getTheRestOfTheBooks());
        }
        BookWarehouse updateBookWarehouse = bookWarehouseService.updateBookWarehouse(bookWarehouse);
        return bookWarehouseViewMapper.mapBookWarehouseToView(updateBookWarehouse);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteBookWarehouse(@PathVariable("id") Long id) {
        return bookWarehouseService.deleteBookWarehouse(id);
    }
    
}
