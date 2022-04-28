package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Users;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    
    Set<Users> findAll(Specification<Users> specification);
    
}
