package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.view.OrderDetailsView;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsViewMapper {
    
    public OrderDetailsView mapOrderDetailsToView(OrderDetails orderDetails) {
        OrderDetailsView orderDetailsView = new OrderDetailsView();
        orderDetailsView.setId(orderDetails.getId());
        orderDetailsView.setBook(orderDetails.getBook());
        orderDetailsView.setOrder(orderDetails.getOrder());
        orderDetailsView.setPrice(orderDetails.getPrice());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        return orderDetailsView;
    }
    
    public OrderDetails mapOrderDetailsFromView(OrderDetailsView orderDetailsView) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsView.getId());
        orderDetails.setBook(orderDetailsView.getBook());
        orderDetails.setOrder(orderDetailsView.getOrder());
        orderDetails.setPrice(orderDetailsView.getPrice());
        orderDetails.setQuantity(orderDetailsView.getQuantity());
        return orderDetails;
    }
    
}
