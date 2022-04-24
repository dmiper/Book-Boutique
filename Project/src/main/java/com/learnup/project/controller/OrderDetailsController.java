package com.learnup.project.controller;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.filter.OrderDetailsFilter;
import com.learnup.project.service.OrderDetailsService;
import com.learnup.project.view.OrderDetailsView;
import com.learnup.project.view.mapper.OrderDetailsViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/order-details")
public class OrderDetailsController {
    
    private final OrderDetailsService orderDetailsService;
    private final OrderDetailsViewMapper orderDetailsViewMapper;
    
    @GetMapping
    public List<OrderDetailsView> getOrderDetails(
            @RequestParam(value = "order", required = false) Orders order,
            @RequestParam(value = "book", required = false) Books book,
            @RequestParam(value = "quantity", required = false) Long quantity,
            @RequestParam(value = "price", required = false) Long price
    ) {
        return orderDetailsService.getAllOrderDetails(new OrderDetailsFilter(order, book, quantity, price))
                .stream()
                .map(orderDetailsViewMapper::mapOrderDetailsToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public OrderDetailsView getOrderDetail(@PathVariable("id") Long id) {
        return orderDetailsViewMapper.mapOrderDetailsToView(orderDetailsService.getOrderDetailsById(id));
    }
    
    @PostMapping
    public OrderDetailsView createOrderDetails(@RequestBody OrderDetailsView orderDetailsView) {
        if (orderDetailsView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", orderDetailsView.getId())
            );
        }
        OrderDetails orderDetails = orderDetailsViewMapper.mapOrderDetailsFromView(orderDetailsView);
        OrderDetails createOrderDetails = orderDetailsService.createOrderDetails(orderDetails);
        return orderDetailsViewMapper.mapOrderDetailsToView(createOrderDetails);
    }
}
