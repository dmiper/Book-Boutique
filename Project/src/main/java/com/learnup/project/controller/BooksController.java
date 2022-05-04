package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.service.AuthorsService;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.BooksView;
import com.learnup.project.view.mapper.BooksViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/books")
public class BooksController {
    
    private final BooksService booksService;
    private final AuthorsService authorsService;
    private final BooksViewMapper booksViewMapper;
    
    @GetMapping
    public List<BooksView> getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) Authors author,
            @RequestParam(value = "yearOfPublication", required = false) LocalDate yearOfPublication,
            @RequestParam(value = "numberOfPages", required = false) Long numberOfPages,
            @RequestParam(value = "price", required = false) Long price,
            @RequestParam(value = "bookWarehouse", required = false) BookWarehouse bookWarehouse
    ) {
        return booksService.getAllBooks(new BooksFilter(title, yearOfPublication, numberOfPages, price, author, bookWarehouse))
                .stream()
                .map(booksViewMapper::mapBooksToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BooksView getBookById(@PathVariable("id") Long id) {
        return booksViewMapper.mapBooksToView(booksService.getBookById(id));
    }
    
    @PostMapping
    public BooksView createBook(@RequestBody BooksView booksView) {
        if (booksView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", booksView.getId())
            );
        }
        Books books = booksViewMapper.mapBooksFromView(booksView, authorsService);
        Books createBook = booksService.createBook(books);
        return booksViewMapper.mapBooksToView(createBook);
    }
    
    @PutMapping("/{id}")
    public BooksView updateBook(@PathVariable("id") Long id,
                                @RequestBody BooksView authorsView) {
        if (authorsView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, authorsView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Books authors = booksService.getBookById(id);
        if (!authors.getTitle().equals(authorsView.getTitle())) {
            authors.setTitle(authorsView.getTitle());
        }
        if (!authors.getPrice().equals(authorsView.getPrice())) {
            authors.setPrice(authorsView.getPrice());
        }
        if (!authors.getNumberOfPages().equals(authorsView.getNumberOfPages())) {
            authors.setNumberOfPages(authorsView.getNumberOfPages());
        }
        if (!authors.getYearOfPublication().equals(authorsView.getYearOfPublication())) {
            authors.setYearOfPublication(authorsView.getYearOfPublication());
        }
        Books updateBook = booksService.updateBook(authors);
        return booksViewMapper.mapBooksToView(updateBook);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable("id") Long id) {
        return booksService.deleteBook(id);
    }
    
}
