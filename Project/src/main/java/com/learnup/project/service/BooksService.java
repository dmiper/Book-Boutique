package com.learnup.project.service;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.dao.repository.BooksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.BooksSpecification.byBookFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;
    
    public List<Books> getAllBooks(BooksFilter booksFilter) {
        Specification<Books> specification = Specification.where(byBookFilter(booksFilter));
        log.info("Request getAllUsers: {}", specification);
        return booksRepository.findAll(specification);
    }
    
    public Books createBook(Books books) {
        log.info("CreateBook: {}", books.toString());
        return booksRepository.save(books);
    }
    
    public Books getBookById(Long id) {
        log.info("Request getBookById: {}", id);
        return booksRepository.getBooksById(id);
    }
    
    public Boolean deleteBook(Long id) {
        log.info("DeleteBook id: {}", id);
        booksRepository.delete(booksRepository.getById(id));
        return true;
    }
    
    public Books updateBook(Books books) {
        try {
            log.info("UpdateBook: {}", books.toString());
            return booksRepository.save(books);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for Book id {}", books.getId());
            throw e;
        }
    }
    
    public Books getBookByTitle(String title) {
        return booksRepository.getBooksByTitle(title);
    }
    
}
