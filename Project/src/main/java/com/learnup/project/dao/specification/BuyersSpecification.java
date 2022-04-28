package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.filter.BuyersFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class BuyersSpecification {
    
    public static Specification<Buyers> byBuyersFilter(BuyersFilter buyersFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (buyersFilter.getUser() != null) {
                predicate = cb.and(predicate, cb.like(root.get("user"), "%" + buyersFilter.getUser() + "%"));
            }
            
            if (buyersFilter.getDateOfBirth() != null) {
                predicate = cb.and(predicate, cb.like(root.get("dateOfBirth"), "%" + buyersFilter.getDateOfBirth() + "%"));
            }
    
            if (buyersFilter.getDateRegistration() != null) {
                predicate = cb.and(predicate, cb.like(root.get("dateRegistration"), "%" + buyersFilter.getDateRegistration() + "%"));
            }
    
            if (buyersFilter.getOrders() != null) {
                predicate = cb.and(predicate, cb.like(root.get("orders"), "%" + buyersFilter.getOrders() + "%"));
            }
    
            if (buyersFilter.getFirstName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("firstName"), "%" + buyersFilter.getFirstName() + "%"));
            }
    
            if (buyersFilter.getLastName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("lastName"), "%" + buyersFilter.getLastName() + "%"));
            }
    
            return predicate;
        };
    }
}
