package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.AuthorsFilter;
import com.learnup.project.view.mapper.AuthorsViewMapper;
import com.learnup.project.service.AuthorsService;
import com.learnup.project.view.AuthorsView;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book-boutique/authors")
public class AuthorsController {
    
    private final AuthorsService authorsService;
    private final AuthorsViewMapper authorsViewMapper;
    
    public AuthorsController(AuthorsService authorsService, AuthorsViewMapper authorsViewMapper) {
        this.authorsService = authorsService;
        this.authorsViewMapper = authorsViewMapper;
    }
    
    @GetMapping
    public List<AuthorsView> getBooks(
            @RequestParam(value = "fullName", required = false) String fullName
    ) {
        return authorsService.getAllAuthors(new AuthorsFilter(fullName))
                .stream()
                .map(authorsViewMapper::mapAuthorsToView)
                .collect(Collectors.toList());
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
