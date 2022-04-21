package com.learnup.project.controller;

import com.learnup.project.mapper.BooksViewMapper;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.BooksView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<BooksView> getBooks() {
        return booksService.getAllBooks().stream().map(booksViewMapper::mapBooksToView).collect(Collectors.toList());
    }
    
    
}
