package com.learnup.project.mapper;

import com.learnup.project.dao.entity.Buyers;
import com.learnup.project.view.BuyersView;
import org.springframework.stereotype.Component;

@Component
public class BuyersViewMapper {
    
    public BuyersView mapBuyersToView(Buyers buyers) {
        BuyersView buyersView = new BuyersView();
        buyersView.setId(buyers.getId());
        buyersView.setFullName(buyers.getFullName());
        buyersView.setDateOfBirth(buyers.getDateOfBirth());
        return buyersView;
    }
    
    public Buyers mapBuyersToView(BuyersView buyersView) {
        Buyers buyers = new Buyers();
        buyers.setId(buyersView.getId());
        buyers.setFullName(buyersView.getFullName());
        buyers.setDateOfBirth(buyersView.getDateOfBirth());
        return buyers;
    }
    
}
