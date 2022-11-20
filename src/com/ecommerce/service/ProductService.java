package com.ecommerce.service;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.Product;

public interface ProductService {
    public String addProduct(Product product) throws EcommerceExceptions;
    public Product getProduct(String productId) throws EcommerceExceptions;
    public boolean checkInventory(String productId, int quantity) throws EcommerceExceptions;
}
