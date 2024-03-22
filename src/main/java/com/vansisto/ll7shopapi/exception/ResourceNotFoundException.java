package com.vansisto.ll7shopapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message, Object... formatArgs) {
        super(message.formatted(formatArgs));
    }
}
