package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.BooksView;
import com.learnup.project.view.mapper.BooksViewMapper;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book-boutique/books")
public class BooksController {
    
    private final BooksService booksService;
    private final BooksViewMapper booksViewMapper;
    
    public BooksController(BooksService booksService, BooksViewMapper booksViewMapper) {
        this.booksService = booksService;
        this.booksViewMapper = booksViewMapper;
    }
    
    @GetMapping
    public List<BooksView> getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) List<Authors> author,
            @RequestParam(value = "yearOfPublication", required = false) LocalDate yearOfPublication,
            @RequestParam(value = "numberOfPages", required = false) Long numberOfPages,
            @RequestParam(value = "price", required = false) Long price
    ) {
        return booksService.getAllBooks(new BooksFilter(title, author, yearOfPublication, numberOfPages, price))
                .stream()
                .map(booksViewMapper::mapBooksToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BooksView booksView(@PathVariable("id") Long id) {
        return booksViewMapper.mapBooksToView(booksService.getBookById(id));
    }
    
    @PostMapping
    public BooksView createBook(@RequestBody BooksView booksView) {
        if (booksView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", booksView.getId())
            );
        }
        Books books = booksViewMapper.mapBooksFromView(booksView);
        Books createBook = booksService.createBook(books);
        return booksViewMapper.mapBooksToView(createBook);
    }
}
