package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.AuthorsFilter;
import com.learnup.project.service.AuthorsService;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.mapper.AuthorsViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/authors")
public class AuthorsController {
    
    private final AuthorsService authorsService;
    private final AuthorsViewMapper authorsViewMapper;

    @GetMapping
    public List<AuthorsView> getBooks(
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "book", required = false) Collection<Books> book
    ) {
        return authorsService.getAllAuthors(new AuthorsFilter(fullName, book))
                .stream()
                .map(authorsViewMapper::mapAuthorsToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public AuthorsView booksView(@PathVariable("id") Long id) {
        return authorsViewMapper.mapAuthorsToView(authorsService.getBookById(id));
    }
    
    @PostMapping
    public AuthorsView createBook(@RequestBody AuthorsView authorsView) {
        if (authorsView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Authors with id = %s already exist", authorsView.getId())
            );
        }
        Authors authors = authorsViewMapper.mapAuthorsFromView(authorsView);
        Authors createAuthor = authorsService.createAuthor(authors);
        return authorsViewMapper.mapAuthorsToView(createAuthor);
    }
}
