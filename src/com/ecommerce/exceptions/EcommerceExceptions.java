package com.ecommerce.exceptions;

import com.ecommerce.model.ErrorCode;

public class EcommerceExceptions extends Exception {
    ErrorCode errorCode;
    String errorMessage;

    public EcommerceExceptions(ErrorCode errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
