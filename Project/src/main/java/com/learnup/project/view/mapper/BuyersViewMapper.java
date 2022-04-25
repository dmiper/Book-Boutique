package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.OrdersNoBuyersView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuyersViewMapper {
    
    public BuyersView mapBuyersToView(Buyers buyers) {
        BuyersView buyersView = new BuyersView();
        buyersView.setId(buyers.getId());
        buyersView.setUser(buyers.getUser());
        buyersView.setDateOfBirth(buyers.getDateOfBirth());
        if (buyers.getOrders() != null) {
            buyersView.setOrders(
                    buyers.getOrders()
                            .stream()
                            .map(orders -> new OrdersNoBuyersView(
                                    orders.getId(),
                                    orders.getPurchaseAmount()))
                            .collect(Collectors.toList()));
        }
        return buyersView;
    }
    
    public Buyers mapBuyersFromView(BuyersView buyersView) {
        Buyers buyers = new Buyers();
        buyers.setId(buyersView.getId());
        buyers.setUser(buyersView.getUser());
        buyers.setDateOfBirth(buyersView.getDateOfBirth());
        if (buyersView.getOrders() != null) {
            buyers.setOrders(
                    buyersView.getOrders()
                            .stream()
                            .map(ordersNoBuyersView -> new Orders(
                                    ordersNoBuyersView.getId(),
                                    ordersNoBuyersView.getPurchaseAmount()))
                            .collect(Collectors.toList()));
        }
        return buyers;
    }
    
}
