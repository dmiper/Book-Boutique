package com.learnup.project.view;

import com.learnup.project.dao.entity.Buyers;
import lombok.Data;

@Data
public class OrdersView {

    private Long id;

    private Buyers buyer;

    private Long purchaseAmount;
}
