package com.learnup.project.service;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.filter.OrderDetailsFilter;
import com.learnup.project.dao.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.learnup.project.dao.specification.OrderDetailsSpecification.byOrderDetailsFilter;

@Slf4j
@AllArgsConstructor
@Service
public class OrderDetailsService {
    
    private final OrderDetailsRepository orderDetailsRepository;
    
    public Collection<OrderDetails> getAllOrderDetails(OrderDetailsFilter orderDetailsFilter) {
        Specification<OrderDetails> specification = Specification.where(byOrderDetailsFilter(orderDetailsFilter));
        log.info("{}", specification);
        return orderDetailsRepository.findAll(specification);
    }
    
    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        log.info("{}", orderDetails.toString());
        return orderDetailsRepository.save(orderDetails);
    }
    
    public OrderDetails getOrderDetailsById(Long id) {
        log.info("{}", id);
        return orderDetailsRepository.getById(id);
    }
}
