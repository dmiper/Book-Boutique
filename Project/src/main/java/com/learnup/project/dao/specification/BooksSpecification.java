package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.filter.BooksFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class BooksSpecification {
    
    public static Specification<Books> byBookFilter(BooksFilter booksFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
    
            if (booksFilter.getTitle() != null) {
                predicate = cb.and(predicate, cb.like(root.get("title"), "%" + booksFilter.getTitle() + "%"));
            }
    
            if (booksFilter.getAuthor() != null) {
                predicate = cb.and(predicate, cb.like(root.get("author"), "%" + booksFilter.getAuthor() + "%"));
            }
    
            if (booksFilter.getYearOfPublication() != null) {
                predicate = cb.and(predicate, cb.like(root.get("yearOfPublication"), "%" + booksFilter.getYearOfPublication() + "%"));
            }
    
            if (booksFilter.getNumberOfPages() != null) {
                predicate = cb.and(predicate, cb.like(root.get("numberOfPages"), "%" + booksFilter.getNumberOfPages() + "%"));
            }
            
            if (booksFilter.getPrice() != null) {
                predicate = cb.and(predicate, cb.like(root.get("price"), "%" + booksFilter.getPrice() + "%"));
            }
    
            if (booksFilter.getBookWarehouse() != null) {
                predicate = cb.and(predicate, cb.like(root.get("bookWarehouse"), "%" + booksFilter.getBookWarehouse() + "%"));
            }
    
            return predicate;
        };
    }
}
