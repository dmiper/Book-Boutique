package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {

}
