package com.learnup.project.controller;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.dao.filter.BuyersFilter;
import com.learnup.project.service.BuyersService;
import com.learnup.project.view.BuyersView;
import com.learnup.project.view.mapper.BuyersViewMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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
    private final BuyersViewMapper buyersViewMapper;

        @Secured({"ROLE_USER", "ROLE_ADMIN"})
        @GetMapping
    public List<BuyersView> getBuyers(
            @RequestParam(value = "dateOfBirth", required = false) LocalDate dateOfBirth,
            @RequestParam(value = "dateRegistration", required = false) LocalDate dateRegistration,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return buyersService.getAllBuyers(new BuyersFilter(dateOfBirth, dateRegistration, firstName, lastName))
                .stream()
                .map(buyersViewMapper::mapBuyersToView)
                .collect(Collectors.toList());
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{id}")
    public BuyersView getBuyerById(@PathVariable("id") Long id) {
        return buyersViewMapper.mapBuyersToView(buyersService.getBuyersById(id));
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public BuyersView createBuyer(@RequestBody BuyersView buyersView) {
        if (buyersView.getId() != null) {
            throw new EntityExistsException(
                    String.format("Buyers with id = %s already exist", buyersView.getId())
            );
        }
        Buyers buyers = buyersViewMapper.mapBuyersFromView(buyersView);
        Buyers createBuyers = buyersService.createBuyer(buyers);
        return buyersViewMapper.mapBuyersToView(createBuyers);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
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

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public Boolean deleteBuyer(@PathVariable("id") Long id) {
        return buyersService.deleteBuyer(id);
    }
    
}
