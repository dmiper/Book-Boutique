package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Books;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query(value = "select p.id, c.full_name, p.title, p.year_of_publication, p.number_of_pages, p.price from schema.books p left join schema.authors c on p.author_id = c.id where p.author_id = :id",
            nativeQuery = true)
    List<Books> findBooksByAuthorID(Long id);
    
    List<Books> findAll(Specification<Books> specification);
}
