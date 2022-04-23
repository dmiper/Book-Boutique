package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.OrdersView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuyersViewMapper {
    
    public BuyersView mapBuyersToView(Buyers buyers) {
        BuyersView buyersView = new BuyersView();
        buyersView.setId(buyers.getId());
        buyersView.setFullName(buyers.getFullName());
        buyersView.setDateOfBirth(buyers.getDateOfBirth());
        if (buyers.getOrders() != null) {
            buyersView.setOrdersViews(
                    buyers.getOrders()
                            .stream()
                            .map(orders -> new OrdersView(
                                    orders.getId(),
                                    orders.getBuyer(),
                                    orders.getPurchaseAmount()))
                            .collect(Collectors.toList()));
        }
        return buyersView;
    }
    
    public Buyers mapBuyersToView(BuyersView buyersView) {
        Buyers buyers = new Buyers();
        buyers.setId(buyersView.getId());
        buyers.setFullName(buyersView.getFullName());
        buyers.setDateOfBirth(buyersView.getDateOfBirth());
        if (buyersView.getOrdersViews() != null) {
            buyers.setOrders(
                    buyersView.getOrdersViews()
                            .stream()
                            .map(orders -> new Orders(
                                    orders.getId(),
                                    orders.getPurchaseAmount(),
                                    orders.getBuyer()))
                            .collect(Collectors.toList()));
        }
        return buyers;
    }
    
}
