package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Authors;
import com.learnup.project.dao.entity.Books;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    
    List<Authors> findAll(Specification<Authors> specification);
}
