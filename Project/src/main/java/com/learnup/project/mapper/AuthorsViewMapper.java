package com.learnup.project.mapper;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.view.AuthorsView;
import org.springframework.stereotype.Component;

@Component
public class AuthorsViewMapper {
    
    public AuthorsView mapAuthorsToView(Authors authors) {
        AuthorsView authorsView = new AuthorsView();
        authorsView.setId(authors.getId());
        authorsView.setFullName(authors.getFullName());
        return authorsView;
    }
    
    public Authors mapAuthorsFromView(AuthorsView authorsView) {
        Authors authors = new Authors();
        authors.setId(authorsView.getId());
        authors.setFullName(authorsView.getFullName());
        return authors;
    }
    
}
