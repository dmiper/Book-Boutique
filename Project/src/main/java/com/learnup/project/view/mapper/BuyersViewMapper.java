package com.learnup.project.view.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.view.BuyersView;
import org.springframework.stereotype.Component;

@Component
public class BuyersViewMapper {
    
    public BuyersView mapBuyersToView(Buyers buyers) {
        BuyersView buyersView = new BuyersView();
        buyersView.setId(buyers.getId());
        buyersView.setDateRegistration(buyers.getDateRegistration());
        buyersView.setDateOfBirth(buyers.getDateOfBirth());
        buyersView.setFirstName(buyers.getFirstName());
        buyersView.setLastName(buyers.getLastName());
        return buyersView;
    }
    
    public Buyers mapBuyersFromView(BuyersView buyersView) {
        Buyers buyers = new Buyers();
        buyers.setId(buyersView.getId());
        buyers.setDateOfBirth(buyersView.getDateOfBirth());
        buyers.setDateRegistration(buyersView.getDateRegistration());
        buyers.setFirstName(buyersView.getFirstName());
        buyers.setLastName(buyersView.getLastName());
        return buyers;
    }
    
}
