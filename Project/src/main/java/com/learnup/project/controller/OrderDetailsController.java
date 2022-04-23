package com.learnup.project.controller;

import com.learnup.project.view.mapper.OrderDetailsViewMapper;
import com.learnup.project.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;
    private final OrderDetailsViewMapper orderDetailsViewMapper;

}
