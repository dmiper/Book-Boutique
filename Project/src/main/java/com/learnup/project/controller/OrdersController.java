package com.learnup.project.controller;

import com.learnup.project.view.mapper.OrdersViewMapper;
import com.learnup.project.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/orders")
public class OrdersController {

    private final OrdersService ordersService;
    private final OrdersViewMapper ordersViewMapper;


}
