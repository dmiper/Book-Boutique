package com.learnup.project.controller;

import com.learnup.project.mapper.OrdersViewMapper;
import com.learnup.project.service.OrdersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-boutique/orders")
public class OrdersController {

    private final OrdersService ordersService;
    private final OrdersViewMapper ordersViewMapper;

    public OrdersController(OrdersService ordersService, OrdersViewMapper ordersViewMapper) {
        this.ordersService = ordersService;
        this.ordersViewMapper = ordersViewMapper;
    }


}
