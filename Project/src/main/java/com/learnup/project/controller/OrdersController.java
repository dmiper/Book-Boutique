package com.learnup.project.controller;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.OrdersFilter;
import com.learnup.project.service.OrdersService;
import com.learnup.project.view.OrdersView;
import com.learnup.project.view.mapper.OrdersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/orders")
public class OrdersController {
    
    private final OrdersService ordersService;
    private final OrdersViewMapper ordersViewMapper;
    
    @GetMapping
    public List<OrdersView> getBooks(
            @RequestParam(value = "title", required = false) Long purchaseAmount,
            @RequestParam(value = "author", required = false) Collection<Buyers> buyer
    ) {
        return ordersService.getAllOrders(new OrdersFilter(purchaseAmount, buyer))
                .stream()
                .map(ordersViewMapper::mapOrdersToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public OrdersView booksView(@PathVariable("id") Long id) {
        return ordersViewMapper.mapOrdersToView(ordersService.getOrderById(id));
    }
    
    @PostMapping
    public OrdersView createBook(@RequestBody OrdersView ordersView) {
        if (ordersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", ordersView.getId())
            );
        }
        Orders orders = ordersViewMapper.mapOrdersFromView(ordersView);
        Orders createOrders = ordersService.createOrder(orders);
        return ordersViewMapper.mapOrdersToView(createOrders);
    }
}
