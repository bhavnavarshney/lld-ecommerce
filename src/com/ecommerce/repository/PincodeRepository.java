package com.ecommerce.repository;

import com.ecommerce.model.PaymentMode;

import java.util.HashMap;

public class PincodeRepository {
    HashMap<String, HashMap<String, PaymentMode>> pincodes;

    public PincodeRepository() {
        this.pincodes = new HashMap<>();
    }

    public void createPincodeAvailability(String source, String destination, PaymentMode paymentMode){
        if(pincodes.containsKey(source)){
            pincodes.get(source).put(destination, paymentMode);
        }else{
            HashMap<String, PaymentMode> destinations = new HashMap<>();
            destinations.put(destination, paymentMode);
            pincodes.put(source, destinations);
        }
    }

    public HashMap<String, PaymentMode> getAllDestinationPincodes(String source){
        return pincodes.get(source);
    }
}
