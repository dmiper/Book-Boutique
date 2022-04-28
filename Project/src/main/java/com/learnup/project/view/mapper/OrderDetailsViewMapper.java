package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.service.BooksService;
import com.learnup.project.service.OrdersService;
import com.learnup.project.view.*;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsViewMapper {
    
    public OrderDetailsView mapOrderDetailsToView(OrderDetails orderDetails) {
        OrderDetailsView orderDetailsView = new OrderDetailsView();
        orderDetailsView.setId(orderDetails.getId());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        orderDetailsView.setPrice(orderDetails.getPrice());
        orderDetailsView.setOrder(
                new OrdersFromOrderDetailsView(
                        orderDetails.getOrder().getId(),
                        orderDetails.getOrder().getPurchaseAmount(),
                        new BuyersFromOrdersView(
                                orderDetails.getOrder().getBuyer().getId(),
                                orderDetails.getOrder().getBuyer().getDateOfBirth(),
                                orderDetails.getOrder().getBuyer().getDateRegistration(),
                                orderDetails.getOrder().getBuyer().getFirstName(),
                                orderDetails.getOrder().getBuyer().getLastName()
                        )));
        orderDetailsView.setBook(
                new BooksView(
                        orderDetails.getBook().getId(),
                        orderDetails.getBook().getPrice(),
                        orderDetails.getBook().getNumberOfPages(),
                        orderDetails.getBook().getTitle(),
                        new AuthorsFromBookView(
                                orderDetails.getBook().getAuthor().getId(),
                                orderDetails.getBook().getAuthor().getFullName()),
                        orderDetails.getBook().getYearOfPublication(),
                        new BookWarehouseFromBookView(
                                orderDetails.getBook().getBookWarehouse().getId(),
                                orderDetails.getBook().getBookWarehouse().getTheRestOfTheBooks()
                    
                        )));
        orderDetailsView.setPrice(orderDetails.getPrice());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        return orderDetailsView;
    }
    
    public OrderDetails mapOrderDetailsFromView(OrderDetailsView orderDetailsView, BooksService booksService, OrdersService ordersService) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsView.getId());
        orderDetails.setBook(booksService.getBookByTitle(orderDetails.getBook().getTitle()));
        orderDetails.setOrder(ordersService.getOrderById(orderDetailsView.getId()));
        orderDetails.setPrice(orderDetailsView.getPrice());
        orderDetails.setQuantity(orderDetailsView.getQuantity());
        return orderDetails;
    }
    
}
