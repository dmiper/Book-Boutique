package com.learnup.project.controller;

import com.learnup.project.mapper.OrderDetailsViewMapper;
import com.learnup.project.service.OrderDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-boutique/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;
    private final OrderDetailsViewMapper orderDetailsViewMapper;

    public OrderDetailsController(OrderDetailsService orderDetailsService, OrderDetailsViewMapper orderDetailsViewMapper) {
        this.orderDetailsService = orderDetailsService;
        this.orderDetailsViewMapper = orderDetailsViewMapper;
    }
}
