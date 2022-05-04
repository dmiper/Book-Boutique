package com.learnup.project.controller;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.AuthorsFilter;
import com.learnup.project.service.AuthorsService;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.mapper.AuthorsViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/authors")
public class AuthorsController {
    
    private final AuthorsService authorsService;
    private final AuthorsViewMapper authorsViewMapper;
    
    @GetMapping
    public List<AuthorsView> getAuthors(
            @RequestParam(value = "fullName", required = false) String fullName
    ) {
        return authorsService.getAllAuthors(new AuthorsFilter(fullName))
                .stream()
                .map(authorsViewMapper::mapAuthorsToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public AuthorsView getAuthorById(@PathVariable("id") Long id) {
        return authorsViewMapper.mapAuthorsToView(authorsService.getAuthorById(id));
    }
    
    @PostMapping
    public AuthorsView createAuthor(@RequestBody AuthorsView authorsView) {
        if (authorsView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Authors with id = %s already exist", authorsView.getId())
            );
        }
        Authors authors = authorsViewMapper.mapAuthorsFromView(authorsView);
        Authors createAuthor = authorsService.createAuthor(authors);
        return authorsViewMapper.mapAuthorsToView(createAuthor);
    }
    
    @PutMapping("/{id}")
    public AuthorsView updateAuthor(@PathVariable("id") Long id,
            @RequestBody AuthorsView authorsView) {
        if (authorsView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, authorsView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Authors authors = authorsService.getAuthorById(id);
        if (!authors.getFullName().equals(authorsView.getFullName())) {
            authors.setFullName(authorsView.getFullName());
        }
        Authors updateAuthor = authorsService.updateAuthor(authors);
        return authorsViewMapper.mapAuthorsToView(updateAuthor);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteAuthor(@PathVariable("id") Long id) {
        return authorsService.deleteAuthor(id);
    }
    
}
