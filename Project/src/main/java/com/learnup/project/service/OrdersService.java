package com.learnup.project.service;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.BooksFilter;
import com.learnup.project.dao.filter.OrdersFilter;
import com.learnup.project.dao.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.learnup.project.dao.specification.BooksSpecification.byBookFilter;
import static com.learnup.project.dao.specification.OrdersSpecification.byOrdersFilter;

@Slf4j
@AllArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    
    public List<Orders> getAllOrders(OrdersFilter ordersFilter) {
        Specification<Orders> specification = Specification.where(byOrdersFilter(ordersFilter));
        log.info("{}", specification);
        return ordersRepository.findAll(specification);
    }
    
    public Orders createOrder(Orders orders) {
        log.info("{}", orders.toString());
        return ordersRepository.save(orders);
    }
    
    public Orders getOrderById(Long id) {
        log.info("{}", id);
        return ordersRepository.getById(id);
    }
}
