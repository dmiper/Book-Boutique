package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.UsersRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRoleRepository extends JpaRepository<UsersRole, Long> {
    
    List<UsersRole> findAll(Specification<UsersRole> specification);
}
