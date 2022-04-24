package com.learnup.project.service;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.filter.BookWarehouseFilter;
import com.learnup.project.dao.filter.BuyersFilter;
import com.learnup.project.dao.repository.BuyersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.BookWarehouseSpecification.byBookWarehouseFilter;
import static com.learnup.project.dao.specification.BuyersSpecification.byBuyersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BuyersService {

    private final BuyersRepository buyersRepository;
    
    public List<Buyers> getAllBuyers(BuyersFilter buyersFilter) {
        Specification<Buyers> specification = Specification.where(byBuyersFilter(buyersFilter));
        log.info("{}", specification);
        return buyersRepository.findAll(specification);
    }
    
    public Buyers createBuyer(Buyers bookWarehouse) {
        log.info("{}", bookWarehouse.toString());
        return buyersRepository.save(bookWarehouse);
    }
    
    public Buyers getBuyersById(Long id) {
        log.info("{}", id);
        return buyersRepository.getById(id);
    }
}
