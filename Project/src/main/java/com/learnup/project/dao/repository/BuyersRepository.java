package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Buyers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {
    
    Set<Buyers> findAll(Specification<Buyers> specification);
    
}
