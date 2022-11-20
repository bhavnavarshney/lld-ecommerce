package com.ecommerce;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.*;
import com.ecommerce.repository.BuyerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.PincodeRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.Impl.BuyerServiceImpl;
import com.ecommerce.service.Impl.OrderServiceImpl;
import com.ecommerce.service.Impl.PincodeServiceImpl;
import com.ecommerce.service.Impl.ProductServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

public class Main {

    public static void main(String[] args) throws EcommerceExceptions {
        BuyerRepository buyerRepository = new BuyerRepository();
        OrderRepository orderRepository = new OrderRepository();
        PincodeRepository pincodeRepository = new PincodeRepository();
        ProductRepository productRepository = new ProductRepository();

        BuyerServiceImpl buyerService = new BuyerServiceImpl(buyerRepository);
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);
        PincodeServiceImpl pincodeService = new PincodeServiceImpl(pincodeRepository);
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepository, productService, buyerService, pincodeService);

        Address address1 = new Address("Rutu park", "Mumbai", "India", "10304");
        Address address2 = new Address("Camrin Road", "Hyderabad", "India", "10501");
        Address address3 = new Address("House 45", "Bangalore", "India", "10602");

        Buyer buyer1 = new Buyer("Paul", address2);
        Buyer buyer2 = new Buyer("Amit", address3);
        Buyer buyer3 = new Buyer("Mahesh", address1);

        String buyerId1 = buyerService.addBuyer(buyer1);
        String buyerId2 = buyerService.addBuyer(buyer2);
        String buyerId3 = buyerService.addBuyer(buyer3);


        Product product1 = new Product("Mattress", "Rooms", 10, address3);
        Product product2 = new Product("Dress", "Clothing", 5, address3);
        Product product3 = new Product("Kurta", "Clothing", 20, address2);
        Product product4 = new Product("Kajal", "Makeup", 30, address3);
        Product product5 = new Product("Shirts", "Shoes", 50, address2);

        String productId1 = productService.addProduct(product1);
        String productId2 = productService.addProduct(product2);
        String productId3 = productService.addProduct(product3);
        String productId4 = productService.addProduct(product4);
        String productId5 = productService.addProduct(product5);

        pincodeService.createPincodeService("10304", "10602", PaymentMode.CARD);
        pincodeService.createPincodeService("10304", "10501", PaymentMode.UPI);
        pincodeService.createPincodeService("10501", "10602", PaymentMode.CARD);
        pincodeService.createPincodeService("10602", "10304", PaymentMode.CASH);
        pincodeService.createPincodeService("10602", "10501", PaymentMode.CARD);

        Order order1=  new Order(productId1, buyerId1, 7, PaymentMode.CARD);
        Order order2=  new Order(productId3, buyerId2, 25, PaymentMode.UPI);
        Order order3=  new Order(productId5, buyerId3, 3, PaymentMode.CARD);
        Order order4 = new Order(productId1, buyerId1, 8, PaymentMode.CARD);

        try{
            String orderId = orderService.addOrder(order1);
            System.out.println("Order 1 placed successfully. Id: "+orderId);

            orderId = orderService.addOrder(order4);
            System.out.println("Order 4 placed successfully again. Id: "+orderId);

            orderId = orderService.addOrder(order3);
            System.out.println("Order 3 placed successfully. Id: "+orderId);
        }catch (EcommerceExceptions e){
            System.out.println("Exception: "+e.getErrorCode()+" "+e.getErrorMessage());
        }

        try{
            String orderId = orderService.addOrder(order2);
            System.out.println("Order 2 placed successfully. Id: "+orderId);
        }catch (EcommerceExceptions e){
            System.out.println("Exception: "+e.getErrorCode()+" "+e.getErrorMessage());
        }

     }
}

/*
Requirement:
1. Add product
2. Add buyer
3. Check inventory
4. Pincode service availability
5. Create order

Product
id, name, type, price, availability, quantity

Buyer
id, name

Order
id, name, address,
createOrder()
cancelOrder()
checkInventory()



 */