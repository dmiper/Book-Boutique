package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Role;
import com.learnup.project.dao.filter.RoleFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class RoleSpecification {
    
    public static Specification<Role> byUsersRoleFilter(RoleFilter roleFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (roleFilter.getRole() != null) {
                predicate = cb.and(predicate, cb.like(root.get("role"), "%" + roleFilter.getRole() + "%"));
            }
    
            if (roleFilter.getUsers() != null) {
                predicate = cb.and(predicate, cb.like(root.get("users"), "%" + roleFilter.getUsers() + "%"));
            }
    
            return predicate;
        };
    }
}
