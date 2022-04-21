package com.learnup.project.service;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.dao.repository.BooksRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.BooksSpecification.byFilter;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    
    public List<Books> getAllBooks(BooksFilter booksFilter) {
        Specification<Books> specification = Specification.where(byFilter(booksFilter));
        return booksRepository.findAll(specification);
    }
    

}
