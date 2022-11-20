package com.ecommerce.model;

public class PincodeAvailability {
    private String desination;
    private PaymentMode paymentMode;

    public PincodeAvailability(String desination, PaymentMode paymentMode) {
        this.desination = desination;
        this.paymentMode = paymentMode;
    }

    public String getDesination() {
        return desination;
    }

    public void setDesination(String desination) {
        this.desination = desination;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
