package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Role;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    
    @Modifying
    @Query("select r from Role r where r.role = ?1")
    Role getRoleByRole(String role);
    
    Set<Role> findAll(Specification<Role> specification);
    
}
