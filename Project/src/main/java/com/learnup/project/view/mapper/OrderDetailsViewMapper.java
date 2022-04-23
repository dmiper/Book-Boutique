package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.view.OrderDetailsView;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsViewMapper {
    
    public OrderDetailsView mapOrderDetailsToView(OrderDetails orderDetails) {
        OrderDetailsView orderDetailsView = new OrderDetailsView();
        orderDetailsView.setId(orderDetails.getId());
        orderDetailsView.setOrder(orderDetails.getOrder());
        orderDetailsView.setBook(orderDetails.getBook());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        orderDetailsView.setPrice(orderDetails.getPrice());
        return orderDetailsView;
    }
    
    public OrderDetails mapOrderDetailsToView(OrderDetailsView orderDetailsView) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsView.getId());
        orderDetails.setOrder(orderDetailsView.getOrder());
        orderDetails.setBook(orderDetailsView.getBook());
        orderDetails.setQuantity(orderDetailsView.getQuantity());
        orderDetails.setPrice(orderDetailsView.getPrice());
        return orderDetails;
    }
    
}
