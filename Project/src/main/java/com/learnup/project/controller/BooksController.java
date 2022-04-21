package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.mapper.BooksViewMapper;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.BooksView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(value = "author", required = false) Authors author,
            @RequestParam(value = "yearOfPublication", required = false) LocalDate yearOfPublication,
            @RequestParam(value = "numberOfPages", required = false) Long numberOfPages,
            @RequestParam(value = "price", required = false) Long price
    ) {
        return booksService.getAllBooks(new BooksFilter(title, author, yearOfPublication, numberOfPages, price))
                .stream()
                .map(booksViewMapper::mapBooksToView)
                .collect(Collectors.toList());
    }
    
}
