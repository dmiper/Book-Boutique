package com.learnup.project.service;

import com.learnup.project.dao.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }
}
