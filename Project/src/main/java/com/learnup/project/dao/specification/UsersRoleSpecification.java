package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.UsersRole;
import com.learnup.project.dao.filter.UsersRoleFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class UsersRoleSpecification {
    
    public static Specification<UsersRole> byUsersRoleFilter(UsersRoleFilter usersRoleFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (usersRoleFilter.getRole() != null) {
                predicate = cb.and(predicate, cb.like(root.get("role"), "%" + usersRoleFilter.getRole() + "%"));
            }
            
            return predicate;
        };
    }
}