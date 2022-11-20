package com.ecommerce.service.Impl;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.ErrorCode;
import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.BuyerService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.PincodeService;
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.ErrorCodeMap;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    ProductService productService;
    BuyerService buyerService;
    PincodeService pincodeService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService, BuyerService buyerService, PincodeService pincodeService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.buyerService = buyerService;
        this.pincodeService = pincodeService;
    }

    @Override
    public String  addOrder(Order order) throws EcommerceExceptions {
         String  sourcePincode = productService.getProduct(order.getProductId()).getAddress().getPincode();
         String destinationPincode = buyerService.getBuyer(order.getBuyerId()).getAddress().getPincode();
         if(!pincodeService.checkIfSourceToDestinationExist(sourcePincode, destinationPincode, order.getPaymentMode())){
             throw new EcommerceExceptions(ErrorCode.PINCODE_SERVICE_UNAVAILABILITY, ErrorCodeMap.errorMap.get(ErrorCode.PINCODE_SERVICE_UNAVAILABILITY));
         }
         if(!productService.checkInventory(order.getProductId(), order.getQuantity())){
             throw new EcommerceExceptions(ErrorCode.ORDER_CREATION_FAILED, ErrorCodeMap.errorMap.get(ErrorCode.ORDER_CREATION_FAILED));
         }
         orderRepository.addOrder(order);
         return order.getId();
    }

    @Override
    public Order getOrder(String id) throws EcommerceExceptions {
        return orderRepository.getOrder(id);
    }
}
