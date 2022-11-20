package com.ecommerce.repository;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.ErrorCode;
import com.ecommerce.model.Product;
import com.ecommerce.utils.ErrorCodeMap;

import java.util.HashMap;


public class ProductRepository {
    HashMap<String, Product> products;

    public ProductRepository() {
        this.products = new HashMap<>();
    }

    public void createProduct(Product product) throws EcommerceExceptions {
        if(products.containsKey(product.getId())){
            throw new EcommerceExceptions(ErrorCode.PRODUCT_ALREADY_EXIST, ErrorCodeMap.errorMap.get(ErrorCode.PRODUCT_ALREADY_EXIST));
        }
        products.put(product.getId(), product);
    }

    public Product getProduct(String productId){
        return products.get(productId);
    }
}
