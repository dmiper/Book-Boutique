package com.learnup.project.service;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.filter.BuyersFilter;
import com.learnup.project.dao.repository.BuyersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.BuyersSpecification.byBuyersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class BuyersService {

    private final BuyersRepository buyersRepository;
    
    public List<Buyers> getAllBuyers(BuyersFilter buyersFilter) {
        Specification<Buyers> specification = Specification.where(byBuyersFilter(buyersFilter));
        log.info("Request getAllUsers: {}", specification);
        return buyersRepository.findAll(specification);
    }
    
    public Buyers createBuyer(Buyers bookWarehouse) {
        log.info("CreateBuyer: {}", bookWarehouse.toString());
        return buyersRepository.save(bookWarehouse);
    }
    
    public Buyers getBuyersById(Long id) {
        log.info("Request getBuyersById: {}", id);
        return buyersRepository.getById(id);
    }
    
    public Boolean deleteBuyer(Long id) {
        log.info("DeleteBuyer id: {}", id);
        buyersRepository.delete(buyersRepository.getById(id));
        return true;
    }
    
    public Buyers updateBuyer(Buyers buyers) {
        try {
            log.info("UpdateBuyer: {}", buyers.toString());
            return buyersRepository.save(buyers);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for Buyer id {}", buyers.getId());
            throw e;
        }
    }
    
}
