package com.learnup.project.controller;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.entity.OrderDetails;
import com.learnup.project.dao.filter.OrderDetailsFilter;
import com.learnup.project.service.BooksService;
import com.learnup.project.service.OrderDetailsService;
import com.learnup.project.view.OrderDetailsView;
import com.learnup.project.view.mapper.OrderDetailsViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("book-boutique/order-details")
public class OrderDetailsController {
    
    private final OrderDetailsService orderDetailsService;
    private final BooksService booksService;
    private final OrderDetailsViewMapper orderDetailsViewMapper;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping
    public List<OrderDetailsView> getOrderDetails(
            @RequestParam(value = "book", required = false) Books book,
            @RequestParam(value = "quantity", required = false) Long quantity,
            @RequestParam(value = "price", required = false) Long price
    ) {
        return orderDetailsService.getAllOrderDetails(new OrderDetailsFilter(book, quantity, price))
                .stream()
                .map(orderDetailsViewMapper::mapOrderDetailsToView)
                .collect(Collectors.toList());
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{id}")
    public OrderDetailsView getOrderDetailById(@PathVariable("id") Long id) {
        return orderDetailsViewMapper.mapOrderDetailsToView(orderDetailsService.getOrderDetailsById(id));
    }

    @Secured({"ROLE_USER"})
    @PostMapping
    public OrderDetailsView createOrderDetail(@RequestBody OrderDetailsView orderDetailsView) {
        if (orderDetailsView.getId() != null) {
            throw new EntityExistsException(
                    String.format("OrderDetails with id = %s already exist", orderDetailsView.getId())
            );
        }
        OrderDetails orderDetails = orderDetailsViewMapper.mapOrderDetailsFromView(orderDetailsView, booksService);
        OrderDetails createOrderDetails = orderDetailsService.createOrderDetails(orderDetails);
        return orderDetailsViewMapper.mapOrderDetailsToView(createOrderDetails);
    }

    @Secured({"ROLE_USER"})
    @PutMapping("/{id}")
    public OrderDetailsView updateOrderDetail(@PathVariable("id") Long id,
                                              @RequestBody OrderDetailsView orderDetailsView) {
        if (orderDetailsView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, orderDetailsView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        OrderDetails orderDetails = orderDetailsService.getOrderDetailsById(id);
        if (!orderDetails.getPrice().equals(orderDetailsView.getPrice())) {
            orderDetails.setPrice(orderDetailsView.getPrice());
        }
        if (!orderDetails.getQuantity().equals(orderDetailsView.getQuantity())) {
            orderDetails.setQuantity(orderDetailsView.getQuantity());
        }
        OrderDetails updateAuthor = orderDetailsService.updateOrderDetail(orderDetails);
        return orderDetailsViewMapper.mapOrderDetailsToView(updateAuthor);
    }


    @Secured({"ROLE_USER"})
    @DeleteMapping("/{id}")
    public Boolean deleteOrderDetail(@PathVariable("id") Long id) {
        return orderDetailsService.deleteOrderDetail(id);
    }

}
