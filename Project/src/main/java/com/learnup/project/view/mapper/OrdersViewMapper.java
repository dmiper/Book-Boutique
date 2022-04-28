package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Orders;
import com.learnup.project.service.BuyersService;
import com.learnup.project.service.OrderDetailsService;
import com.learnup.project.view.*;
import org.springframework.stereotype.Component;

@Component
public class OrdersViewMapper {
    
    public OrdersView mapOrdersToView(Orders orders) {
        OrdersView ordersView = new OrdersView();
        ordersView.setId(orders.getId());
        ordersView.setPurchaseAmount(orders.getPurchaseAmount());
        ordersView.setBuyer(
                new BuyersFromOrdersView(
                        orders.getBuyer().getId(),
                        orders.getBuyer().getDateOfBirth(),
                        orders.getBuyer().getDateRegistration(),
                        orders.getBuyer().getFirstName(),
                        orders.getBuyer().getLastName()));
        ordersView.setOrderDetails(
                new OrderDetailsFromOrderView(
                        orders.getOrderDetails().getId(),
                        orders.getOrderDetails().getQuantity(),
                        orders.getOrderDetails().getPrice(),
                        new BooksView(
                                orders.getOrderDetails().getBook().getId(),
                                orders.getOrderDetails().getBook().getNumberOfPages(),
                                orders.getOrderDetails().getBook().getPrice(),
                                orders.getOrderDetails().getBook().getTitle(),
                                new AuthorsFromBookView(
                                        orders.getOrderDetails().getBook().getAuthor().getId(),
                                        orders.getOrderDetails().getBook().getAuthor().getFullName()),
                                orders.getOrderDetails().getBook().getYearOfPublication(),
                                new BookWarehouseFromBookView(
                                        orders.getOrderDetails().getBook().getBookWarehouse().getId(),
                                        orders.getOrderDetails().getBook().getBookWarehouse().getTheRestOfTheBooks()))
            
                ));
        return ordersView;
    }
    
    public Orders mapOrdersFromView(OrdersView ordersView, BuyersService buyersService, OrderDetailsService orderDetailsService) {
        Orders orders = new Orders();
        orders.setId(ordersView.getId());
        orders.setPurchaseAmount(ordersView.getPurchaseAmount());
        orders.setBuyer(buyersService.getBuyersById(ordersView.getBuyer().getId()));
        orders.setOrderDetails(orderDetailsService.getOrderDetailsById(ordersView.getOrderDetails().getId()));
        return orders;
    }
    
}
