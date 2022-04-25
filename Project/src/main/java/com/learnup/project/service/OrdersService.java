package com.learnup.project.service;

import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.OrdersFilter;
import com.learnup.project.dao.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static com.learnup.project.dao.specification.OrdersSpecification.byOrdersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    
    public List<Orders> getAllOrders(OrdersFilter ordersFilter) {
        Specification<Orders> specification = Specification.where(byOrdersFilter(ordersFilter));
        log.info("Request getAllOrders: {}", specification);
        return ordersRepository.findAll(specification);
    }
    
    public Orders createOrder(Orders orders) {
        log.info("CreateOrder: {}", orders.toString());
        return ordersRepository.save(orders);
    }
    
    public Orders getOrderById(Long id) {
        log.info("Request getOrderById: {}", id);
        return ordersRepository.getById(id);
    }
    
    public Boolean deleteOrder(Long id) {
        log.info("DeleteOrder by id: {}", id);
        ordersRepository.delete(ordersRepository.getById(id));
        return true;
    }
    
    public Orders updateOrder(Orders orders) {
        try {
            log.info("UpdateOrder: {}", orders.toString());
            return ordersRepository.save(orders);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for Order id {}", orders.getId());
            throw e;
        }
    }
    
}
