package com.learnup.project.controller;

import com.learnup.project.mapper.BuyersViewMapper;
import com.learnup.project.service.BuyersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-boutique/buyers")
public class BuyersController {

    private final BuyersService buyersService;
    private final BuyersViewMapper buyersViewMapper;

    public BuyersController(BuyersService buyersService, BuyersViewMapper buyersViewMapper) {
        this.buyersService = buyersService;
        this.buyersViewMapper = buyersViewMapper;
    }
}
