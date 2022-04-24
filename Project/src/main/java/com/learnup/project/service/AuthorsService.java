package com.learnup.project.service;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.AuthorsFilter;
import com.learnup.project.dao.repository.AuthorsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.AuthorsSpecification.byAuthorFilter;

@Slf4j
@AllArgsConstructor
@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;
    
    public List<Authors> getAllAuthors(AuthorsFilter authorsFilter) {
        Specification<Authors> specification = Specification.where(byAuthorFilter(authorsFilter));
        log.info("{}", specification);
        return authorsRepository.findAll(specification);
    }
    
    //    TODO: доделать сохранение, так как не сохраняет, с id
    public Authors createAuthor(Authors authors) {
        log.info("{}", authors.toString());
        return authorsRepository.save(authors);
    }
    
    public Authors getBookById(Long id) {
        log.info("{}", id);
        return authorsRepository.getById(id);
    }
}
