package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.view.BuyersNoOrdersView;
import com.learnup.project.view.OrdersView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrdersViewMapper {
    
    public OrdersView mapOrdersToView(Orders orders) {
        OrdersView ordersView = new OrdersView();
        ordersView.setId(orders.getId());
        ordersView.setPurchaseAmount(orders.getPurchaseAmount());
        if (orders.getBuyer() != null) {
            ordersView.setBuyer(
                    orders.getBuyer()
                            .stream()
                            .map(buyers -> new BuyersNoOrdersView(
                                    buyers.getId(),
                                    buyers.getUser(),
                                    buyers.getDateOfBirth()
                            ))
                            .collect(Collectors.toList()));

        }
        return ordersView;
    }
    
    public Orders mapOrdersFromView(OrdersView ordersView) {
        Orders orders = new Orders();
        orders.setId(ordersView.getId());
        orders.setPurchaseAmount(ordersView.getPurchaseAmount());
        if (ordersView.getBuyer() != null) {
            orders.setBuyer(
                    ordersView.getBuyer()
                            .stream()
                            .map(buyersNoOrdersView -> new Buyers(
                                    buyersNoOrdersView.getId(),
                                    buyersNoOrdersView.getUser(),
                                    buyersNoOrdersView.getDateOfBirth()
                            ))
                            .collect(Collectors.toList()));

        }
        return orders;
    }
    
}
