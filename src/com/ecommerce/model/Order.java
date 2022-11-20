package com.ecommerce.model;

import com.ecommerce.utils.Utils;

import java.util.List;

public class Order {
    private String id;
    private String productId;
    private String buyerId;
    private int quantity;
    private PaymentMode paymentMode;

    public Order(String productId, String buyerId, int quantity, PaymentMode paymentMode) {
        this.id = Utils.getUUID();
        this.productId = productId;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
