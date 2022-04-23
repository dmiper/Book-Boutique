package com.learnup.project.controller;

import com.learnup.project.view.mapper.BuyersViewMapper;
import com.learnup.project.service.BuyersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/buyers")
public class BuyersController {

    private final BuyersService buyersService;
    private final BuyersViewMapper buyersViewMapper;

}
