package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Books;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    
    Set<Books> findAll(Specification<Books> specification);
    
    @Modifying
    @Query("select b from Books b where b.title = ?1")
    Books getBookByTitle(String title);

}
