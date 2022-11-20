package com.ecommerce.service;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.Order;

public interface OrderService {
    public String addOrder(Order order) throws EcommerceExceptions;
    public Order getOrder(String id) throws EcommerceExceptions;
}
