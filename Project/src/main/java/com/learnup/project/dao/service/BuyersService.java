package com.learnup.project.dao.service;

import com.learnup.project.dao.repository.BuyersRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyersService {

    private final BuyersRepository buyersRepository;

    public BuyersService(BuyersRepository buyersRepository) {
        this.buyersRepository = buyersRepository;
    }
}
