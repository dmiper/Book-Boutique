package com.learnup.project.service;

import com.learnup.project.dao.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
}
