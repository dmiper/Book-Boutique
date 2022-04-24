package com.learnup.project.dao.specification;

import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.UsersFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class UsersSpecification {
    
    public static Specification<Users> byUsersFilter(UsersFilter usersFilter) {
        
        return (root, q, cb) -> {
            
            Predicate predicate = cb.isNotNull(root.get("id"));
            
            if (usersFilter.getEmail() != null) {
                predicate = cb.and(predicate, cb.like(root.get("email"), "%" + usersFilter.getEmail() + "%"));
            }
            
            if (usersFilter.getFirstName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("firstName"), "%" + usersFilter.getFirstName() + "%"));
            }
    
            if (usersFilter.getLastName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("lastName"), "%" + usersFilter.getLastName() + "%"));
            }
    
            if (usersFilter.getLoginName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("loginName"), "%" + usersFilter.getLoginName() + "%"));
            }
    
            if (usersFilter.getHashPassword() != null) {
                predicate = cb.and(predicate, cb.like(root.get("hashPassword"), "%" + usersFilter.getHashPassword() + "%"));
            }
    
            if (usersFilter.getDateRegistration() != null) {
                predicate = cb.and(predicate, cb.like(root.get("dateRegistration"), "%" + usersFilter.getDateRegistration() + "%"));
            }
    
            if (usersFilter.getRole() != null) {
                predicate = cb.and(predicate, cb.like(root.get("role"), "%" + usersFilter.getRole() + "%"));
            }
            
            return predicate;
        };
    }
}
