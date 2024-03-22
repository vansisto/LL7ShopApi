package com.vansisto.ll7shopapi.util;

public class ExceptionMessagesUtil {
    private static final String NOT_FOUND_MESSAGE = "with id '%s' wasn't found";

    public static final String PRODUCT_NOT_FOUND_MESSAGE = "Product ".concat(NOT_FOUND_MESSAGE);
    public static final String ORDER_NOT_FOUND_MESSAGE = "Order ".concat(NOT_FOUND_MESSAGE);
    public static final String CUSTOMER_NOT_FOUND_MESSAGE = "Customer ".concat(NOT_FOUND_MESSAGE);
}
