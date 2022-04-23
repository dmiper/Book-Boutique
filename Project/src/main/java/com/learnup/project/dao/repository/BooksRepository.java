package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Books;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    
    List<Books> findAll(Specification<Books> specification);
}
