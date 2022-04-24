package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.OrdersFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class OrdersSpecification {
    
    public static Specification<Orders> byOrdersFilter(OrdersFilter ordersFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (ordersFilter.getBuyer() != null) {
                predicate = cb.and(predicate, cb.like(root.get("buyer"), "%" + ordersFilter.getBuyer() + "%"));
            }
            
            if (ordersFilter.getPurchaseAmount() != null) {
                predicate = cb.and(predicate, cb.like(root.get("purchaseAmount"), "%" + ordersFilter.getPurchaseAmount() + "%"));
            }
            
            return predicate;
        };
    }
}
