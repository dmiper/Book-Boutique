package com.learnup.project.controller;

import com.learnup.project.mapper.AuthorsViewMapper;
import com.learnup.project.service.AuthorsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-boutique/authors")
public class AuthorsController {

    private final AuthorsService authorsService;
    private final AuthorsViewMapper authorsViewMapper;

    public AuthorsController(AuthorsService authorsService, AuthorsViewMapper authorsViewMapper) {
        this.authorsService = authorsService;
        this.authorsViewMapper = authorsViewMapper;
    }
}
