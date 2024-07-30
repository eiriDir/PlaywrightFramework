package org.example.enums;

public enum ErrorMessages {
    NEW_PASSWORD_IS_NOT_SEND("New password is not send."),
    ELEMENTS_IS_NOT_DISPLAYED("Elements is not displayed."),
    LOGIN_FAILED("Login failed."),
    CHECKOUT_FAILED("Checkout failed."),
    FILTERING_FAILED("Filtering error."),
    PRODUCT_ATTRIBUTES_VALIDATION_FAILED("Product attributes are not valid.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
