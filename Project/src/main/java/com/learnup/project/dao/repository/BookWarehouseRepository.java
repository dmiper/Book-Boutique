package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.BookWarehouse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {
    
    List<BookWarehouse> findAll(Specification<BookWarehouse> specification);
    
    BookWarehouse getBookWarehouseById(Long id);
    
}
