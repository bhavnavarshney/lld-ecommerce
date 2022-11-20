package com.ecommerce.service;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.PaymentMode;

public interface PincodeService {
    public void createPincodeService(String source, String destination, PaymentMode paymentMode) throws EcommerceExceptions;
    public boolean checkIfSourceToDestinationExist(String source, String destination, PaymentMode paymentMode) throws EcommerceExceptions;
}
