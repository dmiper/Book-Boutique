package com.learnup.project.service;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import com.learnup.project.dao.repository.BookWarehouseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;

import static com.learnup.project.dao.specification.BookWarehouseSpecification.byBookWarehouseFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BookWarehouseService {
    
    private final BookWarehouseRepository bookWarehouseRepository;
    
    public List<BookWarehouse> getAllBookWarehouse(BookWarehouseFilter bookWarehouseFilter) {
        Specification<BookWarehouse> specification = Specification.where(byBookWarehouseFilter(bookWarehouseFilter));
        log.info("Request getAllBookWarehouse: {}", specification);
        return bookWarehouseRepository.findAll(specification);
    }
    
    @Transactional
    public BookWarehouse createBookWarehouse(BookWarehouse bookWarehouse) {
        log.info("CreateBookWarehouse: {}", bookWarehouse.toString());
        return bookWarehouseRepository.save(bookWarehouse);
    }
    
    public BookWarehouse getBookWarehouseById(Long id) {
        try {
        log.info("Request getBookWarehouseById: {}", id);
        return bookWarehouseRepository.getBookWarehouseById(id);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for BookWarehouse id {}", id);
            throw e;
        }
    }
    
    public Boolean deleteBookWarehouse(Long id) {
        log.info("DeleteBookWarehouse id: {}", id);
        bookWarehouseRepository.delete(bookWarehouseRepository.getById(id));
        return true;
    }
    
    @Transactional
    public BookWarehouse updateBookWarehouse(BookWarehouse bookWarehouse) {
        try {
            log.info("UpdateBookWarehouse: {}", bookWarehouse.toString());
            return bookWarehouseRepository.save(bookWarehouse);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for BookWarehouse id {}", bookWarehouse.getId());
            throw e;
        }
    }
    
}
