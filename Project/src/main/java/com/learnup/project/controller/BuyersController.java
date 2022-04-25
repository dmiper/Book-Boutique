package com.learnup.project.controller;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.BuyersFilter;
import com.learnup.project.service.BuyersService;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.mapper.BuyersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/buyers")
public class BuyersController {
    
    private final BuyersService buyersService;
    private final BuyersViewMapper buyersViewMapper;
    
    @GetMapping
    public List<BuyersView> getBuyers(
            @RequestParam(value = "user", required = false) Users user,
            @RequestParam(value = "dateOfBirth", required = false) LocalDate dateOfBirth,
            @RequestParam(value = "orders", required = false) Collection<Orders> orders
    ) {
        return buyersService.getAllBuyers(new BuyersFilter(user, dateOfBirth, orders))
                .stream()
                .map(buyersViewMapper::mapBuyersToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BuyersView getBuyer(@PathVariable("id") Long id) {
        return buyersViewMapper.mapBuyersToView(buyersService.getBuyersById(id));
    }
    
    @PostMapping
    public BuyersView createBuyer(@RequestBody BuyersView buyersView) {
        if (buyersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Books with id = %s already exist", buyersView.getId())
            );
        }
        Buyers buyers = buyersViewMapper.mapBuyersFromView(buyersView);
        Buyers createBuyers = buyersService.createBuyer(buyers);
        return buyersViewMapper.mapBuyersToView(createBuyers);
    }
    
    @PutMapping("/{id}")
    public BuyersView updateBuyer(@PathVariable("id") Long id,
                                    @RequestBody BuyersView buyersView) {
        if (buyersView.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, buyersView.getId())) {
            throw new RuntimeException("Entity has bad id");
        }
        Buyers buyers = buyersService.getBuyersById(id);
        /*if (!buyers.getOrders().equals(buyersView.getOrdersViews())) {
            buyers.setOrders(buyersView.getOrders());
        }*/
        if (!buyers.getUser().equals(buyersView.getUser())) {
            buyers.setUser(buyersView.getUser());
        }
        if (!buyers.getDateOfBirth().equals(buyersView.getDateOfBirth())) {
            buyers.setDateOfBirth(buyersView.getDateOfBirth());
        }
        Buyers updateBuyer = buyersService.updateBuyer(buyers);
        return buyersViewMapper.mapBuyersToView(updateBuyer);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteBuyer(@PathVariable("id") Long id) {
        return buyersService.deleteBuyer(id);
    }
    
}
