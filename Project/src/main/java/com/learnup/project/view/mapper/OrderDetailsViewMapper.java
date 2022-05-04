package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.service.BooksService;
import com.learnup.project.view.AuthorsView;
import com.learnup.project.view.BookWarehouseView;
import com.learnup.project.view.BooksView;
import com.learnup.project.view.OrderDetailsView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderDetailsViewMapper {
    
    public OrderDetailsView mapOrderDetailsToView(OrderDetails orderDetails) {
        OrderDetailsView orderDetailsView = new OrderDetailsView();
        orderDetailsView.setId(orderDetails.getId());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        orderDetailsView.setPrice(orderDetails.getPrice());
        orderDetailsView.setBook(
                new BooksView(
                        orderDetails.getBook().getId(),
                        orderDetails.getBook().getPrice(),
                        orderDetails.getBook().getNumberOfPages(),
                        orderDetails.getBook().getTitle(),
                        new AuthorsView(
                                orderDetails.getBook().getAuthor().getId(),
                                orderDetails.getBook().getAuthor().getFullName()),
                        orderDetails.getBook().getYearOfPublication(),
                        new BookWarehouseView(
                                orderDetails.getBook().getBookWarehouse().getId(),
                                orderDetails.getBook().getBookWarehouse().getTheRestOfTheBooks())));
        orderDetailsView.setPrice(orderDetails.getPrice());
        orderDetailsView.setQuantity(orderDetails.getQuantity());
        return orderDetailsView;
    }
    
    public OrderDetails mapOrderDetailsFromView(OrderDetailsView orderDetailsView, BooksService booksService) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsView.getId());
        orderDetails.setBook(booksService.getBookByTitle(orderDetailsView.getBook().getTitle()));
        orderDetails.setQuantity(orderDetailsView.getQuantity());
        orderDetails.setPrice(orderDetails.getBook().getPrice());
        return orderDetails;
    }
    
}
