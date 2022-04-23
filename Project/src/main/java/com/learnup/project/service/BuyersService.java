package com.learnup.project.service;

import com.learnup.project.dao.repository.BuyersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class BuyersService {

    private final BuyersRepository buyersRepository;
    
}
