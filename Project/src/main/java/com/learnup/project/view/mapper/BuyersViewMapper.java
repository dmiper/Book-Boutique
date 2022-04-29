package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.service.UsersService;
import com.learnup.project.view.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuyersViewMapper {
    
    public BuyersView mapBuyersToView(Buyers buyers) {
        BuyersView buyersView = new BuyersView();
        buyersView.setId(buyers.getId());
        buyersView.setDateRegistration(buyers.getDateRegistration());
        buyersView.setUser(
                new UsersFromBuyerView(
                        buyers.getUser().getId(),
                        new RoleFromUserView(
                                buyers.getUser().getRole().getId(),
                                buyers.getUser().getRole().getRole()
                        ),
                        buyers.getUser().getLoginName()
                ));
        buyersView.setDateOfBirth(buyers.getDateOfBirth());
        buyersView.setFirstName(buyers.getFirstName());
        buyersView.setLastName(buyers.getLastName());
        buyersView.setOrders(
                buyers.getOrders()
                        .stream()
                        .map(orders -> new OrdersFromBuyersView(
                                orders.getId(),
                                orders.getPurchaseAmount(),
                                new OrderDetailsFromOrderView(
                                        orders.getOrderDetails().getId(),
                                        orders.getOrderDetails().getQuantity(),
                                        orders.getOrderDetails().getPrice(),
                                        new BooksView(
                                                orders.getOrderDetails().getBook().getId(),
                                                orders.getOrderDetails().getBook().getPrice(),
                                                orders.getOrderDetails().getBook().getNumberOfPages(),
                                                orders.getOrderDetails().getBook().getTitle(),
                                                new AuthorsFromBookView(
                                                        orders.getOrderDetails().getBook().getAuthor().getId(),
                                                        orders.getOrderDetails().getBook().getAuthor().getFullName()),
                                                orders.getOrderDetails().getBook().getYearOfPublication(),
                                                new BookWarehouseFromBookView(
                                                        orders.getOrderDetails().getBook().getBookWarehouse().getId(),
                                                        orders.getOrderDetails().getBook().getBookWarehouse().getTheRestOfTheBooks()
                                                )))))
                        .collect(Collectors.toList()));
    
        return buyersView;
    }
    
    public Buyers mapBuyersFromView(BuyersView buyersView, UsersService usersService) {
        Buyers buyers = new Buyers();
        buyers.setId(buyersView.getId());
        buyers.setUser(usersService.getUserById(buyersView.getId()));
        buyers.setDateOfBirth(buyersView.getDateOfBirth());
        return buyers;
    }
    
}
