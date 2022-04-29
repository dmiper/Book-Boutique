package com.learnup.project.controller;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.entity.Orders;
import com.learnup.project.dao.entity.Users;
import com.learnup.project.dao.filter.BuyersFilter;
import com.learnup.project.service.BuyersService;
import com.learnup.project.service.UsersService;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.mapper.BuyersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("book-boutique/buyers")
public class BuyersController {
    
    private final BuyersService buyersService;
    private final UsersService usersService;
    private final BuyersViewMapper buyersViewMapper;
    
    @GetMapping
    public List<BuyersView> getBuyers(
            @RequestParam(value = "user", required = false) Users user,
            @RequestParam(value = "dateOfBirth", required = false) LocalDate dateOfBirth,
            @RequestParam(value = "dateRegistration", required = false) LocalDate dateRegistration,
            @RequestParam(value = "orders", required = false) List<Orders> orders,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return buyersService.getAllBuyers(new BuyersFilter(user, dateOfBirth, dateRegistration, orders, firstName, lastName))
                .stream()
                .map(buyersViewMapper::mapBuyersToView)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public BuyersView getBuyerById(@PathVariable("id") Long id) {
        return buyersViewMapper.mapBuyersToView(buyersService.getBuyersById(id));
    }
    
    @PostMapping
    public BuyersView createBuyer(@RequestBody BuyersView buyersView) {
        if (buyersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Buyers with id = %s already exist", buyersView.getId())
            );
        }
        Buyers buyers = buyersViewMapper.mapBuyersFromView(buyersView, usersService);
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
        if (!buyers.getDateOfBirth().equals(buyersView.getDateOfBirth())) {
            buyers.setDateOfBirth(buyersView.getDateOfBirth());
        }
        if (!buyers.getDateRegistration().equals(buyersView.getDateRegistration())) {
            buyers.setDateRegistration(buyersView.getDateRegistration());
        }
        if (!buyers.getFirstName().equals(buyersView.getFirstName())) {
            buyers.setFirstName(buyersView.getFirstName());
        }
        if (!buyers.getLastName().equals(buyersView.getLastName())) {
            buyers.setLastName(buyersView.getLastName());
        }
        Buyers updateBuyer = buyersService.updateBuyer(buyers);
        return buyersViewMapper.mapBuyersToView(updateBuyer);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteBuyer(@PathVariable("id") Long id) {
        return buyersService.deleteBuyer(id);
    }
    
}
