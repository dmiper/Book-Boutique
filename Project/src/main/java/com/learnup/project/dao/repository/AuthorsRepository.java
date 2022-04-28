package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Authors;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    
    Set<Authors> findAll(Specification<Authors> specification);
    
}
