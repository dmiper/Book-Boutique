package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class BookWarehouseSpecification {
    
    public static Specification<BookWarehouse> byBookWarehouseFilter(BookWarehouseFilter bookWarehouseFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (bookWarehouseFilter.getBook() != null) {
                predicate = cb.and(predicate, cb.like(root.get("book"), "%" + bookWarehouseFilter.getBook() + "%"));
            }
            
            if (bookWarehouseFilter.getTheRestOfTheBooks() != null) {
                predicate = cb.and(predicate, cb.like(root.get("theRestOfTheBooks"), "%" + bookWarehouseFilter.getTheRestOfTheBooks() + "%"));
            }
            
            return predicate;
        };
    }
}
