package com.learnup.project.view;

import com.learnup.project.dao.entity.Buyers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersView {

    private Long id;

    private Buyers buyer;

    private Long purchaseAmount;
    
}
