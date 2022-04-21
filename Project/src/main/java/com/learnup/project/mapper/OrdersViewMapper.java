package com.learnup.project.mapper;

import com.learnup.project.dao.entity.Orders;
import com.learnup.project.view.OrdersView;
import org.springframework.stereotype.Component;

@Component
public class OrdersViewMapper {
    
    public OrdersView mapOrdersToView(Orders orders) {
        OrdersView ordersView = new OrdersView();
        ordersView.setId(orders.getId());
        ordersView.setBuyer(orders.getBuyer());
        ordersView.setPurchaseAmount(orders.getPurchaseAmount());
        return ordersView;
    }
    
    public Orders mapOrdersToView(OrdersView ordersView) {
        Orders orders = new Orders();
        orders.setId(ordersView.getId());
        orders.setBuyer(ordersView.getBuyer());
        orders.setPurchaseAmount(ordersView.getPurchaseAmount());
        return orders;
    }
    
}
