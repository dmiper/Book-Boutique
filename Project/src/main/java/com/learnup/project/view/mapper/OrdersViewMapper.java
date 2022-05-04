package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.BookWarehouse;
import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.service.BuyersService;
import com.learnup.project.service.OrderDetailsService;
import com.learnup.project.view.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrdersViewMapper {
    
    public OrdersView mapOrdersToView(Orders orders) {
        OrdersView ordersView = new OrdersView();
        ordersView.setId(orders.getId());
        ordersView.setPurchaseAmount(orders.getPurchaseAmount());
        ordersView.setBuyer(
                new BuyersView(
                        orders.getBuyers().getId(),
                        orders.getBuyers().getDateOfBirth(),
                        orders.getBuyers().getDateRegistration(),
                        orders.getBuyers().getFirstName(),
                        orders.getBuyers().getLastName()));
        if (orders.getOrderDetails() != null) {
            ordersView.setOrderDetails(
                    orders.getOrderDetails()
                            .stream()
                            .map(orderDetails -> new OrderDetailsView(
                                    orderDetails.getId(),
                                    orderDetails.getQuantity(),
                                    orderDetails.getPrice(),
                                    new BooksView(
                                            orderDetails.getBook().getId(),
                                            orderDetails.getBook().getNumberOfPages(),
                                            orderDetails.getBook().getPrice(),
                                            orderDetails.getBook().getTitle(),
                                            new AuthorsView(
                                                    orderDetails.getBook().getAuthor().getId(),
                                                    orderDetails.getBook().getAuthor().getFullName()),
                                            orderDetails.getBook().getYearOfPublication(),
                                            new BookWarehouseView(
                                                    orderDetails.getBook().getBookWarehouse().getId(),
                                                    orderDetails.getBook().getBookWarehouse().getTheRestOfTheBooks()
                                            ))))
                            .collect(Collectors.toList()));
            
        }
        return ordersView;
    }
    
    public Orders mapOrdersFromView(OrdersView ordersView, OrderDetailsService orderDetailsService, BuyersService buyersService) {
        Orders orders = new Orders();
        orders.setId(ordersView.getId());
        orders.setBuyers(buyersService.getBuyersById(ordersView.getBuyer().getId()));
        Long purchaseAmount = 0L;
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for (OrderDetailsView orderDetailsView : ordersView.getOrderDetails()) {
            OrderDetails orderDetails = new OrderDetails(orderDetailsView.getId());
            OrderDetails orderDetailsById = orderDetailsService.getOrderDetailsById(orderDetails.getId());
            purchaseAmount = purchaseAmount + orderDetailsById.getQuantity() * orderDetailsById.getPrice();
            orderDetailsList.add(orderDetailsById);
        }
        orders.setPurchaseAmount(purchaseAmount);
        orders.setOrderDetails(orderDetailsList);
        return orders;
    }
    
    public BookWarehouse mapOrdersForBookWarehouseFromView(Orders orders) {
        BookWarehouse bookWarehouse = new BookWarehouse();
        for (OrderDetails orderDetails : orders.getOrderDetails()) {
            bookWarehouse.setId(orderDetails.getBook().getBookWarehouse().getId());
            bookWarehouse.setTheRestOfTheBooks(orderDetails.getBook().getBookWarehouse().getTheRestOfTheBooks() - orderDetails.getQuantity());
        }
        return bookWarehouse;
    }
    
}
