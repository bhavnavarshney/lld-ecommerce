package com.ecommerce.utils;

import com.ecommerce.model.ErrorCode;
import java.util.HashMap;

public class ErrorCodeMap {
    public static HashMap<ErrorCode, String> errorMap = new HashMap<>();
    static {
        errorMap.put(ErrorCode.ORDER_CREATION_FAILED, "Failed to place order");
        errorMap.put(ErrorCode.INSUFFICIENT_PRODUCT_QUANTITY, "Insufficient product quantity");
        errorMap.put(ErrorCode.PINCODE_SERVICE_UNAVAILABILITY, "Product not available for this pincode");
        errorMap.put(ErrorCode.PRODUCT_ALREADY_EXIST, "Product already exist");
        errorMap.put(ErrorCode.PRODUCT_CREATION_FAILED, "Failed to create product");
        errorMap.put(ErrorCode.BUYER_CREATION_FAILED, "Failed to create buyer");
    }
}
