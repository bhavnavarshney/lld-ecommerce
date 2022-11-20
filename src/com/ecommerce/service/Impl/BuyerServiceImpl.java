package com.ecommerce.service.Impl;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.Buyer;
import com.ecommerce.repository.BuyerRepository;
import com.ecommerce.service.BuyerService;

public class BuyerServiceImpl implements BuyerService {
    BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public String addBuyer(Buyer buyer) throws EcommerceExceptions {
        buyerRepository.addBuyer(buyer);
        return buyer.getId();
    }

    @Override
    public Buyer getBuyer(String buyerId) throws EcommerceExceptions {
        return buyerRepository.getBuyer(buyerId);
    }
}
