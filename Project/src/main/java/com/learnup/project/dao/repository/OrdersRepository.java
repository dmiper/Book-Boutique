package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Orders;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    
    Set<Orders> findAll(Specification<Orders> specification);
    
}
