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
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
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
        if (!bookWarehouse.getBook().equals(bookWarehouseView.getBook())) {
            bookWarehouse.setBook(bookWarehouseView.getBook());
        }
        if (!bookWarehouse.getVersion().equals(bookWarehouseView.getVersion())) {
            bookWarehouse.setVersion(bookWarehouseView.getVersion());
        }
        BookWarehouse updateBookWarehouse = bookWarehouseService.updateBookWarehouse(bookWarehouse);
        return bookWarehouseViewMapper.mapBookWarehouseToView(updateBookWarehouse);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteBookWarehouse(@PathVariable("id") Long id) {
        return bookWarehouseService.deleteBookWarehouse(id);
    }
    
}
