package com.learnup.project.service;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import com.learnup.project.dao.repository.BookWarehouseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.BookWarehouseSpecification.byBookWarehouseFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BookWarehouseService {
    
    private final BookWarehouseRepository bookWarehouseRepository;
    
    public List<BookWarehouse> getAllBookWarehouse(BookWarehouseFilter bookWarehouseFilter) {
        Specification<BookWarehouse> specification = Specification.where(byBookWarehouseFilter(bookWarehouseFilter));
        log.info("{}", specification);
        return bookWarehouseRepository.findAll(specification);
    }
    
    public BookWarehouse createBookWarehouse(BookWarehouse bookWarehouse) {
        log.info("{}", bookWarehouse.toString());
        return bookWarehouseRepository.save(bookWarehouse);
    }
    
    public BookWarehouse getBookWarehouseById(Long id) {
        log.info("{}", id);
        return bookWarehouseRepository.getById(id);
    }
}
