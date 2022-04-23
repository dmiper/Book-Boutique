package com.learnup.project.view;

import com.learnup.project.dao.entity.Buyers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersView {

    private Long id;

    private List<BuyersNoOrdersView> buyer;

    private Long purchaseAmount;
    
}
