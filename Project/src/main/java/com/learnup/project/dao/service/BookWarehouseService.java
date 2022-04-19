package com.learnup.project.dao.service;

import com.learnup.project.dao.repository.BookWarehouseRepository;
import org.springframework.stereotype.Service;

@Service
public class BookWarehouseService {

    private final BookWarehouseRepository bookWarehouseRepository;

    public BookWarehouseService(BookWarehouseRepository bookWarehouseRepository) {
        this.bookWarehouseRepository = bookWarehouseRepository;
    }
}
