package com.ecommerce.repository;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.Buyer;
import com.ecommerce.model.ErrorCode;
import com.ecommerce.utils.ErrorCodeMap;

import java.util.HashMap;

public class BuyerRepository {
    private HashMap<String, Buyer> buyerHashMap;

    public BuyerRepository() {
        this.buyerHashMap = new HashMap<>();
    }

    public void addBuyer(Buyer buyer) throws EcommerceExceptions {
        if(buyerHashMap.containsKey(buyer.getId())){
            throw new EcommerceExceptions(ErrorCode.BUYER_CREATION_FAILED, ErrorCodeMap.errorMap.get(ErrorCode.BUYER_CREATION_FAILED));
        }
        buyerHashMap.put(buyer.getId(), buyer);
    }

    public Buyer getBuyer(String id){
        return buyerHashMap.get(id);
    }
}
