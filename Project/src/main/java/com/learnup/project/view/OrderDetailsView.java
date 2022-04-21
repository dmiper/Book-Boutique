package com.learnup.project.view;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.Orders;
import lombok.Data;

@Data
public class OrderDetailsView {

    private Long id;

    private Orders order;

    private Books book;

    private Long quantity;

    private Long price;
}
