package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.filter.AuthorsFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class AuthorsSpecification {
    
    public static Specification<Authors> byAuthorFilter(AuthorsFilter authorsFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (authorsFilter.getFullName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("fullName"), "%" + authorsFilter.getFullName() + "%"));
            }
            
            if (authorsFilter.getBook() != null) {
                predicate = cb.and(predicate, cb.like(root.get("book"), "%" + authorsFilter.getBook() + "%"));
            }
            
            return predicate;
        };
    }
}
