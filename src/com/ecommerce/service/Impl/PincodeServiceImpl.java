package com.ecommerce.service.Impl;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.PaymentMode;
import com.ecommerce.repository.PincodeRepository;
import com.ecommerce.service.PincodeService;

import java.util.HashMap;

public class PincodeServiceImpl implements PincodeService {
    PincodeRepository pincodeRepository;

    public PincodeServiceImpl(PincodeRepository pincodeRepository) {
        this.pincodeRepository = pincodeRepository;
    }

    @Override
    public void createPincodeService(String source, String destination, PaymentMode paymentMode) throws EcommerceExceptions {
        pincodeRepository.createPincodeAvailability(source, destination, paymentMode);
    }

    @Override
    public boolean checkIfSourceToDestinationExist(String source, String destination, PaymentMode paymentMode) throws EcommerceExceptions {
        HashMap<String, PaymentMode> maps = pincodeRepository.getAllDestinationPincodes(source);
        return maps.containsKey(destination) && paymentMode.equals(maps.get(destination));
    }
}
