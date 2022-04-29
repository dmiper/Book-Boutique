package com.learnup.project.controller;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.OrdersFilter;
import com.learnup.project.service.BuyersService;
import com.learnup.project.service.OrderDetailsService;
import com.learnup.project.service.OrdersService;
import com.learnup.project.view.OrdersView;
import com.learnup.project.view.mapper.OrdersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/orders")
public class OrdersController {
    
    private final OrdersService ordersService;
    private final BuyersService buyersService;
    private final OrderDetailsService orderDetailsService;
    private final OrdersViewMapper ordersViewMapper;
    
    @GetMapping
    public List<OrdersView> getOrders(
            @RequestParam(value = "purchaseAmount", required = false) Long purchaseAmount,
            @RequestParam(value = "buyer", required = false) Buyers buyer,
            @RequestParam(value = "orderDetails", required = false) OrderDetails orderDetails
    ) {
        return ordersService.getAllOrders(new OrdersFilter(purchaseAmount, buyer, orderDetails))
                .stream()
                .map(ordersViewMapper::mapOrdersToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public OrdersView getOrderById(@PathVariable("id") Long id) {
        return ordersViewMapper.mapOrdersToView(ordersService.getOrderById(id));
    }
    
    @PostMapping
    public OrdersView createOrder(@RequestBody OrdersView ordersView) {
        if (ordersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Orders with id = %s already exist", ordersView.getId())
            );
        }
        Orders orders = ordersViewMapper.mapOrdersFromView(ordersView, buyersService, orderDetailsService);
        Orders createOrders = ordersService.createOrder(orders);
        return ordersViewMapper.mapOrdersToView(createOrders);
    }
    
    @PutMapping("/{id}")
    public OrdersView updateOrder(@PathVariable("id") Long id,
                                   @RequestBody OrdersView authorsView) {
        if (authorsView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, authorsView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Orders authors = ordersService.getOrderById(id);
        if (!authors.getPurchaseAmount().equals(authorsView.getPurchaseAmount())) {
            authors.setPurchaseAmount(authorsView.getPurchaseAmount());
        }
        Orders updateOrder = ordersService.updateOrder(authors);
        return ordersViewMapper.mapOrdersToView(updateOrder);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteOrder(@PathVariable("id") Long id) {
        return ordersService.deleteOrder(id);
    }
    
}
