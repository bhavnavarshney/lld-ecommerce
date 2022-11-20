package com.ecommerce.service.Impl;

import com.ecommerce.exceptions.EcommerceExceptions;
import com.ecommerce.model.ErrorCode;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.ErrorCodeMap;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(Product product) throws EcommerceExceptions {
        productRepository.createProduct(product);
        return product.getId();
    }

    @Override
    public Product getProduct(String productId) throws EcommerceExceptions {
        return productRepository.getProduct(productId);
    }

    @Override
    public boolean checkInventory(String productId, int quantity) throws EcommerceExceptions {
        synchronized (this){
            Product product = productRepository.getProduct(productId);
            if(quantity<=product.getQuantity()){
                product.setQuantity(product.getQuantity()-quantity);
                return true;
            }else{
                throw new EcommerceExceptions(ErrorCode.INSUFFICIENT_PRODUCT_QUANTITY, ErrorCodeMap.errorMap.get(ErrorCode.INSUFFICIENT_PRODUCT_QUANTITY));
            }
        }
    }
}
