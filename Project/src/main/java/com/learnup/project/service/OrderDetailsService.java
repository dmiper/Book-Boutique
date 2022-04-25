package com.learnup.project.service;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.filter.OrderDetailsFilter;
import com.learnup.project.dao.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.Collection;

import static com.learnup.project.dao.specification.OrderDetailsSpecification.byOrderDetailsFilter;

@Slf4j
@AllArgsConstructor
@Service
public class OrderDetailsService {
    
    private final OrderDetailsRepository orderDetailsRepository;
    
    public Collection<OrderDetails> getAllOrderDetails(OrderDetailsFilter orderDetailsFilter) {
        Specification<OrderDetails> specification = Specification.where(byOrderDetailsFilter(orderDetailsFilter));
        log.info("Request getAllOrderDetails: {}", specification);
        return orderDetailsRepository.findAll(specification);
    }
    
    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        log.info("CreateOrderDetails: {}", orderDetails.toString());
        return orderDetailsRepository.save(orderDetails);
    }
    
    public OrderDetails getOrderDetailsById(Long id) {
        log.info("Request getOrderDetailsById: {}", id);
        return orderDetailsRepository.getById(id);
    }
    
    public Boolean deleteOrderDetail(Long id) {
        log.info("DeleteOrderDetail id: {}", id);
        orderDetailsRepository.delete(orderDetailsRepository.getById(id));
        return true;
    }
    
    public OrderDetails updateOrderDetail(OrderDetails orderDetails) {
        try {
            log.info("UpdateOrderDetail: {}", orderDetails.toString());
            return orderDetailsRepository.save(orderDetails);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for OrderDetail id {}", orderDetails.getId());
            throw e;
        }
    }
    
}
