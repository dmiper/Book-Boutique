package com.learnup.project.service;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.AuthorsFilter;
import com.learnup.project.dao.repository.AuthorsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.AuthorsSpecification.byAuthorFilter;

@Slf4j
@AllArgsConstructor
@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;
    
    public List<Authors> getAllAuthors(AuthorsFilter authorsFilter) {
        Specification<Authors> specification = Specification.where(byAuthorFilter(authorsFilter));
        log.info("Request getAllAuthors: {}", specification);
        return authorsRepository.findAll(specification);
    }
    
    public Authors createAuthor(Authors authors) {
        log.info("CreateAuthor: {}", authors.toString());
        return authorsRepository.save(authors);
    }
    
    public Authors getAuthorById(Long id) {
        log.info("Request getAuthorById: {}", id);
        Authors author = authorsRepository.getAuthorsById(id);
        log.info("Author: {}", author.toString());
        return author;
    }
    
    public Boolean deleteAuthor(Long id) {
        log.info("DeleteAuthor id: {}", id);
        authorsRepository.delete(authorsRepository.getById(id));
        return true;
    }
    
    public Authors updateAuthor(Authors authors) {
        try {
            log.info("UpdateAuthor: {}", authors.toString());
            return authorsRepository.save(authors);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for Author id {}", authors.getId());
            throw e;
        }
    }
    
    public Authors getAuthorByFullName(String fullName) {
        log.info("Request getAuthorByFullName: {}", fullName);
        Authors author = authorsRepository.getAuthorsByFullName(fullName);
        log.info("Author: {}", author.toString());
        return author;
    }
    
}
