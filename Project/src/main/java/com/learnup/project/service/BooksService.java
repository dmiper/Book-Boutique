package com.learnup.project.service;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.dao.repository.BooksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.BooksSpecification.byBookFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;
    
    public List<Books> getAllBooks(BooksFilter booksFilter) {
        Specification<Books> specification = Specification.where(byBookFilter(booksFilter));
        log.info("{}", specification);
        return booksRepository.findAll(specification);
    }
    
    public Books createBook(Books books) {
        log.info("{}", books);
        return booksRepository.save(books);
    }
    
    public Books getBookById(Long id) {
        log.info("{}", id);
        return booksRepository.getById(id);
    }
}
