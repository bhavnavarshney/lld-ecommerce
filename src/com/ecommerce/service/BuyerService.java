package com.ecommerce.service;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.Buyer;

public interface BuyerService {
    public String addBuyer(Buyer buyer) throws EcommerceExceptions;
    public Buyer getBuyer(String buyerId) throws EcommerceExceptions;
}
