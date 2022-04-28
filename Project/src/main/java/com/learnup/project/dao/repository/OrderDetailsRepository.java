package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.OrderDetails;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    
    Set<OrderDetails> findAll(Specification<OrderDetails> specification);

}
