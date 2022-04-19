package com.learnup.project.dao.repository;

import com.learnup.project.dao.entity.BookWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {

    @Modifying
    @Query(value = "update schema.book_warehouse set the_rest_of_the_books = the_rest_of_the_books - :amount where id = :id",
            nativeQuery = true)
    Long reduceQuantitAaftePurchase(Long id, Long amount);
}
