package com.ecommerce.repository;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.ErrorCode;
import com.ecommerce.model.Order;
import com.ecommerce.utils.ErrorCodeMap;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;

public class OrderRepository {
    HashMap<String, Order> orderHashMap;

    public OrderRepository() {
        this.orderHashMap = new HashMap<>();
    }

    public void addOrder(Order order) throws EcommerceExceptions {
        if(orderHashMap.containsKey(order.getId())){
            throw new EcommerceExceptions(ErrorCode.ORDER_CREATION_FAILED, ErrorCodeMap.errorMap.get(ErrorCode.ORDER_CREATION_FAILED));
        }
        orderHashMap.put(order.getId(), order);
    }

    public Order getOrder(String orderId){
        return orderHashMap.get(orderId);
    }
}
